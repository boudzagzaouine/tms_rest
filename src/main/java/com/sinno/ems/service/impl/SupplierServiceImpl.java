package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.PrmContact;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.export.SupplierExport;
import com.sinno.ems.mapper.AddressMapper;
import com.sinno.ems.mapper.ContactMapper;
import com.sinno.ems.mapper.OwnerMapper;
import com.sinno.ems.mapper.SupplierMapper;
import com.sinno.ems.mapperWms.MapperSupplier;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.SupplierService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.io.File;
import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private SettingRepository settingRepository;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierService.class);


    @Override
    public Supplier save(Supplier supplier) {
        LOGGER.info("save Supplier");
        supplier.setUpdateDate(EmsDate.getDateNow());
        if (0 >= supplier.getId()) {
            supplier.setCreationDate(EmsDate.getDateNow());
        }
        RcpSupplier rcpSupplier = supplierRepository.saveAndFlush(SupplierMapper.toEntity(supplier, false));
        supplier = SupplierMapper.toDto(rcpSupplier, false);
        boolean syncWms = settingRepository.findOne(2L).getPrmSettingValue().equals("1") ? true : false;
        if (syncWms) {
            PrmMsgSend msgSend = getPrmMsgSend();
            try {
                Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:SUP", PrmMsgSend.class));
                if (null != msgSends && null != msgSends.iterator() && msgSends.iterator().hasNext()) {
                    msgSend = msgSends.iterator().next();
                }
            } catch (AttributesNotFound attributesNotFound) {
                //attributesNotFound.printStackTrace();
            } catch (ErrorType errorType) {
                //e.printStackTrace();
            }
            if (null != msgSend && msgSend.isPrmMsgSendActive()) {
                SupplierExport.export(msgSend.getPrmMsgSendPath(), rcpSupplier, "F", servletContext);
            }

            if (null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {

                writeFileSupplier(msgSend.getPrmMsgSendPath(), supplier);
                writeFileSupplier(msgSend.getPrmMsgSendArcPath(), supplier);
            }
        }
        return supplier;
    }

    private PrmMsgSend getPrmMsgSend() {
        PrmMsgSend msgSend;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:SUP", PrmMsgSend.class));
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

    private void writeFileSupplier(String path, Supplier sup) {
        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            com.sinno.wms.crud.modelbasic.suppliers.Supplier supplier = MapperSupplier.convertToWmsDto(sup);
            ConvertManagerSupplier.writeFileSupplier(path + File.separator + "ISU01" + dateFormat.format(new Date()) + ".xls", langue, supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeFileSupplier(String path, List<Supplier> suppliers) {
        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            List<com.sinno.wms.crud.modelbasic.suppliers.Supplier> supplierList = new ArrayList<>();
            for (Supplier sup : suppliers) {
                supplierList.add(MapperSupplier.convertToWmsDto(sup));
            }
            ConvertManagerSupplier.writeFileSupplier(path + File.separator + "ISU01" + dateFormat.format(new Date()) + ".xls", langue, supplierList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readFileSupplier(com.sinno.wms.crud.modelbasic.suppliers.Supplier sup) {

        try {
            sup = ConvertManagerSupplier.readFileSupplier("ISU01.xls").get(0);
            Supplier supplier = new Supplier();
            supplier = MapperSupplier.convertToEmsDto(supplier, sup);
            supplierRepository.saveAndFlush(SupplierMapper.toEntity(supplier, false));

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
        return supplierRepository.exists(id);
    }

    @Override
    public Supplier findById(Long id) throws IdNotFound {
        Supplier supplier = SupplierMapper.toDto(supplierRepository.findOne(id), false);
        if (null != supplier) {
            return supplier;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Supplier> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return SupplierMapper.toDtos(supplierRepository.findAll(Search.expression(search, RcpSupplier.class)), false);
    }

    @Override
    public List<Supplier> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "rcpSupplierUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return SupplierMapper.toDtos(supplierRepository.findAll(Search.expression(search, RcpSupplier.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return supplierRepository.count(Search.expression(search, RcpSupplier.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Supplier");
        RcpSupplier rcpSupplier = supplierRepository.findOne(id);
        rcpSupplier.setRcpSupplierIsActive(false);
        supplierRepository.saveAndFlush(rcpSupplier);
    }

    @Override
    public void delete(Supplier supplier) {
        LOGGER.info("delete Supplier");
        RcpSupplier rcpSupplier = supplierRepository.findOne(supplier.getId());
        rcpSupplier.setRcpSupplierIsActive(false);
        supplierRepository.saveAndFlush(rcpSupplier);
        //supplierRepository.delete(SupplierMapper.toEntity(supplier, false));
        PrmMsgSend msgSend = null;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:SUP", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator() && msgSends.iterator().hasNext()) {
                msgSend = msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        if (null != msgSend && msgSend.isPrmMsgSendActive()) {
            SupplierExport.export(servletContext.getRealPath("/WEB-INF/classes"), rcpSupplier, "M", servletContext);
        }
    }

    @Override
    public List<Supplier> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Supplier> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return find("", page, size);
    }

    @Override
    @Transactional
    public Supplier loadWmsSupplier(com.sinno.wms.crud.modelbasic.suppliers.Supplier supplier) {
        Supplier emsSupplier = SupplierMapper.toDto(supplierRepository.findByRcpSupplierCode(supplier.getSupplier_code()), false);
        Contact contact = null;
        Address address = AddressMapper.toDto(addressRepository.findByAdrAddressCode(supplier.getAddress_name()), false);
        Owner owner = OwnerMapper.toDto(ownerRepository.findByOwnOwnerCode(supplier.getOwner_code()), false);
        String s = "name:" + supplier.getContact_name() + ",surName:" + supplier.getContact_surname() + ",email:" + supplier.getContact_mail() + ",owner.code:" + owner.getCode();
        try {
            contact = ContactMapper.toDto(contactRepository.findOne(Search.expression(s, PrmContact.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

        if (null == emsSupplier) {
            emsSupplier = new Supplier();
            emsSupplier.setCreationDate(EmsDate.getDateNow());
        }
        if (null == contact) {
            contact = new Contact();
            contact.setName(supplier.getContact_name());
            contact.setActive(true);
            contact.setCreationDate(EmsDate.getDateNow());
            contact.setUpdateDate(EmsDate.getDateNow());
            contact.setSurName(supplier.getContact_surname());
            contact.setTel1(supplier.getTelephone());
            contact.setFax(supplier.getFax());
            contact.setContactType(2L);
            contact.setOwner(owner);
            contact = ContactMapper.toDto(contactRepository.saveAndFlush(ContactMapper.toEntity(contact, false)), false);
        }
        if (null == address) {
            address = new Address();
            address.setCode(supplier.getAddress_name());
            address.setCreationDate(EmsDate.getDateNow());
            address.setUpdateDate(EmsDate.getDateNow());
            address.setZip(supplier.getPostal_code());
            address.setLine1(supplier.getAddress_line1());
            address.setLine2(supplier.getAddress_line2());
            if ("facturation".toLowerCase().equals(supplier.getAddress_type().toLowerCase()))
                address.setAddressType(2L);
            else if ("livrainson".toLowerCase().equals(supplier.getAddress_type().toLowerCase()))
                address.setAddressType(1L);
            address.setCity(supplier.getCity());
            address.setCountry(supplier.getCountry());
            address.setOwner(owner);
            address = AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
        }
        if (null != emsSupplier) {
            emsSupplier = MapperSupplier.convertToEmsDto(emsSupplier, supplier);
            if (null == emsSupplier.getOwner()) {
                emsSupplier.setOwner(owner);
            }
            emsSupplier.setAddress(address);
            emsSupplier.setActive(true);
            emsSupplier.setContact(contact);
            emsSupplier = SupplierMapper.toDto(supplierRepository.saveAndFlush(SupplierMapper.toEntity(emsSupplier, false)), false);
            return emsSupplier;
        }

        return null;
    }

    @Override
    public List<Supplier> exportWmsSupplier(List<Supplier> suppliers) {
        writeFileSupplier(null != getPrmMsgSend() ? getPrmMsgSend().getPrmMsgSendPath() : System.getenv("APPDATA"), suppliers);
        return suppliers;
    }

}