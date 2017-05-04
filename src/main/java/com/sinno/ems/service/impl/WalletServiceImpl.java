package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Wallet;
import com.sinno.ems.entities.PrmWallet;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.WalletMapper;
import com.sinno.ems.repositories.WalletRepository;
import com.sinno.ems.service.WalletService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(WalletService.class);

    @Override
    public Wallet save(Wallet wallet) {
        LOGGER.info("save Wallet");
        wallet.setUpdateDate(EmsDate.getDateNow());
        if (0 >= wallet.getId()) {
            wallet.setCreationDate(EmsDate.getDateNow());
        }
        return WalletMapper.toDto(walletRepository.saveAndFlush(WalletMapper.toEntity(wallet, false)), false);
    }

    @Override
    public Long size() {
        return walletRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return walletRepository.exists(id);
    }

    @Override
    public Wallet findById(Long id) throws IdNotFound {
        Wallet wallet = WalletMapper.toDto(walletRepository.findOne(id), false);
        if (null != wallet) {
            return wallet;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Wallet> find(String search) throws AttributesNotFound, ErrorType {
        return WalletMapper.toDtos(walletRepository.findAll(Search.expression(search, PrmWallet.class)), false);
    }

    @Override
    public List<Wallet> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC,"prmWalletUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return WalletMapper.toDtos(walletRepository.findAll(Search.expression(search, PrmWallet.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return walletRepository.count(Search.expression(search, PrmWallet.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Wallet");
        walletRepository.delete(id);
    }

    @Override
    public void delete(Wallet wallet) {
        LOGGER.info("delete Wallet");
        walletRepository.delete(WalletMapper.toEntity(wallet, false));
    }

    @Override
    public List<Wallet> findAll() {
        return WalletMapper.toDtos(walletRepository.findAll(), false);
    }

    @Override
    public List<Wallet> findAll(Pageable pageable) {
        return WalletMapper.toDtos(walletRepository.findAll(pageable), false);
    }
}