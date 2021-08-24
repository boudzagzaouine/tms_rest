package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoBadge;
import com.bagile.gmo.entities.StkStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface StockRepository extends JpaRepository<StkStock,Long>,
        QuerydslPredicateExecutor<StkStock> {

    @Query(value = "select sum(stk_stockquantitybaseuom),stk_stocklot,stk_stockserialno,stk_stockdlc,stk_stockdluo,stk_stockproductdimensionid,stk_stockweight,stk_stockquality,stk_stockcolorid from schema_crm.stk_stock where stk_stockactive=true and stk_stockwarehouseid=?1 and stk_stockproductid=?2 group by stk_stocklot,stk_stockserialno,stk_stockdlc,stk_stockdluo,stk_stockproductdimensionid,stk_stockweight,stk_stockquality,stk_stockcolorid",nativeQuery = true)
    public List<Object[]> getProductQuantity(long warehouseId, long productId);

    @Query(value = "select sum(stk_stockquantitybaseuom),stk_stocklot,stk_stockserialno,stk_stockdlc,stk_stockdluo,stk_stockproductdimensionid,stk_stockweight,stk_stockquality,stk_stockcolorid from schema_crm.stk_stock where stk_stockactive=true and stk_stockwarehouseid=?1 and stk_stockproductid=?2 and stk_stocklocationid=?3 group by stk_stocklot,stk_stockserialno,stk_stockdlc,stk_stockdluo,stk_stockproductdimensionid,stk_stockweight,stk_stockquality,stk_stockcolorid",nativeQuery = true)
    public List<Object[]> getProductQuantityLocation(long warehouseId,long productId,long locationId);
}