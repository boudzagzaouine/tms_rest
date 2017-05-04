package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Kit;
import com.sinno.ems.entities.PdtKit;
import com.sinno.ems.entities.PrmMsgSend;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.export.KitExport;
import com.sinno.ems.mapper.KitMapper;
import com.sinno.ems.repositories.KitRepository;
import com.sinno.ems.repositories.MsgSendRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.KitService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.List;

@Service
public class KitServiceImpl implements KitService {

    @Autowired
    private KitRepository kitRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private ServletContext servletContext;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(KitService.class);

    @Override
    public Kit save(Kit kit) {
        LOGGER.info("save Kit");
        PdtKit pdtKit = kitRepository.saveAndFlush(KitMapper.toEntity(kit, false));
        Kit kit1 = KitMapper.toDto(pdtKit, false);
        PrmMsgSend msgSend = null;
        //String nameFile = servletContext.getRealPath("/") + "\\resources\\image\\ems-logo-xs-1.png";
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:KIT", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator() && msgSends.iterator().hasNext()) {
                msgSend = msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        if (null != msgSend && msgSend.isPrmMsgSendActive()) {
            KitExport.export(servletContext.getRealPath("/WEB-INF/classes"), pdtKit, "F",servletContext);
        }
        return kit1;
    }

    @Override
    public Long size() {
        return kitRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return kitRepository.exists(id);
    }

    @Override
    public Kit findById(Long id) throws IdNotFound {
        Kit kit = KitMapper.toDto(kitRepository.findOne(id), false);
        if (null != kit) {
            return kit;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Kit> find(String search) throws AttributesNotFound, ErrorType {
        return KitMapper.toDtos(kitRepository.findAll(Search.expression(search, PdtKit.class)), false);
    }

    @Override
    public List<Kit> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return KitMapper.toDtos(kitRepository.findAll(Search.expression(search, PdtKit.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return kitRepository.count(Search.expression(search, PdtKit.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete kit");
        kitRepository.delete(id);
    }

    @Override
    public void delete(Kit kit) {
        LOGGER.info("delete Kit");
        kitRepository.delete(KitMapper.toEntity(kit, false));
    }

    @Override
    public List<Kit> findAll() {
        return KitMapper.toDtos(kitRepository.findAll(), false);
    }

    @Override
    public List<Kit> findAll(Pageable pageable) {
        return KitMapper.toDtos(kitRepository.findAll(pageable), false);
    }
}