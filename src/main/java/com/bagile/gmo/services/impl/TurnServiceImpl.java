package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Turn;
import com.bagile.gmo.entities.GmoTurn;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TurnMapper;
import com.bagile.gmo.repositories.TurnRepository;
import com.bagile.gmo.services.TurnService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TurnServiceImpl implements TurnService {
    private final TurnRepository TurnRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(TurnService.class);

    public TurnServiceImpl(TurnRepository TurnRepository) {
        this.TurnRepository = TurnRepository;
    }

    @Override
    public Turn save(Turn Turn) {
        LOGGER.info("save Turn");
        Turn.setUpdateDate(EmsDate.getDateNow());
        if (0 <= Turn.getId()) {
            Turn.setCreationDate(EmsDate.getDateNow());
        }
        return TurnMapper.toDto(TurnRepository.saveAndFlush(TurnMapper.toEntity(Turn, false)), false);
    }

    @Override
    public Long size() {
        long count = TurnRepository.count();
        return count;
    }

    @Override
    public Boolean isExist(Long id) {
        return TurnRepository.existsById(id);
    }

    @Override
    public Turn findById(Long id) throws IdNotFound {
        return TurnMapper.toDto(TurnRepository.findById(id).orElseThrow(() -> new IdNotFound(id)),false);
    }

    @Override
    public List<Turn> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals ("")){
            return findAll ();
        }
        return TurnMapper.toDtos(TurnRepository.findAll(Search.expression(search, GmoTurn.class)), false);
    }

    @Override
    public List<Turn> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        //Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        List<Turn> Turns = TurnMapper.toDtos(TurnRepository.findAll(Search.expression(search, GmoTurn.class), pageable), false);
        return Turns;
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if ("".equals(search)) {
            return size();
        }
        return TurnRepository.count(Search.expression(search, GmoTurn.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Turn");
        TurnRepository.deleteById(id);
    }

    @Override
    public void delete(Turn Turn) {
        LOGGER.info("delete Turn");
        TurnRepository.delete(TurnMapper.toEntity(Turn, false));
    }

    @Override
    public List<Turn> findAll() {
        return TurnMapper.toDtos(TurnRepository.findAll(), false);
    }

    @Override
    public List<Turn> findAll(int page, int size) {
        //Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        return TurnMapper.toDtos(TurnRepository.findAll(pageable), false);
    }

    @Override
    public void archive(Long id) throws IdNotFound {
        LOGGER.info("archive Turn");
        Turn Turn = TurnMapper.toDto(TurnRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        TurnMapper.toDto(TurnRepository.saveAndFlush(TurnMapper.toEntity(Turn, false)), false);

    }
}
