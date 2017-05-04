package com.sinno.ems.service.impl;

import com.sinno.ems.dto.InvoiceTerm;
import com.sinno.ems.entities.InvInvoiceTerm;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.InvoiceTermMapper;
import com.sinno.ems.repositories.InvoiceTermRepository;
import com.sinno.ems.service.InvoiceTermService;
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

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class InvoiceTermServiceImpl implements InvoiceTermService {
  
        @Autowired
        private InvoiceTermRepository invoiceTermRepository;
        private final static Logger LOGGER = LoggerFactory
                .getLogger(InvoiceTermService.class);

        @Override
        public InvoiceTerm save(InvoiceTerm invoiceTerm) {
            LOGGER.info("save InvoiceTerm");
            invoiceTerm.setUpdateDate(EmsDate.getDateNow());
            if (0 >= invoiceTerm.getId()) {
                invoiceTerm.setCreationDate(EmsDate.getDateNow());
            }
            return InvoiceTermMapper.toDto(invoiceTermRepository.saveAndFlush(InvoiceTermMapper.toEntity(invoiceTerm, false)), false);
        }

        @Override
        public Long size() {
            return invoiceTermRepository.count();
        }

        @Override
        public Boolean isExist(Long id) {
            return invoiceTermRepository.exists(id);
        }

        @Override
        public InvoiceTerm findById(Long id) throws IdNotFound {
            InvoiceTerm invoiceTerm = InvoiceTermMapper.toDto(invoiceTermRepository.findOne(id), false);
            if (null != invoiceTerm) {
                return invoiceTerm;
            } else {
                throw new IdNotFound(id);
            }
        }

        @Override
        public List<InvoiceTerm> find(String search) throws AttributesNotFound, ErrorType {
            return InvoiceTermMapper.toDtos(invoiceTermRepository.findAll(Search.expression(search, InvInvoiceTerm.class)), false);
        }

        @Override
        public List<InvoiceTerm> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
            Sort sort = new Sort(Sort.Direction.DESC,"invInvoiceTermUpdateDate");
            Pageable pageable = new PageRequest(page, size, sort);
            return InvoiceTermMapper.toDtos(invoiceTermRepository.findAll(Search.expression(search, InvInvoiceTerm.class), pageable), false);
        }

        @Override
        public Long size(String search) throws AttributesNotFound, ErrorType {
            return invoiceTermRepository.count(Search.expression(search, InvInvoiceTerm.class));
        }

        @Override
        public void delete(Long id) {
            LOGGER.info("delete InvoiceTerm");
            invoiceTermRepository.delete(id);
        }

        @Override
        public void delete(InvoiceTerm invoiceTerm) {
            LOGGER.info("delete InvoiceTerm");
            invoiceTermRepository.delete(InvoiceTermMapper.toEntity(invoiceTerm, false));
        }

        @Override
        public List<InvoiceTerm> findAll() {
            return InvoiceTermMapper.toDtos(invoiceTermRepository.findAll(), false);
        }

        @Override
        public List<InvoiceTerm> findAll(Pageable pageable) {
            return InvoiceTermMapper.toDtos(invoiceTermRepository.findAll(pageable), false);
        }
    }
