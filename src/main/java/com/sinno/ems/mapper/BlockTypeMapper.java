package com.sinno.ems.mapper;

import com.sinno.ems.dto.BlockType;
import com.sinno.ems.entities.PrmBlockType;

import java.util.*;

public class BlockTypeMapper {
    private BlockTypeMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmBlockTypeId");
        map.put("owner", "ownOwner");
        map.put("code", "prmBlockTypeCode");
        map.put("description", "prmBlockTypeDescription");
        map.put("creationDate", "prmBlockTypeCreationDate");
        map.put("updateDate", "prmBlockTypeUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PrmBlockType toEntity(BlockType blockType, boolean lazy) {
        if (null == blockType) {
            return null;
        }
        PrmBlockType prmBlockType = new PrmBlockType();
        prmBlockType.setPrmBlockTypeId(blockType.getId());
        prmBlockType.setPrmBlockTypeCode(blockType.getCode() != null ? blockType.getCode().toUpperCase() : null);
        prmBlockType.setPrmBlockTypeDescription(blockType.getDescription());
        prmBlockType.setPrmBlockTypeCreationDate(blockType.getCreationDate());
        prmBlockType.setPrmBlockTypeUpdateDate(blockType.getUpdateDate());
        if (!lazy) {
            prmBlockType.setOwnOwner(OwnerMapper.toEntity(blockType.getOwner(), true));
//            prmBlockType.setCmdSaleOrderLineArcs(SaleOrderLineArcMapper.toEntities(blockType.getSaleOrderLineArcs(), true));
//            prmBlockType.setPdtProducts(ProductMapper.toEntities(blockType.getProducts(), true));
//            prmBlockType.setCmdSaleOrderStocks(SaleOrderStockMapper.toEntities(blockType.getSaleOrderStocks(), true));
//            prmBlockType.setRcpReceptionLines(ReceptionLineMapper.toEntities(blockType.getReceptionLines(), true));
//            prmBlockType.setRcpPurshaseOrderLines(PurshaseOrderLineMapper.toEntities(blockType.getPurshaseOrderLines(), true));
//            prmBlockType.setRcpReceptionStockArcs(ReceptionStockArcMapper.toEntities(blockType.getReceptionStockArcs(), true));
//            prmBlockType.setStkStockReserveds(StockReservedMapper.toEntities(blockType.getStockReserveds(), true));
//            prmBlockType.setCmdSaleOrderStockArcs(SaleOrderStockArcMapper.toEntities(blockType.getSaleOrderStockArcs(), true));
//            prmBlockType.setRcpReceptionStocks(ReceptionStockMapper.toEntities(blockType.getReceptionStocks(), true));
//            prmBlockType.setStkStocks(StockMapper.toEntities(blockType.getStocks(), true));
//            prmBlockType.setRcpReceptionLineArcs(ReceptionLineArcMapper.toEntities(blockType.getReceptionLineArcs(), true));
//            prmBlockType.setRcpPurshaseOrderLineArcs(PurshaseOrderLineArcMapper.toEntities(blockType.getPurshaseOrderLineArcs(), true));
//            prmBlockType.setStkStockArcs(StockArcMapper.toEntities(blockType.getStockArcs(), true));
//            prmBlockType.setCmdSaleOrderLines(SaleOrderLineMapper.toEntities(blockType.getSaleOrderLines(), true));
        }
        return prmBlockType;
    }

    public static BlockType toDto(PrmBlockType prmBlockType, boolean lazy) {
        if (null == prmBlockType) {
            return null;
        }
        BlockType blockType = new BlockType();
        blockType.setId(prmBlockType.getPrmBlockTypeId());
        blockType.setCode(prmBlockType.getPrmBlockTypeCode());
        blockType.setDescription(prmBlockType.getPrmBlockTypeDescription());
        blockType.setCreationDate(prmBlockType.getPrmBlockTypeCreationDate());
        blockType.setUpdateDate(prmBlockType.getPrmBlockTypeUpdateDate());
        if (!lazy) {
            blockType.setSaleOrderLineArcs(SaleOrderLineArcMapper.toDtos(prmBlockType.getCmdSaleOrderLineArcs(), true));
            blockType.setProducts(ProductMapper.toDtos(prmBlockType.getPdtProducts(), true));
            blockType.setOwner(OwnerMapper.toDto(prmBlockType.getOwnOwner(), true));
            blockType.setSaleOrderStocks(SaleOrderStockMapper.toDtos(prmBlockType.getCmdSaleOrderStocks(), true));
            blockType.setReceptionLines(ReceptionLineMapper.toDtos(prmBlockType.getRcpReceptionLines(), true));
            blockType.setPurshaseOrderLines(PurshaseOrderLineMapper.toDtos(prmBlockType.getRcpPurshaseOrderLines(), true));
            blockType.setReceptionStockArcs(ReceptionStockArcMapper.toDtos(prmBlockType.getRcpReceptionStockArcs(), true));
            blockType.setStockReserveds(StockReservedMapper.toDtos(prmBlockType.getStkStockReserveds(), true));
            blockType.setSaleOrderStockArcs(SaleOrderStockArcMapper.toDtos(prmBlockType.getCmdSaleOrderStockArcs(), true));
            blockType.setReceptionStocks(ReceptionStockMapper.toDtos(prmBlockType.getRcpReceptionStocks(), true));
            blockType.setStocks(StockMapper.toDtos(prmBlockType.getStkStocks(), true));
            blockType.setReceptionLineArcs(ReceptionLineArcMapper.toDtos(prmBlockType.getRcpReceptionLineArcs(), true));
            blockType.setPurshaseOrderLineArcs(PurshaseOrderLineArcMapper.toDtos(prmBlockType.getRcpPurshaseOrderLineArcs(), true));
            blockType.setStockArcs(StockArcMapper.toDtos(prmBlockType.getStkStockArcs(), true));
            blockType.setSaleOrderLines(SaleOrderLineMapper.toDtos(prmBlockType.getCmdSaleOrderLines(), true));
        }
        return blockType;
    }

    public static List<BlockType> toDtos(List<PrmBlockType> prmBlockTypes, boolean lazy) {
        if (null == prmBlockTypes) {
            return null;
        }
        List<BlockType> blockTypes = new ArrayList<>();
        for (PrmBlockType prmBlockType : prmBlockTypes) {
            blockTypes.add(toDto(prmBlockType, lazy));
        }
        return blockTypes;
    }

    public static List<BlockType> toDtos(Iterable<PrmBlockType> prmBlockTypes, boolean lazy) {
        if (null == prmBlockTypes) {
            return null;
        }
        List<BlockType> blockTypes = new ArrayList<>();
        for (PrmBlockType prmBlockType : prmBlockTypes) {
            blockTypes.add(toDto(prmBlockType, lazy));
        }
        return blockTypes;
    }

    public static Set<PrmBlockType> toEntities(Set<BlockType> blockTypes, boolean lazy) {
        if (null == blockTypes) {
            return null;
        }
        Set<PrmBlockType> prmBlockTypes = new HashSet<>();
        for (BlockType blockType : blockTypes) {
            prmBlockTypes.add(toEntity(blockType, lazy));
        }
        return prmBlockTypes;
    }

    public static Set<BlockType> toDtos(Set<PrmBlockType> prmBlockTypes, boolean lazy) {
        if (null == prmBlockTypes) {
            return null;
        }
        Set<BlockType> blockTypes = new HashSet<>();
        for (PrmBlockType prmBlockType : prmBlockTypes) {
            blockTypes.add(toDto(prmBlockType, lazy));
        }
        return blockTypes;
    }
}
