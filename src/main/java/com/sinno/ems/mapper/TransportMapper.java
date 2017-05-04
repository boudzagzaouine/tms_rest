/**
 *
 */
package com.sinno.ems.mapper;

import com.sinno.ems.dto.Transport;
import com.sinno.ems.entities.TrpTransport;

import java.util.*;

/**
 * @author aelguezzar
 */
public class TransportMapper {
    private TransportMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "trpTransportId");
        map.put("contact", "prmContact");
        map.put("code", "trpTransportCode");
        map.put("description", "trpTransportDescription");
        map.put("address", "trpTransportAddress");
        map.put("active", "trpTransportIsActive");
        map.put("siret", "trpTransportSiret");
        map.put("comment", "trpTransportComment");
        map.put("edi", "prmEdi");
        map.put("creationDate", "trpTransportCreationDate");
        map.put("updateDate", "trpTransportUpdateDate");
        map.put("variable1", "trpTransportVariable1");
        map.put("variable2", "trpTransportVariable2");
        map.put("variable3", "trpTransportVariable3");
        map.put("variable4", "trpTransportVariable4");
        map.put("variable5", "trpTransportVariable5");
        map.put("variable6", "trpTransportVariable6");
        map.put("variable7", "trpTransportVariable7");
        map.put("variable8", "trpTransportVariable8");
        map.put("variable9", "trpTransportVariable9");
        map.put("variable10", "trpTransportVariable10");
        map.put("name", "trpTransportName");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static Transport toDto(TrpTransport trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        Transport transport = new Transport();
        transport.setCode(trpTransport.getTrpTransportCode());
        transport.setComment(trpTransport.getTrpTransportComment());
        transport.setCreationDate(trpTransport.getTrpTransportCreationDate());
        transport.setDescription(trpTransport.getTrpTransportDescription());
        transport.setId(trpTransport.getTrpTransportId());
        transport.setSiret(trpTransport.getTrpTransportSiret());
        transport.setUpdateDate(trpTransport.getTrpTransportUpdateDate());
        transport.setVariable1(trpTransport.getTrpTransportVariable1());
        transport.setVariable2(trpTransport.getTrpTransportVariable2());
        transport.setVariable3(trpTransport.getTrpTransportVariable3());
        transport.setVariable4(trpTransport.getTrpTransportVariable4());
        transport.setVariable5(trpTransport.getTrpTransportVariable5());
        transport.setVariable6(trpTransport.getTrpTransportVariable6());
        transport.setVariable7(trpTransport.getTrpTransportVariable7());
        transport.setVariable8(trpTransport.getTrpTransportVariable8());
        transport.setVariable9(trpTransport.getTrpTransportVariable9());
        transport.setVariable10(trpTransport.getTrpTransportVariable10());
        transport.setActive(trpTransport.getTrpTransportIsActive());
        transport.setName(trpTransport.getTrpTransportName());
        if (!lazy) {
            transport.setEdi(EdiMapper.toDto(trpTransport.getPrmEdi(), true));
            transport.setContact(ContactMapper.toDto(trpTransport.getPrmContact(), true));
            transport.setAddress(AddressMapper.toDto(trpTransport.getAdrAddress(), true));
//            transport.setSaleOrderLineArcs(SaleOrderLineArcMapper.toDtos(trpTransport.getCmdSaleOrderLineArcs(), true));
//            transport.setAccounts(AccountMapper.toDtos(trpTransport.getCmdAccounts(), true));
//            transport.setPurshaseOrderArcs(PurshaseOrderArcMapper.toDtos(trpTransport.getRcpPurshaseOrderArcs(), true));
//            transport.setPurshaseOrders(PurshaseOrderMapper.toDtos(trpTransport.getRcpPurshaseOrders(), true));
//            transport.setReceptionArcs(ReceptionArcMapper.toDtos(trpTransport.getRcpReceptionArcs(), true));
//            transport.setReceptions(ReceptionMapper.toDtos(trpTransport.getRcpReceptions(), true));
//            transport.setSaleOrderArcs(SaleOrderArcMapper.toDtos(trpTransport.getCmdSaleOrderArcs(), true));
//            transport.setSaleOrderLines(SaleOrderLineMapper.toDtos(trpTransport.getCmdSaleOrderLines(), true));
//            transport.setSaleOrders(SaleOrderMapper.toDtos(trpTransport.getCmdSaleOrders(), true));
//            transport.setSuppliers(SupplierMapper.toDtos(trpTransport.getRcpSuppliers(), true));
        }
        return transport;
    }

    public static TrpTransport toEntity(Transport transport, boolean lazy) {
        if (null == transport) {
            return null;
        }
        TrpTransport trpTransport = new TrpTransport();
        trpTransport.setTrpTransportCode(transport.getCode() != null ? transport.getCode().toUpperCase() : null);
        trpTransport.setTrpTransportName(transport.getName());
        trpTransport.setTrpTransportComment(transport.getComment());
        trpTransport.setTrpTransportCreationDate(transport.getCreationDate());
        trpTransport.setTrpTransportDescription(transport.getDescription());
        trpTransport.setTrpTransportId(transport.getId());
        trpTransport.setTrpTransportSiret(transport.getSiret());
        trpTransport.setTrpTransportUpdateDate(transport.getUpdateDate());
        trpTransport.setTrpTransportVariable1(transport.getVariable1());
        trpTransport.setTrpTransportVariable2(transport.getVariable2());
        trpTransport.setTrpTransportVariable3(transport.getVariable3());
        trpTransport.setTrpTransportVariable4(transport.getVariable4());
        trpTransport.setTrpTransportVariable5(transport.getVariable5());
        trpTransport.setTrpTransportVariable6(transport.getVariable6());
        trpTransport.setTrpTransportVariable7(transport.getVariable7());
        trpTransport.setTrpTransportVariable8(transport.getVariable8());
        trpTransport.setTrpTransportVariable9(transport.getVariable9());
        trpTransport.setTrpTransportVariable10(transport.getVariable10());
        trpTransport.setTrpTransportIsActive(transport.getActive());
        if (!lazy) {
            trpTransport.setPrmEdi(EdiMapper.toEntity(transport.getEdi(), true));
            trpTransport.setPrmContact(ContactMapper.toEntity(transport.getContact(), true));
            trpTransport.setAdrAddress(AddressMapper.toEntity(transport.getAddress(), true));
//            trpTransport.setCmdSaleOrderArcs(SaleOrderArcMapper.toEntities(transport.getSaleOrderArcs(), true));
//            trpTransport.setCmdAccounts(AccountMapper.toEntities(transport.getAccounts(), true));
//            trpTransport.setCmdSaleOrderLineArcs(SaleOrderLineArcMapper.toEntities(transport.getSaleOrderLineArcs(), true));
//            trpTransport.setCmdSaleOrderLines(SaleOrderLineMapper.toEntities(transport.getSaleOrderLines(), true));
//            trpTransport.setCmdSaleOrders(SaleOrderMapper.toEntities(transport.getSaleOrders(), true));
//            trpTransport.setRcpPurshaseOrderArcs(PurshaseOrderArcMapper.toEntities(transport.getPurshaseOrderArcs(), true));
//            trpTransport.setRcpPurshaseOrders(PurshaseOrderMapper.toEntities(transport.getPurshaseOrders(), true));
//            trpTransport.setRcpReceptionArcs(ReceptionArcMapper.toEntities(transport.getReceptionArcs(), true));
//            trpTransport.setRcpReceptions(ReceptionMapper.toEntities(transport.getReceptions(), true));
//            trpTransport.setRcpSuppliers(SupplierMapper.toEntities(transport.getSuppliers(), true));
        }
        return trpTransport;
    }

    public static List<Transport> toDtos(List<TrpTransport> trpTransports, boolean lazy) {
        if (null == trpTransports) {
            return null;
        }
        List<Transport> transports = new ArrayList<>();
        for (TrpTransport trpTransport : trpTransports) {
            transports.add(toDto(trpTransport, lazy));
        }
        return transports;
    }

    public static List<Transport> toDtos(Iterable<TrpTransport> trpTransports, boolean lazy) {
        if (null == trpTransports) {
            return null;
        }
        List<Transport> transports = new ArrayList<>();
        for (TrpTransport trpTransport : trpTransports) {
            transports.add(toDto(trpTransport, lazy));
        }
        return transports;
    }

    public static Set<TrpTransport> toEntities(Set<Transport> transports, boolean lazy) {
        if (null == transports) {
            return null;
        }
        Set<TrpTransport> trpTransports = new HashSet<>();
        for (Transport transport : transports) {
            trpTransports.add(toEntity(transport, lazy));
        }
        return trpTransports;
    }

    public static Set<Transport> toDtos(Set<TrpTransport> trpTransports, boolean lazy) {
        if (null == trpTransports) {
            return null;
        }
        Set<Transport> transports = new HashSet<>();
        for (TrpTransport trpTransport : trpTransports) {
            transports.add(toDto(trpTransport, lazy));
        }
        return transports;
    }

}
