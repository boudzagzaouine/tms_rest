package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.DevisLineMapper;
import com.sinno.ems.repositories.DevisLineRepository;
import com.sinno.ems.service.DevisLineService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 06/12/2016.
 */
@Service
public class DevisLineServiceImpl implements DevisLineService{
    @Autowired
    private DevisLineRepository devisLineRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DevisLineService.class);

    @Override
    public DevisLine save(DevisLine devisLine) {
        LOGGER.info("save DevisLine");
        devisLine.setUpdateDate(EmsDate.getDateNow());
        if (0 >= devisLine.getId()) {
            devisLine.setCreationDate(EmsDate.getDateNow());
        }
        return DevisLineMapper.toDto(devisLineRepository.saveAndFlush(DevisLineMapper.toEntity(devisLine, false)), false);
    }

    @Override
    public Long size() {
        try {
            return size("");
        } catch (AttributesNotFound attributesNotFound) {
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return devisLineRepository.exists(id);
    }

    @Override
    public DevisLine findById(Long id) throws IdNotFound {
        DevisLine devisLine = DevisLineMapper.toDto(devisLineRepository.findOne(id), false);
        if (null != devisLine) {
            return devisLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<DevisLine> find(String search) throws AttributesNotFound, ErrorType {

        return DevisLineMapper.toDtos(devisLineRepository.findAll(Search.expression(search, CmdDevisLine.class)), false);
    }

    @Override
    public List<DevisLine> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {

        return DevisLineMapper.toDtos(devisLineRepository.findAll(Search.expression(search, CmdDevisLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {

        return devisLineRepository.count(Search.expression(search, CmdDevisLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete DevisLine");
        CmdDevisLine cmdDevisLine = devisLineRepository.findOne(id);
        devisLineRepository.delete(id);
    }

    @Override
    public void delete(DevisLine devisLine) {

        devisLineRepository.delete(DevisLineMapper.toEntity(devisLine, false));
    }

    @Override
    public List<DevisLine> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<DevisLine> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return find("", pageable);
    }

}
