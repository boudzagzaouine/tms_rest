package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Address;
import com.sinno.ems.dto.Owner;
import com.sinno.ems.entities.OwnOwner;
import com.sinno.ems.entities.PrmMsgSend;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.export.OwnerExport;
import com.sinno.ems.mapper.AddressMapper;
import com.sinno.ems.mapper.OwnerMapper;
import com.sinno.ems.mapperWms.MapperOwner;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.OwnerService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerOwner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private InvoiceDataRepository invoiceDataRepository;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(OwnerService.class);
    @Autowired
    private SettingRepository settingRepository;


    @Override
    public Owner save(Owner owner) {
        LOGGER.info("save Owner");
        owner.setUpdateDate(EmsDate.getDateNow());
        if (0 >= owner.getId()) {
            owner.setCreationDate(EmsDate.getDateNow());
        }
        OwnOwner own = OwnerMapper.toEntity(owner, false);
        OwnOwner ownOwner = ownerRepository.saveAndFlush(own);
        Owner ownerr = OwnerMapper.toDto(ownOwner, false);
        boolean syncWms = settingRepository.findOne(2L).getPrmSettingValue().equals("1") ? true : false;
        if (syncWms) {
            PrmMsgSend msgSend = getPrmMsgSend();

            if (null != msgSend && msgSend.isPrmMsgSendActive()) {
                OwnerExport.export(msgSend.getPrmMsgSendPath(), ownOwner, "F", servletContext);
            }

            if (null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {
                writeFileOwner(msgSend.getPrmMsgSendPath(), owner);
                writeFileOwner(msgSend.getPrmMsgSendArcPath(), owner);
            }
        }
        return ownerr;
    }

    private PrmMsgSend getPrmMsgSend() {
        PrmMsgSend msgSend;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:OWN", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()) {
                if (msgSends.iterator().hasNext()) {
                    msgSend = msgSends.iterator().next();
                    return msgSend;
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return null;
    }

    private void writeFileOwner(String path, Owner ow) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            com.sinno.wms.crud.modelbasic.owners.Owner owner = com.sinno.ems.mapperWms.MapperOwner.convertToWmsDto(ow);
            ConvertManagerOwner.writeFileOwner(path + File.separator + "IWN01" + dateFormat.format(new Date()) + ".xls", langue, owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFileOwner(String path, List<Owner> owners) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            List<com.sinno.wms.crud.modelbasic.owners.Owner> ownerList = new ArrayList<>();
            for (Owner ow : owners) {
                ownerList.add(com.sinno.ems.mapperWms.MapperOwner.convertToWmsDto(ow));
            }
            ConvertManagerOwner.writeFileOwner(path + File.separator + "IWN01" + dateFormat.format(new Date()) + ".xls", langue, ownerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFileOwner(com.sinno.wms.crud.modelbasic.owners.Owner own) {
        try {
            own = ConvertManagerOwner.readFileOwner("IWN01.xls").get(0);
            Owner owner = new Owner();
            owner = MapperOwner.convertToEmsDto(owner, own);
            ownerRepository.saveAndFlush(OwnerMapper.toEntity(owner, false));

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
        return ownerRepository.exists(id);
    }

    @Override
    public Owner findById(Long id) throws IdNotFound {
        Owner owner = OwnerMapper.toDto(ownerRepository.findOne(id), false);
        if (null != owner) {
            return owner;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Owner> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }

        return OwnerMapper.toDtos(ownerRepository.findAll(Search.expression(search, OwnOwner.class)), false);
    }

    @Override
    public List<Owner> findAllForHabilitation() throws AttributesNotFound, ErrorType {
        return OwnerMapper.toDtos(ownerRepository.findAll(), false);

    }

    @Override
    public List<Owner> find(String search, int page, int size) throws AttributesNotFound, ErrorType {

        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "ownOwnerUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return OwnerMapper.toDtos(ownerRepository.findAll(Search.expression(search, OwnOwner.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return ownerRepository.count(Search.expression(search, OwnOwner.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Owner");
        OwnOwner ownOwner = ownerRepository.findOne(id);
        ownOwner.setOwnOwnerIsActive(false);
        ownerRepository.saveAndFlush(ownOwner);
    }

    @Override
    public void delete(Owner owner) {
        LOGGER.info("delete Owner");
        OwnOwner ownOwner = ownerRepository.findOne(owner.getId());
        ownOwner.setOwnOwnerIsActive(false);
        ownerRepository.saveAndFlush(ownOwner);
        //ownerRepository.delete(OwnerMapper.toEntity(owner, false));

        PrmMsgSend msgSend = null;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:OWN", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()) {
                msgSend = msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        if (null != msgSend && msgSend.isPrmMsgSendActive()) {
            OwnerExport.export(msgSend.getPrmMsgSendPath(), ownOwner, "M", servletContext);
        }
    }

    @Override
    public List<Owner> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Owner> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return find("", page, size);
    }

    @Override
    public Owner loadWmsOwner(com.sinno.wms.crud.modelbasic.owners.Owner owner) {
        Owner emsOwner = OwnerMapper.toDto(ownerRepository.findByOwnOwnerCode(owner.getOwner_code()), false);
        Address address = AddressMapper.toDto(addressRepository.findByAdrAddressCode(owner.getAddress_name()), false);

        if (null == emsOwner) {
            emsOwner = new Owner();
            emsOwner.setCreationDate(EmsDate.getDateNow());
        }
        if (null == address) {
            address = new Address();
            address.setCode(owner.getAddress_name());
            address.setCreationDate(EmsDate.getDateNow());
            address.setUpdateDate(EmsDate.getDateNow());
            address.setZip(owner.getPostal_code());
            address.setLine1(owner.getAddress_line1());
            address.setLine2(owner.getAddress_line2());
            address.setCity(owner.getCity());
            address.setCountry(owner.getCountry());
            address = AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
        }
        if (null != emsOwner) {
            emsOwner = MapperOwner.convertToEmsDto(emsOwner, owner);
            emsOwner.setUpdateDate(EmsDate.getDateNow());
            emsOwner.setAddress(address);
            emsOwner = OwnerMapper.toDto(ownerRepository.saveAndFlush(OwnerMapper.toEntity(emsOwner, false)), false);
            address.setOwner(emsOwner);
            address = AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
            return emsOwner;
        }
        return null;

    }

    @Override
    public List<Owner> exportWmsOwner(List<Owner> owners) {
        writeFileOwner(null != getPrmMsgSend() ? getPrmMsgSend().getPrmMsgSendPath() : System.getenv("APPDATA"), owners);
        return owners;
    }

    @Override
    public String getLastInvoiceDate(Long id) {
        Owner owner = OwnerMapper.toDto(ownerRepository.findOne(id), false);
        List maxDates = invoiceDataRepository.getMaxDate(id);
        Date dateStart = maxDates.size() > 0 ? (Date) maxDates.get(0) : owner.getCreationDate();
        SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyyMMdd");

        return oDateFormat.format(dateStart);
    }

}