package com.bagile.gmo.entities;

import com.bagile.gmo.dto.Product;
import com.bagile.gmo.dto.Supplier;
import com.bagile.gmo.dto.Uom;
import com.bagile.gmo.dto.Vat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_supplierproduct")
public class TmsSupplierProduct extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsSupplierProductId;
    private PdtProduct pdtProduct;
    private RcpSupplier rcpSupplier;
    private PdtUom pdtUom;
    private BigDecimal tmsSupplierProductPriceHT;
    private PrmVat prmVat;
    private BigDecimal tmsSupplierProductPriceTTC;
    private OwnOwner ownOwner;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_suuplier_product_id", allocationSize = 1)
    @Column(name = "tms_supplierproductid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsSupplierProductId() {
        return tmsSupplierProductId;
    }

    public void setTmsSupplierProductId(Long tmsSupplierProductId) {
        this.tmsSupplierProductId = tmsSupplierProductId;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_pdtproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_rcpsupplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_pdtuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

    @Column(name = "tms_supplierproductpriceht")
    public BigDecimal getTmsSupplierProductPriceHT() {
        return tmsSupplierProductPriceHT;
    }

    public void setTmsSupplierProductPriceHT(BigDecimal tmsSupplierProductPriceHT) {
        this.tmsSupplierProductPriceHT = tmsSupplierProductPriceHT;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_prmvatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @Column(name = "tms_supplierproductpricettc")
    public BigDecimal getTmsSupplierProductPriceTTC() {
        return tmsSupplierProductPriceTTC;
    }

    public void setTmsSupplierProductPriceTTC(BigDecimal tmsSupplierProductPriceTTC) {
        this.tmsSupplierProductPriceTTC = tmsSupplierProductPriceTTC;
    }



    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
