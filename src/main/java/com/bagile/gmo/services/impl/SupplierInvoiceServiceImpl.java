package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.InvSupplierInvoice;
import com.bagile.gmo.entities.RcpReception;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.mapper.ReceptionMapper;
import com.bagile.gmo.mapper.SupplierInvoiceMapper;
import com.bagile.gmo.repositories.SupplierInvoiceRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.AddActive;

import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class SupplierInvoiceServiceImpl implements SupplierInvoiceService, GmaoSearch {
    @Autowired
    private SupplierInvoiceRepository supplierInvoiceRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierInvoiceService.class);
    @Autowired
    private SettingService settingService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @Autowired
    private PurshaseOrderService purshaseOrderService;

    @Autowired
    private PaymentStatusService paymentStatusService;
    @Autowired
    private PurshaseOrderLineService purshaseOrderLineService;
    //@Autowired
  // private CurrencyService currencyService;

    @Autowired
    private ReceptionLineService receptionLineService;
    @Autowired
    private ReceptionService receptionService;
    @Autowired
    private OrderStatusService orderStatusService;

    @Override
    public SupplierInvoice save(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        LOGGER.info("save SupplierInvoice");
        supplierInvoice.setUpdateDate(EmsDate.getDateNow());
        if (0 >= supplierInvoice.getId()) {
            supplierInvoice.setPaymentStatus(paymentStatusService.onProgressPayedStatus());
            supplierInvoice.setCreationDate(EmsDate.getDateNow());
            supplierInvoice.setActive(true);
            if (null == supplierInvoice.getCurrency())
                //supplierInvoice.setCurrency(currencyService.getDefault());
            supplierInvoice = SupplierInvoiceMapper.toDto(supplierInvoiceRepository.saveAndFlush(SupplierInvoiceMapper.toEntity(supplierInvoice, false)), false);

        } else {

            supplierInvoice = SupplierInvoiceMapper.toDto(supplierInvoiceRepository.saveAndFlush(SupplierInvoiceMapper.toEntity(supplierInvoice, false)), false);
        }
        return supplierInvoice;
    }

    @Override
    public Long size() throws ErrorType, AttributesNotFound {
       return supplierInvoiceRepository.count(Search.expression(addGmaoToSearch(""), InvSupplierInvoice.class));
    }

    @Override
    public Boolean isExist(Long id) {
        return supplierInvoiceRepository.existsById(id);
    }

    @Override
    public SupplierInvoice findById(Long id) throws IdNotFound {
        SupplierInvoice paymentSupplier = SupplierInvoiceMapper.toDto(supplierInvoiceRepository.findById(id).orElseThrow(()-> new IdNotFound(id)), false);
        if (null != paymentSupplier) {
            return paymentSupplier;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SupplierInvoice> find(String search) throws AttributesNotFound, ErrorType {
        return SupplierInvoiceMapper.toDtos(supplierInvoiceRepository.findAll(Search.expression(addGmaoToSearch(search), InvSupplierInvoice.class)), false);
    }

    @Override
    public SupplierInvoice findOne(String search) throws AttributesNotFound, ErrorType {
        return SupplierInvoiceMapper.toDto(supplierInvoiceRepository.findOne(Search.expression(addGmaoToSearch(search), InvSupplierInvoice.class)).orElseThrow(()-> new AttributesNotFound(search)), false);
    }

    @Override
    public List<SupplierInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort =  Sort.by(Sort.Direction.ASC, "invSupplierInvoiceDeadLine");
        Pageable pageable =  PageRequest.of(page, size, sort);
        return SupplierInvoiceMapper.toDtos(supplierInvoiceRepository.findAll(Search.expression(addGmaoToSearch(search), InvSupplierInvoice.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return supplierInvoiceRepository.count(Search.expression(addGmaoToSearch(search), InvSupplierInvoice.class));
    }

    @Override
    public void delete(Long id) throws IdNotFound {
        LOGGER.info("delete SupplierInvoice");
        supplierInvoiceRepository.deleteById(id);
    }

    @Override
    public void delete(SupplierInvoice supplierInvoice) {
        LOGGER.info("delete SupplierInvoice");
        supplierInvoiceRepository.delete(SupplierInvoiceMapper.toEntity(supplierInvoice, false));
    }

    @Override
    public List<SupplierInvoice> findAll() {
        return SupplierInvoiceMapper.toDtos(supplierInvoiceRepository.findAll(), false);
    }

    @Override
    public List<SupplierInvoice> findAll(Pageable pageable) throws ErrorType, AttributesNotFound {
        return SupplierInvoiceMapper.toDtos(supplierInvoiceRepository.findAll(Search.expression(addGmaoToSearch(""), InvSupplierInvoice.class), pageable), false);

    }

    @Override
    public String getNextVal() {
        String code = settingService.generateCodeSupplierInvoice();
        String lastCode = supplierInvoiceRepository.lastCode();
        if (lastCode != null && !"".equals(lastCode)) {
            lastCode = lastCode.replaceAll("\\D+", "");
            long lastSequenceNumber = lastCode != null && !lastCode.isEmpty() ? Long.parseLong(lastCode) + 1 : 1;
            return code != null && !code.equals("") ? code + lastSequenceNumber : "" + lastSequenceNumber;
        } else return code != null && !code.equals("") ? code + 1 : "";

    }

    @Override
    @Transactional
    public SupplierInvoice generateSupplierInvoice(PurshaseOrder purshaseOrder) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        purshaseOrder = purshaseOrderService.findById(purshaseOrder.getId());
        SupplierInvoice supplierInvoice = new SupplierInvoice();
        List<SupplierInvoiceLine> lines = new ArrayList<SupplierInvoiceLine>();
        supplierInvoice.setCode(getNextVal());
        supplierInvoice.setSupplier(purshaseOrder.getSupplier());
        supplierInvoice.setPurshaseOrder(purshaseOrder);
        supplierInvoice.setDiscount(BigDecimal.ZERO);
        supplierInvoice.setInvoiceStatus(invoiceStatusService.findById(1L));
        supplierInvoice.setOwner(purshaseOrder.getOwner());
        supplierInvoice.setWarehouse(purshaseOrder.getWarehouse());
        supplierInvoice.setDiscount(purshaseOrder.getDiscount());
        supplierInvoice.setVat(purshaseOrder.getVat());
        supplierInvoice.setCurrency(purshaseOrder.getCurrency());
        supplierInvoice.setActive(true);
//        if (null != purshaseOrder.getSupplier())
//            supplierInvoice.setDeadLine(getDeadLine(purshaseOrder.getSupplier()));
        int id = 0;
        List<PurshaseOrderLine> purshaseOrderLines = purshaseOrderLineService.find("purshaseOrder.id:" + purshaseOrder.getId());
        for (PurshaseOrderLine so : purshaseOrderLines) {
            SupplierInvoiceLine line = new SupplierInvoiceLine();
            line.setId(id);
            id--;
            line.setNumber(so.getNumber());
            line.setDescription(so.getDescription());
            line.setProduct(so.getProduct());
            line.setUom(so.getUom());
            line.setQuantity(so.getQuantityReceived().compareTo(BigDecimal.ZERO)>0?so.getQuantityReceived().setScale(2):so.getQuantity());
            line.setTarifPrice(so.getPurshasePrice());
            line.setDiscount(so.getDiscount());
            line.setVat(so.getVat() != null ? so.getVat().getValue() : BigDecimal.ZERO);
            line.setProductPack(so.getProductPack());
            lines.add(calculateTTCAndHT(line));
        }
        supplierInvoice.setSupplierInvoiceLines(new HashSet<>(lines));
        calculateAllLines(supplierInvoice);
//        purshaseOrder.setPaymentStatus(paymentStatusService.onProgressPayedStatus());
        purshaseOrder.setPurshaseOrderLines(new HashSet<>(purshaseOrderLines));
        purshaseOrderService.save(purshaseOrder);
        supplierInvoice = save(supplierInvoice);
        return supplierInvoice;
    }

    @Override
    public SupplierInvoice merge(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        return null;
    }


    public SupplierInvoiceLine calculateTTCAndHT(SupplierInvoiceLine supplierInvoiceLine) {
        if (null == supplierInvoiceLine.getQuantity()) {
            supplierInvoiceLine.setQuantity(BigDecimal.ZERO);
        }
        if (null == supplierInvoiceLine.getTarifPrice()) {
            supplierInvoiceLine.setTarifPrice(BigDecimal.ZERO);
        }

        BigDecimal vat = BigDecimal.ZERO;
        if (null != supplierInvoiceLine.getVat()) {
            vat = supplierInvoiceLine.getVat();
        }
        BigDecimal priceHT = supplierInvoiceLine.getQuantity()
                .multiply(supplierInvoiceLine.getTarifPrice()).setScale(2, RoundingMode.FLOOR);
        supplierInvoiceLine.setTotalPriceHT(priceHT.setScale(2, BigDecimal.ROUND_FLOOR));
        supplierInvoiceLine.setTotalPriceTTC((supplierInvoiceLine.getTotalPriceHT().add(supplierInvoiceLine.getTotalPriceHT()
                .multiply((vat.divide(BigDecimal.valueOf(100)))))).setScale(2, BigDecimal.ROUND_FLOOR));
        return supplierInvoiceLine;
    }

    public void calculateAllLines(SupplierInvoice supplierInvoice) {
        BigDecimal priceTTC = BigDecimal.ZERO;
        BigDecimal priceHt = BigDecimal.ZERO;
        for (SupplierInvoiceLine supplierInvoiceLine : supplierInvoice.getSupplierInvoiceLines()) {
            if (null != supplierInvoiceLine.getTotalPriceHT() && null != supplierInvoiceLine.getTotalPriceTTC()) {
                priceHt = priceHt.add(supplierInvoiceLine.getTotalPriceHT());
                priceTTC = priceTTC.add(supplierInvoiceLine.getTotalPriceTTC());
            }
        }
        supplierInvoice.setTotalPriceHT(priceHt.setScale(2, RoundingMode.FLOOR));
        supplierInvoice.setTotalPriceTTC(priceTTC.setScale(2, RoundingMode.FLOOR));
        supplierInvoice.setVat((supplierInvoice.getTotalPriceTTC().subtract(supplierInvoice.getTotalPriceHT())).setScale(2, RoundingMode.FLOOR));
    }

//    private Date getDeadLine(Supplier supplier) {
//        if (null != supplier.getPaymentTerm()) {
//            int invoiceTermId = (int) supplier.getPaymentTerm().getId();
//            Calendar calendar = Calendar.getInstance();
//            switch (invoiceTermId) {
//                case 1:
//                    return EmsDate.getDateNow();
//
//                case 2:
//                    calendar.setTime(EmsDate.getDateNow());
//                    calendar.add(Calendar.DATE, 30);
//                    return calendar.getTime();
//                case 3:
//                    calendar.setTime(EmsDate.getDateNow());
//                    calendar.add(Calendar.DATE, 30);
//                    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//                    if (1 != dayOfMonth) {
//                        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//                    }
//                    return calendar.getTime();
//                case 4:
//                    calendar.setTime(EmsDate.getDateNow());
//                    calendar.add(Calendar.DATE, 60);
//                    return calendar.getTime();
//                case 5:
//                    calendar.setTime(EmsDate.getDateNow());
//                    calendar.add(Calendar.DATE, 60);
//                    dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//                    if (1 != dayOfMonth) {
//                        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//                    }
//                    return calendar.getTime();
//                case 6:
//                    calendar.setTime(EmsDate.getDateNow());
//                    calendar.add(Calendar.DATE, 90);
//                    return calendar.getTime();
//                case 7:
//                    calendar.setTime(EmsDate.getDateNow());
//                    calendar.add(Calendar.DATE, 90);
//                    dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//                    if (1 != dayOfMonth) {
//                        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//                    }
//                    return calendar.getTime();
//                case 8:
//                    calendar.setTime(EmsDate.getDateNow());
//                    calendar.add(Calendar.DATE, 15);
//                    return calendar.getTime();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public SupplierInvoice merge(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
//        if (supplierInvoice.getChildes() != null && supplierInvoice.getChildes().size() == 1) {
//            return supplierInvoice.getChildes().iterator().next();
//        }
//        supplierInvoice.setId(0);
//        if (supplierInvoice.getCode() == null || "".equals(supplierInvoice.getCode())) {
//            supplierInvoice.setCode(getNextVal());
//        }
//        supplierInvoice.setTotalPriceHT(BigDecimal.ZERO);
//        supplierInvoice.setTotalPriceTTC(BigDecimal.ZERO);
//        supplierInvoice.setVat(BigDecimal.ZERO);
//        supplierInvoice.setSupplierInvoiceLines(null);
//        for (SupplierInvoice ai : supplierInvoice.getChildes()) {
//            supplierInvoice.setTotalPriceTTC(supplierInvoice.getTotalPriceTTC().add(ai.getTotalPriceTTC()));
//            supplierInvoice.setTotalPriceHT(supplierInvoice.getTotalPriceHT().add(ai.getTotalPriceHT()));
//        }
//        List<SupplierInvoiceLine> supplierInvoiceLines = supplierInvoice.getChildes().stream().flatMap(supplierInvoice1 -> supplierInvoice1.getSupplierInvoiceLines().stream()).collect(Collectors.toList());
//        supplierInvoice.setVat(supplierInvoice.getTotalPriceTTC().subtract(supplierInvoice.getTotalPriceHT()));
//        supplierInvoice.setBillingTermPurshase(null);
//        SupplierInvoice finalSupplierInvoice = supplierInvoice;
//        int cpt = 1;
//        for (SupplierInvoiceLine supplierInvoiceLine : supplierInvoiceLines) {
//            supplierInvoiceLine.setId(0);
//            supplierInvoiceLine.setNumber(cpt * 1000L);
//            cpt++;
//            supplierInvoiceLine.setSupplierInvoice(finalSupplierInvoice);
//        }
//
//        supplierInvoice.setSupplierInvoiceLines(new HashSet<>(supplierInvoiceLines));
//        supplierInvoice = save(supplierInvoice);
//        for (SupplierInvoice ai : supplierInvoice.getChildes()) {
//            ai = findById(ai.getId());
//            ai.setParent(supplierInvoice);
//            ai.setInvoiceStatus(invoiceStatusService.getCanceled());
//            ai.setActive(false);
//            purchaseJournalService.cancelPurchaseJournalLine(ai);
//            save(ai);
//        }
//
//        return supplierInvoice;
//    }


    @Override
    @Transactional
    public SupplierInvoice generateSupplierInvoiceFromReceptions(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException, ProductControls, ContainerException, ProductControls {
        List<Reception> receptions = supplierInvoice.getSupplierInvoiceReceptions().stream().map(supplierInvoiceReception -> supplierInvoiceReception.getReception()).collect(Collectors.toList());
        List<SupplierInvoiceLine> lines = new ArrayList<SupplierInvoiceLine>();
        supplierInvoice.setGmao(true);

        supplierInvoice.setCode(getNextVal());
        supplierInvoice.setSupplier(receptions.get(0).getSupplier());
        supplierInvoice.setDiscount(BigDecimal.ZERO);
        supplierInvoice.setInvoiceStatus(invoiceStatusService.findById(1L));
        supplierInvoice.setOwner(receptions.get(0).getOwner());
        supplierInvoice.setWarehouse(receptions.get(0).getWarehouse());
        supplierInvoice.setCurrency(receptions.get(0).getCurrency());
        supplierInvoice.setActive(true);
       // if (null != receptions.get(0).getSupplier())
          //  supplierInvoice.setDeadLine(getDeadLine(receptions.get(0).getSupplier()));
        int id = 0;
        String ids = receptions.stream().map(reception -> String.valueOf(reception.getId())).collect(Collectors.joining(";"));
        List<ReceptionLine> receptionLines = receptionLineService.find("reception.id^" + ids);
        int cpt = 1;

        for (ReceptionLine so : receptionLines) {
            SupplierInvoiceLine line = new SupplierInvoiceLine();
            line.setGmao(true);

            line.setId(id);
            id--;
            line.setNumber((long) (cpt * 1000));
            line.setDescription(so.getDescription());
            line.setProduct(so.getProduct());
            line.setUom(so.getUom());
            if (so.getQuantityReceived() != null) {
                line.setQuantity(so.getQuantityReceived().setScale(2));
            } else {
                line.setQuantity(so.getQuantity());
            }
            line.setTarifPrice(so.getPurshasePrice().setScale(2));
            line.setDiscount(so.getDiscount());
            line.setVat(so.getVat() != null ? so.getVat().getValue() : BigDecimal.ZERO);
            line.setProductPack(so.getProductPack());
            cpt++;
            lines.add(calculateTTCAndHT(line));
        }
        supplierInvoice.setSupplierInvoiceLines(new HashSet<>(lines));
        calculateAllLines(supplierInvoice);
        Set<SupplierInvoiceReception> supplierInvoiceReceptions = new HashSet<>();
        for (Reception reception : receptions) {
            Reception rcp = receptionService.findById(reception.getId());
            rcp.setReceptionLines(receptionLines.stream().filter(receptionLine -> (receptionLine.getReception().getId() == reception.getId())).collect(Collectors.toSet()));
            rcp.setActive(false);
            rcp.setOrderStatus(orderStatusService.completedStatus());
            rcp.setInvoice(true);
            rcp = receptionService.save(rcp);

            SupplierInvoiceReception supplierInvoiceReception = new SupplierInvoiceReception();
            supplierInvoiceReception.setReception(rcp);
            supplierInvoiceReceptions.add(supplierInvoiceReception);
        }
        supplierInvoice.setSupplierInvoiceReceptions(supplierInvoiceReceptions);
        supplierInvoice = save(supplierInvoice);
        return supplierInvoice;
    }

    @Override
    @Transactional
    public SupplierInvoice generateSupplierInvoiceFromOrders(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        List<SupplierInvoiceLine> lines = new ArrayList<SupplierInvoiceLine>();
        supplierInvoice.setCode(getNextVal());
        List<PurshaseOrder> purshaseOrders = supplierInvoice.getSupplierInvoicePurchaseOrders().stream().map(supplierInvoiceReception -> supplierInvoiceReception.getPurshaseOrder()).collect(Collectors.toList());

        supplierInvoice.setSupplier(purshaseOrders.get(0).getSupplier());
        supplierInvoice.setDiscount(BigDecimal.ZERO);
        supplierInvoice.setInvoiceStatus(invoiceStatusService.findById(1L));
        supplierInvoice.setOwner(purshaseOrders.get(0).getOwner());
        supplierInvoice.setWarehouse(purshaseOrders.get(0).getWarehouse());
        supplierInvoice.setCurrency(purshaseOrders.get(0).getCurrency());
        supplierInvoice.setActive(true);
//        if (null != purshaseOrders.get(0).getSupplier())
//            supplierInvoice.setDeadLine(getDeadLine(purshaseOrders.get(0).getSupplier()));
        int id = 0;
        String ids = purshaseOrders.stream().map(order -> String.valueOf(order.getId())).collect(Collectors.joining(";"));
        List<PurshaseOrderLine> receptionLines = purshaseOrderLineService.find("purshaseOrder.id^" + ids);
        int cpt = 1;

        for (PurshaseOrderLine so : receptionLines) {
            SupplierInvoiceLine line = new SupplierInvoiceLine();
            line.setId(id);
            id--;
            line.setNumber((long) (cpt * 1000));
            line.setDescription(so.getDescription());
            line.setProduct(so.getProduct());
            line.setUom(so.getUom());
            line.setQuantity(so.getQuantityReceived());
            line.setTarifPrice(so.getPurshasePrice());
            line.setDiscount(so.getDiscount());
            line.setVat(so.getVat() != null ? so.getVat().getValue() : BigDecimal.ZERO);
            line.setProductPack(so.getProductPack());
            cpt++;
            lines.add(calculateTTCAndHT(line));
        }
        supplierInvoice.setSupplierInvoiceLines(new HashSet<>(lines));
        calculateAllLines(supplierInvoice);
        Set<SupplierInvoicePurchaseOrder> supplierInvoiceReceptions = new HashSet<>();
        for (PurshaseOrder purshaseOrder : purshaseOrders) {
            SupplierInvoicePurchaseOrder supplierInvoiceReception = new SupplierInvoicePurchaseOrder();
            supplierInvoiceReception.setPurshaseOrder(purshaseOrder);
            supplierInvoiceReceptions.add(supplierInvoiceReception);
        }
        supplierInvoice.setSupplierInvoicePurchaseOrders(supplierInvoiceReceptions);
        supplierInvoice = save(supplierInvoice);
        return supplierInvoice;
    }

    @Override
    public String addGmaoToSearch(String search) {
        return GmaoSearch.super.addGmaoToSearch(search);
    }
}
