package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Alias;
import com.sinno.ems.entities.PdtAlias;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.export.AliasExport;
import com.sinno.ems.mapper.AliasMapper;
import com.sinno.ems.repositories.AliasRepository;
import com.sinno.ems.service.AliasService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.List;

@Service
public class AliasServiceImpl implements AliasService {

    @Autowired
    private AliasRepository aliasRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private ServletContext servletContext;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AliasService.class);

    @Override
    public Alias save(Alias alias) {
        LOGGER.info("save Alias");
        alias.setUpdateDate(EmsDate.getDateNow());
        String  codeAlias = "";
        if(0<alias.getId()){
            codeAlias = aliasRepository.findOne(alias.getId()).getPdtAliasEanCode();
            if(alias.getEanCode().equals(codeAlias)){
                codeAlias = "";
            }
        }
        if (0 >= alias.getId()) {
            alias.setCreationDate(EmsDate.getDateNow());
        }
        PdtAlias pdtAlias = aliasRepository.saveAndFlush(AliasMapper.toEntity(alias, false));
        Alias alias1 = AliasMapper.toDto(pdtAlias, false);
        PrmMsgSend msgSend = null;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:ALI", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator() && msgSends.iterator().hasNext()) {
                msgSend = msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        if (null != msgSend && msgSend.isPrmMsgSendActive()) {
            AliasExport.export(servletContext.getRealPath("/WEB-INF/classes"), pdtAlias,codeAlias, "F",servletContext);
        }
        return alias1;
    }

    @Override
    public Long size() {
        return aliasRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return aliasRepository.exists(id);
    }

    @Override
    public Alias findById(Long id) throws IdNotFound {
        Alias alias = AliasMapper.toDto(aliasRepository.findOne(id), false);
        if (null != alias) {
            return alias;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Alias> find(String search) throws AttributesNotFound, ErrorType {
        return AliasMapper.toDtos(aliasRepository.findAll(Search.expression(search, PdtAlias.class)), false);
    }

    @Override
    public List<Alias> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return AliasMapper.toDtos(aliasRepository.findAll(Search.expression(search, PdtAlias.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return aliasRepository.count(Search.expression(search, PdtAlias.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Alias");
        aliasRepository.delete(id);
    }

    @Override
    public void delete(Alias alias) {
        LOGGER.info("delete Alias");
        aliasRepository.delete(AliasMapper.toEntity(alias, false));
    }

    @Override
    public List<Alias> findAll() {
        return AliasMapper.toDtos(aliasRepository.findAll(), false);
    }

    @Override
    public List<Alias> findAll(Pageable pageable) {
        return AliasMapper.toDtos(aliasRepository.findAll(pageable), false);
    }
}