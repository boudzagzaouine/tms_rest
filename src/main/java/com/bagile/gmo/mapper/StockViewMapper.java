package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.StockView;
import com.bagile.gmo.entities.StkStockView;

import java.util.*;

public class StockViewMapper {
    private StockViewMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "stkStockViewId");

        map.put("product", "pdtProduct");

        // map.put("warehouse", "wrhWarehouse");


    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static StkStockView toEntity(StockView stockview, boolean lazy) {
        if (null == stockview) {
            return null;
        }
        StkStockView stkStockView = new StkStockView();


        stkStockView.setStk_stockviewquantity(stockview.getQuantity());
        stkStockView.setStk_stockviewpriceht(stockview.getPrice());




        if (!lazy) {

            stkStockView.setPdtProduct(ProductMapper.toEntity(stockview.getProduct(), true));


        }
        return stkStockView;
    }

    public static StockView toDto(StkStockView stkStockView, boolean lazy) {
        if (null == stkStockView) {
            return null;
        }
        StockView stockview = new StockView();

        stockview.setQuantity(stkStockView.getStk_stockviewquantity());
        stockview.setPrice(stkStockView.getStk_stockviewpriceht());



        if (!lazy) {
            stockview.setProduct(ProductMapper.toDto(stkStockView.getPdtProduct(), false));
          //  stockview.setWarehouse(WarehouseMapper.toDto(stkStockView.getWrhWarehouse(), true));

        }
        return stockview;
    }



    public static List<StockView> toDtos(List<StkStockView> stkStockViews, boolean lazy) {
        if (null == stkStockViews) {
            return null;
        }
        List<StockView> stocks = new ArrayList<>();
        for (StkStockView stkStockView : stkStockViews) {
            stocks.add(toDto(stkStockView, lazy));
        }
        return stocks;
    }



    public static List<StockView> toDtos(Iterable<StkStockView> stkStockViews, boolean lazy) {
        if (null == stkStockViews) {
            return null;
        }
        List<StockView> stocks = new ArrayList<>();
        for (StkStockView stkStockView : stkStockViews) {
            stocks.add(toDto(stkStockView, lazy));
        }
        return stocks;
    }


    public static Set<StkStockView> toEntities(Set<StockView> stocks, boolean lazy) {
        if (null == stocks) {
            return null;
        }
        Set<StkStockView> stkStockViews = new HashSet<>();
        for (StockView stockview : stocks) {
            stkStockViews.add(toEntity(stockview, lazy));
        }
        return stkStockViews;
    }

    public static Set<StockView> toDtos(Set<StkStockView> stkStockViews, boolean lazy) {
        if (null == stkStockViews) {
            return null;
        }
        Set<StockView> stocks = new HashSet<>();
        for (StkStockView stkStockView : stkStockViews) {
            stocks.add(toDto(stkStockView, lazy));
        }
        return stocks;
    }
}
