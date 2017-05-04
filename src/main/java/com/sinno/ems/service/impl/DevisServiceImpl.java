package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Devis;
import com.sinno.ems.entities.CmdDevis;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.DevisMapper;
import com.sinno.ems.repositories.DevisRepository;
import com.sinno.ems.service.DevisService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 06/12/2016.
 */
@Service
public class DevisServiceImpl implements DevisService {
    @Autowired
    private DevisRepository devisRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DevisService.class);

    @Override
    public Devis save(Devis devis) {
        LOGGER.info("save Devis");
        devis.setUpdateDate(EmsDate.getDateNow());
        if (0 >= devis.getId()) {
            devis.setCreationDate(EmsDate.getDateNow());
        }
        return DevisMapper.toDto(devisRepository.saveAndFlush(DevisMapper.toEntity(devis, false)), false);
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
        return devisRepository.exists(id);
    }

    @Override
    public Devis findById(Long id) throws IdNotFound {
        Devis devis = DevisMapper.toDto(devisRepository.findOne(id), false);
        if (null != devis) {
            return devis;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Devis> find(String search) throws AttributesNotFound, ErrorType {

        return DevisMapper.toDtos(devisRepository.findAll(Search.expression(search, CmdDevis.class)), false);
    }

    @Override
    public List<Devis> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {

        return DevisMapper.toDtos(devisRepository.findAll(Search.expression(search, CmdDevis.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {

        return devisRepository.count(Search.expression(search, CmdDevis.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Devis");
        CmdDevis cmdDevis = devisRepository.findOne(id);
        devisRepository.delete(id);
    }

    @Override
    public void delete(Devis devis) {

        devisRepository.delete(DevisMapper.toEntity(devis, false));
    }

    @Override
    public List<Devis> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Devis> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return find("", pageable);
    }
    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = devisRepository.getNextVal();
        return objects.get(0);
    }
}
