package com.bagile.gmo.entities;

import javax.persistence.*;

import com.bagile.gmo.dto.Uom;

import java.math.BigDecimal;
@Entity
@Table(name="gmo_vehiculefeature")
public class GmoVehicleFeature extends EmsEntity{

    private Long gmoVehicleFeatureId;
    private String gmoVehicleFeatureCode;
    private String gmoVehicleFeatureDescription;
    private BigDecimal gmoVehicleFeatureValue;
    private PdtUom pdtUomunit;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vehiculefeature_id", allocationSize = 1)
    @Column(name = "gmo_vehiculefeatureid", unique = true, nullable = false, precision = 10, scale = 0)

    public Long getGmoVehicleFeatureId() {
        return gmoVehicleFeatureId;
    }

    public void setGmoVehicleFeatureId(Long gmoVehicleFeatureId) {
        this.gmoVehicleFeatureId = gmoVehicleFeatureId;
    }
    @Column(name = "gmo_vehiclefeaturecode")
    public String getGmoVehicleFeatureCode() {
        return gmoVehicleFeatureCode;
    }

    public void setGmoVehicleFeatureCode(String gmoVehicleFeatureCode) {
        this.gmoVehicleFeatureCode = gmoVehicleFeatureCode;
    }
    @Column(name = "gmo_vehiclefeaturedescription")
    public String getGmoVehicleFeatureDescription() {
        return gmoVehicleFeatureDescription;
    }

    public void setGmoVehicleFeatureDescription(String gmoVehicleFeatureDescription) {
        this.gmoVehicleFeatureDescription = gmoVehicleFeatureDescription;
    }

    @Column(name = "gmo_vehiclefeaturevalue")
    public BigDecimal getGmoVehicleFeatureValue() {
        return gmoVehicleFeatureValue;
    }

    public void setGmoVehicleFeatureValue(BigDecimal gmoVehicleFeatureValue) {
        this.gmoVehicleFeatureValue = gmoVehicleFeatureValue;
    }
    @Column(name = "prdt_uomunit")
    public PdtUom getPdtUomunit() {
        return pdtUomunit;
    }

    public void setPdtUomunit(PdtUom pdtUomunit) {
        this.pdtUomunit = pdtUomunit;
    }
}
