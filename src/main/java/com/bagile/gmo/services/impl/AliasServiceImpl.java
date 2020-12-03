package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Alias;
import com.bagile.gmo.entities.PdtAlias;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AliasMapper;
import com.bagile.gmo.repositories.AliasRepository;
import com.bagile.gmo.services.AliasService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
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
   // @Autowired
   // private MsgSendRepository msgSendRepository;
    @Autowired
    private ServletContext servletContext;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AliasService.class);
    /**
     * create or updated alias and generate file that will be imported by easyWms
     * @param alias
     * @return
     */
    @Override
    public Alias save(Alias alias) {
        LOGGER.info("save Alias");
        alias.setUpdateDate(EmsDate.getDateNow());
        String codeAlias = "";
        if (0 < alias.getId()) {

            PdtAlias pdtAlias = aliasRepository.findById(alias.getId())
                    .orElseThrow(() -> new RuntimeException("Alias : " + alias.getId() + "Could not found"));


            ///.orElseThrow(IllegalAccessError::new);
            codeAlias = pdtAlias.getPdtAliasEanCode();
            if (alias.getEanCode().equals(codeAlias)) {
                codeAlias = "";
            }
        }



        if (0 >= alias.getId()) {
            alias.setCreationDate(EmsDate.getDateNow());
        }
        PdtAlias pdtAlias = aliasRepository.saveAndFlush(AliasMapper.toEntity(alias, false));
        Alias alias1 = AliasMapper.toDto(pdtAlias, false);
        /*PrmMsgSend msgSend = null;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:ALI", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator() && msgSends.iterator().hasNext()) {
                msgSend = msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //LOGGER.error(e.getMessage(),e);
        }
        if (null != msgSend && msgSend.isPrmMsgSendActive()) {
            AliasExport.export(servletContext.getRealPath("/WEB-INF/classes"), pdtAlias, codeAlias, "F", servletContext);
        }*/
        return alias1;
    }
    /**
     * get the size of the records in account invoice table
     * @return
     */
    @Override
    public Long size() {
        return aliasRepository.count();
    }
    /**
     * check if id exist in database
     * @param id
     * @return
     */
    @Override
    public Boolean isExist(Long id) {
        return aliasRepository.existsById(id);
    }
    /**
     * find entity by id
     * @param id
     * @return the entity if found
     * @throws com.bagile.gmo.exceptions.IdNotFound
     */
    @Override
    public Alias findById(Long id) throws IdNotFound {
        Alias alias = AliasMapper.toDto(aliasRepository.findById(id).orElseThrow(() -> new RuntimeException("")), false);
        if (null != alias) {
            return alias;
        } else {
            throw new IdNotFound(id);
        }
    }
    /**
     * find list of account invoices
     * @param search query
     * @return List<Alias>
     * @throws com.bagile.gmo.exceptions.AttributesNotFound
     * @throws com.bagile.gmo.exceptions.ErrorType
     */
    @Override
    public List<Alias> find(String search) throws AttributesNotFound, ErrorType {
        return AliasMapper.toDtos(aliasRepository.findAll(Search.expression(search, PdtAlias.class)), false);
    }
    /**
     * find list of accounts with pagination
     * @param search query
     * @param pageable pagination object
     * @return List<Alias>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Alias> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return AliasMapper.toDtos(aliasRepository.findAll(Search.expression(search, PdtAlias.class), pageable), false);
    }
    /**
     *  get the size of records for a search query
     * @param search search query
     * @return Long
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return aliasRepository.count(Search.expression(search, PdtAlias.class));
    }

    @Override
    public Alias findOne(String search) throws AttributesNotFound, ErrorType {
        return AliasMapper.toDto(aliasRepository.findOne(Search.expression(search, PdtAlias.class)).orElseThrow(RuntimeException::new), false);
    }
    /**
     * delete a record on the database
     * @param id the id that will be deleted
     */
    @Override
    public void delete(Long id) {
        LOGGER.info("delete Alias");
        //aliasRepository.delete(id);
    }
    /**
     * delete a record on the database
     * @param alias the account invoice that will be deleted
     */
    @Override
    public void delete(Alias alias) {
        LOGGER.info("delete Alias");
        aliasRepository.delete(AliasMapper.toEntity(alias, false));
    }
    /**
     * get all the records from the database
     * @return List<Alias>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Alias> findAll() {
        return AliasMapper.toDtos(aliasRepository.findAll(), false);
    }
    /**
     * get all the records from the database with pagination
     * @return List<Account>
     * @param pageable pagination object
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Alias> findAll(Pageable pageable) {
        return AliasMapper.toDtos(aliasRepository.findAll(pageable), false);
    }
}