package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="gmo_fuelPump")
public class GmoFuelPump extends EmsEntity{

    private Long gmoFuelPumpId;
    private String gmoFuelPumpCode;
    private PdtProduct pdtProduct;
    private GmoPump gmoPump;
    private BigDecimal gmoFuelPumpQuantity;

    private LocLocation locLocation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_fuelpump_id", allocationSize = 1)
    @Column(name = "gmo_fuelpumpid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoFuelPumpId() {
        return gmoFuelPumpId;
    }

    public void setGmoFuelPumpId(Long gmoFuelPumpId) {
        this.gmoFuelPumpId = gmoFuelPumpId;
    }

    @Column(name = "gmo_fuelpumpcode", unique = true, nullable = false, length = 90)
    public String getGmoFuelPumpCode() {
        return gmoFuelPumpCode;
    }

    public void setGmoFuelPumpCode(String gmoFuelPumpCode) {
        this.gmoFuelPumpCode = gmoFuelPumpCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_productid", nullable = false)
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_pumpid", nullable = false)
    public GmoPump getGmoPump() {
        return gmoPump;
    }

    public void setGmoPump(GmoPump pump) {
        this.gmoPump = pump;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_loclocationid")
    public LocLocation getLocLocation() {
        return locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }


    @Column(name = "gmo_fuelpumpquantity")
    public BigDecimal getGmoFuelPumpQuantity() {
        return gmoFuelPumpQuantity;
    }

    public void setGmoFuelPumpQuantity(BigDecimal gmoFuelPumpQuantity) {
        this.gmoFuelPumpQuantity = gmoFuelPumpQuantity;
    }
}
