package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.*;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.InvoiceService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceArcRepository invoiceArcRepository;
    @Autowired
    private InvoiceRulesRepository invoiceRulesRepository;
    @Autowired
    private InvoiceDataRepository invoiceDataRepository;
    @Autowired
    private CalculInvoiceRepository calculInvoiceRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(InvoiceService.class);


    @Override
    public Invoice save(Invoice invoice) {
        LOGGER.info("save Invoice");
        GenerateInvoice generateInvoice = new GenerateInvoice();
        generateInvoice.setOwner(invoice.getOwner());
        invoice.setUpdateDate(EmsDate.getDateNow());
        if (0 >= invoice.getId()) {
            invoice.setCreationDate(EmsDate.getDateNow());
        }
        return InvoiceMapper.toDto(invoiceRepository.saveAndFlush(InvoiceMapper.toEntity(invoice, false)), false);
    }

    @Override
    public Long size() {
        return invoiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return invoiceRepository.exists(id);
    }

    @Override
    public Invoice findById(Long id) throws IdNotFound {
        Invoice invoice = InvoiceMapper.toDto(invoiceRepository.findOne(id), false);
        if (null != invoice) {
            return invoice;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Invoice> find(String search) throws AttributesNotFound, ErrorType {
        return InvoiceMapper.toDtos(invoiceRepository.findAll(Search.expression(search, InvInvoice.class)), false);
    }

    @Override
    public List<Invoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "invInvoiceUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return InvoiceMapper.toDtos(invoiceRepository.findAll(Search.expression(search, InvInvoice.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return invoiceRepository.count(Search.expression(search, InvInvoice.class));
    }

    @Override
    public void delete(Long id) {
        invoiceRepository.delete(id);
    }

    @Override
    public void delete(Invoice invoice) {
        LOGGER.info("delete Invoice");
        invoiceRepository.delete(InvoiceMapper.toEntity(invoice, false));
    }

    @Override
    public List<Invoice> findAll() {
        LOGGER.info("delete Invoice");
        return InvoiceMapper.toDtos(invoiceRepository.findAll(), false);
    }

    @Override
    public List<Invoice> findAll(Pageable pageable) {
        return InvoiceMapper.toDtos(invoiceRepository.findAll(pageable), false);
    }

    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = invoiceRepository.getNextVal();
        return objects.get(0);
    }

    private void archiveInvoice(Invoice invoice) {
        InvoiceArc invoiceArc = new InvoiceArc();
        invoiceArc.setCode(invoice.getCode());
        invoiceArc.setComment(invoice.getComment());
        invoiceArc.setAddress(invoice.getAddress());
        //invoiceArc.setState(invoice.getState());
        invoiceArc.setVat(invoice.getVat());
        invoiceArc.setOwner(invoice.getOwner());
        invoiceArc.setCreationDate(invoice.getCreationDate());
        invoiceArc.setUpdateDate(invoice.getUpdateDate());
        invoiceArc.setInvoiceDate(invoice.getInvoiceDate());
        archiveLines(invoiceArc, invoice);
        invoiceArcRepository.saveAndFlush(InvoiceArcMapper.toEntity(invoiceArc, false));
        invoiceRepository.delete(invoice.getId());

    }

    private void archiveLines(InvoiceArc invoiceArc, Invoice invoice) {
        Set<InvoiceLineArc> invoiceLineArcs = new HashSet<>();
        invoice.getLines().stream().forEach(invoiceLine -> {
            InvoiceLineArc invoiceLineArc = new InvoiceLineArc();
            invoiceLineArc.setCreationDate(invoiceLine.getCreationDate());
            invoiceLineArc.setUpdateDate(invoiceLine.getUpdateDate());
            invoiceLineArc.setOwner(invoiceLine.getOwner());
            invoiceLineArc.setComment(invoiceLine.getComment());
            invoiceLineArc.setDiscount(invoiceLine.getDiscount());
            invoiceLineArc.setQuantity(invoiceLine.getQuantity());
            invoiceLineArc.setLineNumber(invoiceLine.getLineNumber());
            invoiceLineArc.setMovementType(invoiceLine.getMovementType());
            invoiceLineArc.setTarifPrice(invoiceLine.getTarifPrice());
            invoiceLineArc.setTotalPriceHT(invoiceLine.getTotalPriceHT());
            invoiceLineArc.setTotalPriceTTC(invoiceLine.getTotalPriceTTC());
            invoiceLineArc.setVariable1(invoiceLine.getVariable1());
            invoiceLineArc.setVariable2(invoiceLine.getVariable2());
            invoiceLineArc.setVariable3(invoiceLine.getVariable3());
            invoiceLineArc.setVariable4(invoiceLine.getVariable4());
            invoiceLineArc.setVariable5(invoiceLine.getVariable5());
            invoiceLineArc.setVariable6(invoiceLine.getVariable6());
            invoiceLineArc.setVariable7(invoiceLine.getVariable7());
            invoiceLineArc.setVariable8(invoiceLine.getVariable8());
            invoiceLineArc.setVariable9(invoiceLine.getVariable9());
            invoiceLineArc.setVariable10(invoiceLine.getVariable10());
            invoiceLineArcs.add(invoiceLineArc);
        });
        invoiceArc.setLines(invoiceLineArcs);
    }

    @Override
    @Transactional
    public Invoice createInvoice(Date endDate, Date startDate, Owner owner) throws AttributesNotFound, ErrorType {
        Invoice invoice = new Invoice();
        invoice.setOwner(owner);
        invoice.setCreationDate(EmsDate.getDateNow());
        invoice.setUpdateDate(EmsDate.getDateNow());
        invoice.setInvoiceDate(endDate);
        invoice.setStartDate(startDate);
        invoice.setAddress(owner.getAddress());
        invoice.setCode("IVC" + getNextVal().toString());
        invoice.setVat(owner.getVat());
        invoice.setName(owner.getName());
        invoice.setSurname(owner.getSurname());
        invoice.setEmail(owner.getEmail());
        invoice.setPrimaryTel(owner.getPrimaryTel());
        invoice.setSecondaryTel(owner.getSecondaryTel());
        invoice.setState(1L);//status cr�e
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        List<InvoiceRules> invoiceRuless = InvoiceRulesMapper.toDtos(invoiceRulesRepository.findAll(Search.expression("owner.id:" + owner.getId(), InvInvoiceRules.class)), false);
        for (InvoiceRules invoiceRules : invoiceRuless) {
            InvoiceLine invoiceLine = new InvoiceLine();
            invoiceLine.setOwner(owner);
            invoiceLine.setCreationDate(EmsDate.getDateNow());
            invoiceLine.setUpdateDate(EmsDate.getDateNow());
            invoiceLine.setMovementType(invoiceRules.getMovementType());
            invoiceLine.setLineNumber((invoiceLines.size() > 0 ?
                    (long) (invoiceLines.get(invoiceLines.size() - 1).getLineNumber() / 1000 + 1) * 1000 : 1000));
            invoiceLine.setDiscount(BigDecimal.ZERO);
            BigDecimal quantity = BigDecimal.ZERO;
            if (1 == invoiceRules.getMovementType().getId()) {
                List<BigDecimal> quantities = calculInvoiceRepository.receptionMovement(owner.getId(), startDate, endDate);
                if (null == quantities || 0 == quantities.size()) {
                    continue;
                }
                quantity = quantities.get(0);
            } else if (6 == invoiceRules.getMovementType().getId()) {
                List<BigDecimal> quantities = calculInvoiceRepository.expeditionMovement(owner.getId(), startDate, endDate);
                if (null == quantities || 0 == quantities.size()) {
                    continue;
                }
                quantity = quantities.get(0);
            } else if (2 == invoiceRules.getMovementType().getId()) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Calendar c = Calendar.getInstance();
                c.setTime(endDate);
                c.add(Calendar.DATE, 1);
                Date start = c.getTime();
                c.setTime(startDate);
                c.add(Calendar.DATE, -1);
                Date end = c.getTime();
                List<Double> quantities = calculInvoiceRepository.stockageMovement(owner.getId(), start, end);
                if (null != quantities && null != quantities.get(0))
                    quantity = new BigDecimal(quantities.get(0));
                else continue;
            } else if (9 == invoiceRules.getMovementType().getId()) {
                List<BigDecimal> quantitiesReception = calculInvoiceRepository.administrativeCostsForReception(startDate, endDate, owner.getId());
                List<BigDecimal> quantitiesDelivery = calculInvoiceRepository.administrativeCostsForDelivery(startDate, endDate, owner.getId());

                if ((invoiceRules.getRelevantReception() && (null == quantitiesReception || 0 == quantitiesReception.size())) && (invoiceRules.getRelevantDelivery() && (null == quantitiesDelivery || 0 == quantitiesDelivery.size()))) {
                    continue;
                }
                if (invoiceRules.getRelevantDelivery() && (null == quantitiesReception || 0 == quantitiesReception.size())) {
                    quantity = BigDecimal.ZERO;
                } else {
                    quantity = quantitiesReception.get(0);
                }
                if (invoiceRules.getRelevantDelivery() && (null == quantitiesDelivery || 0 == quantitiesDelivery.size())) {
                    quantity = quantity.add(BigDecimal.ZERO);
                } else {
                    if (null == quantity) {
                        quantity = quantitiesDelivery.get(0);
                    } else {
                        quantity = quantity.add(quantitiesDelivery.get(0));
                    }
                }

            }
            //waiting to define other rules
            else {
                continue;
            }
            if (null == quantity || BigDecimal.ZERO.equals(quantity))
                continue;
            invoiceLine.setQuantity(quantity);
            invoiceLine.setTarifPrice(invoiceRules.getPrice());
            invoiceLine.setTotalPriceHT(quantity.multiply(invoiceRules.getPrice().subtract(invoiceLine.getDiscount())));
            invoiceLine.setTotalPriceTTC(invoiceLine.getTotalPriceHT().add(invoiceLine.getTotalPriceHT().multiply((owner.getVat().divide(BigDecimal.valueOf(100))))));
            invoiceLines.add(invoiceLine);
        }
        if (0 == invoiceLines.size()) {
            return new Invoice();
        }
        invoice.setLines(new HashSet<>(invoiceLines));
        invoice = InvoiceMapper.toDto(invoiceRepository.saveAndFlush(InvoiceMapper.toEntity(invoice, false)), false);
        insertIntoInvoiceData(invoice);
       // owner.setFirstInvoiceDate(endDate);
       // ownerRepository.saveAndFlush(OwnerMapper.toEntity(owner, false));
        return invoice;
    }

    public void insertIntoInvoiceData(Invoice invoice) {
        if (null == invoice)
            return;
        for (InvoiceLine invoiceLine : invoice.getLines()) {
            InvoiceData invoiceData = new InvoiceData();
            invoiceData.setCreationDate(EmsDate.getDateNow());
            invoiceData.setUpdateDate(EmsDate.getDateNow());
            invoiceData.setOwner(invoiceLine.getOwner());
            invoiceData.setMovementType(invoiceLine.getMovementType());
            invoiceData.setQuantity(invoiceLine.getQuantity());
            invoiceData.setTotalPrice(invoiceLine.getTotalPriceTTC());
            invoiceData.setPrice(invoiceLine.getTarifPrice());
            invoiceData.setInvoiceDate(invoiceLine.getInvoice().getInvoiceDate());
            invoiceDataRepository.saveAndFlush(InvoiceDataMapper.toEntity(invoiceData, false));
        }
    }

    @Override
    public Invoice generateInvoiceFromOwner(GenerateInvoice generateInvoice) throws AttributesNotFound, ErrorType {
        List maxDates = invoiceDataRepository.getMaxDate(generateInvoice.getOwner().getId());
        Date dateStart = maxDates.size() > 0 ? (Date) maxDates.get(0) : generateInvoice.getOwner().getCreationDate();
        Date dateEnd = EmsDate.getDateNow();
        generateInvoice.setStartDate(dateStart);
        generateInvoice.setEndDate(dateEnd);
        return createInvoice(dateEnd, dateStart, generateInvoice.getOwner());

    }

}

