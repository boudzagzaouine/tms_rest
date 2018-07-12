package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.OwnOwner;
import com.sinno.ems.entities.TrpTransport;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.export.TransportExport;
import com.sinno.ems.mapper.AddressMapper;
import com.sinno.ems.mapper.ContactMapper;
import com.sinno.ems.mapper.OwnerMapper;
import com.sinno.ems.mapper.TransportMapper;
import com.sinno.ems.mapperWms.MapperCarrer;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.TransportService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerCarrier;
import com.sinno.wms.crud.modelbasic.carriers.Carrier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private MsgSendRepository msgSendRepository;

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private SettingRepository settingRepository;
   private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS") ;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(TransportService.class);


    @Override
    public Transport save(Transport transport) {
        LOGGER.info("save Transport");
        transport.setUpdateDate(EmsDate.getDateNow());
        if (0 >= transport.getId()) {
            transport.setCreationDate(EmsDate.getDateNow());
        }
        TrpTransport trp = TransportMapper.toEntity(transport, false);
        TrpTransport trpTransport = transportRepository.saveAndFlush(trp);
        Transport transportt = TransportMapper.toDto(trpTransport, false);
        boolean syncWms = settingRepository.findOne(2L).getPrmSettingValue().equals("1") ? true : false;
        if (syncWms) {
            PrmMsgSend msgSend = null;
            msgSend = getPrmMsgSend();
            if (null != msgSend && msgSend.isPrmMsgSendActive()) {
                TransportExport.export(msgSend.getPrmMsgSendPath(), trpTransport, "F", servletContext);
            }

            if (null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {

                writeFileTransport(msgSend.getPrmMsgSendPath(), transport);
                writeFileTransport(msgSend.getPrmMsgSendArcPath(), transport);
            }
        }
        return transportt;
    }

    private PrmMsgSend getPrmMsgSend() {
        PrmMsgSend msgSend ;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:CAR", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()) {
                if (msgSends.iterator().hasNext()) {
                    return msgSends.iterator().next();
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    private void writeFileTransport(String path,Transport tran) {
        try {
            //   String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path= path.replace("\\", File.separator);
            String langue="FR";
            com.sinno.wms.crud.modelbasic.carriers.Carrier transport = com.sinno.ems.mapperWms.MapperCarrer.convertToWmsDto(tran);
            ConvertManagerCarrier.writeFileCarrier(path+File.separator+"IAG01"+dateFormat.format(new Date())+".xls",langue, transport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFileTransport(String path,List<Transport> transports) {
        try {
            //   String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path= path.replace("\\", File.separator);
            String langue="FR";
            List<Carrier> carrierlist = new ArrayList<>();
            for (Transport tran:transports ) {
                carrierlist.add(com.sinno.ems.mapperWms.MapperCarrer.convertToWmsDto(tran));
            }
            ConvertManagerCarrier.writeFileCarrier(path+File.separator+"IAG01"+dateFormat.format(new Date())+".xls",langue, carrierlist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void readFileTransport(com.sinno.wms.crud.modelbasic.carriers.Carrier car) {

        try {
            car = ConvertManagerCarrier.readFileCarrier("IAG01.xls").get(0);
            Transport transport = new Transport();
            transport = MapperCarrer.convertToEmsDto(transport,car);
            transportRepository.saveAndFlush(TransportMapper.toEntity(transport, false));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long size() {
        try {
            return size("");
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return transportRepository.exists(id);
    }

    @Override
    public Transport findById(Long id) throws IdNotFound {
        Transport transport = TransportMapper.toDto(transportRepository.findOne(id), false);
        if (null != transport) {
            return transport;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Transport> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(search, TrpTransport.class)), false);
    }

    @Override
    public List<Transport> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "trpTransportUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(search, TrpTransport.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return transportRepository.count(Search.expression(search, TrpTransport.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Transport");
        TrpTransport trpTransport = transportRepository.findOne(id);
        trpTransport.setTrpTransportIsActive(false);
        transportRepository.saveAndFlush(trpTransport);
    }

    @Override
    public void delete(Transport transport) {
        LOGGER.info("delete Transport");
        TrpTransport trpTransport = transportRepository.findOne(transport.getId());
        trpTransport.setTrpTransportIsActive(false);
        transportRepository.saveAndFlush(trpTransport);
        //transportRepository.delete(TransportMapper.toEntity(transport, false));

        PrmMsgSend msgSend = null;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:CAR", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()) {
                msgSend = msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        if (null != msgSend && msgSend.isPrmMsgSendActive()) {
            TransportExport.export(msgSend.getPrmMsgSendPath(), trpTransport, "M", servletContext);
        }
    }

    @Override
    public List<Transport> findAll() {
        return TransportMapper.toDtos(transportRepository.findAll(), false);
    }

    @Override
    public List<Transport> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return find("", page, size);
    }

    @Transactional
    @Override
    public Transport loadWmsTransport(com.sinno.wms.crud.modelbasic.carriers.Carrier carrier) {
        Transport emsTransport = TransportMapper.toDto(transportRepository.findByTrpTransportCode(carrier.getCarrier_Code()), false);
        Contact contact = ContactMapper.toDto(contactRepository.findByPrmContactName(carrier.getContact_Name()), false);
        Address address = AddressMapper.toDto(addressRepository.findByAdrAddressCode(carrier.getAddress()), false);
        String s="name:"+carrier.getContact_Name()+",surName:"+carrier.getContact_surName()+",email:"+carrier.getContact_mail();
        Owner owner = null;
        try {
            owner = OwnerMapper.toDto(ownerRepository.findOne(Search.expression("organisation.id:1", OwnOwner.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        if (null == emsTransport) {
            emsTransport = new Transport();
            emsTransport.setCreationDate(EmsDate.getDateNow());
        }
        if (null == contact) {
            contact = new Contact();
            contact.setName(carrier.getContact_Name());
            contact.setActive(true);
            contact.setCreationDate(EmsDate.getDateNow());
            contact.setUpdateDate(EmsDate.getDateNow());
            contact.setSurName(carrier.getContact_surName());
            contact.setTel1(carrier.getTelephone());
            contact.setTel2(carrier.getContact_second_phone());
            contact.setContactType(1L);
            contact.setFax(carrier.getFax());
            contact.setOwner(owner);
            contact = ContactMapper.toDto(contactRepository.saveAndFlush(ContactMapper.toEntity(contact, false)), false);
        }
        if (null == address) {
            address = new Address();
            address.setCode(carrier.getAddress());
            address.setCreationDate(EmsDate.getDateNow());
            address.setUpdateDate(EmsDate.getDateNow());
            address.setZip(carrier.getPostal_Code());
            address.setLine1(carrier.getAddress_line1());
            address.setLine2(carrier.getAddress_line2());
            address.setCity(carrier.getCity());
            address.setCountry(carrier.getCountry());
            address.setOwner(owner);
            address = AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
        }
        if (null != emsTransport) {
            emsTransport = MapperCarrer.convertToEmsDto(emsTransport, carrier);

            emsTransport.setAddress(address);
            emsTransport.setContact(contact);
            emsTransport.setActive(true);
            emsTransport = TransportMapper.toDto(transportRepository.saveAndFlush(TransportMapper.toEntity(emsTransport, false)), false);
            return emsTransport;
        }
        return null;
    }

    @Override
    public List<Transport> exportWmsTransport(List<Transport> transports) {
        writeFileTransport(null != getPrmMsgSend()? getPrmMsgSend().getPrmMsgSendPath() : "wms", transports);
        return transports;
    }
}