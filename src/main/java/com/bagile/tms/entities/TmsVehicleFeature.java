package com.bagile.tms.entities;

import com.bagile.tms.dto.Uom;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name="tms_vehiculefeature")
public class TmsVehicleFeature extends EmsEntity{

    private long tmsVehicleFeatureId;
    private String tmsVehicleFeatureCode;
    private String tmsVehicleFeatureDescription;
    private BigDecimal tmsVehicleFeatureValue;
    private PdtUom pdtUomunit;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehiculefeature_id", allocationSize = 1)
    @Column(name = "tms_vehiculefeatureid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsVehicleFeatureId() {
        return tmsVehicleFeatureId;
    }

    public void setTmsVehicleFeatureId(long tmsVehicleFeatureId) {
        this.tmsVehicleFeatureId = tmsVehicleFeatureId;
    }
    @Column(name = "tms_vehiclefeaturecode")
    public String getTmsVehicleFeatureCode() {
        return tmsVehicleFeatureCode;
    }

    public void setTmsVehicleFeatureCode(String tmsVehicleFeatureCode) {
        this.tmsVehicleFeatureCode = tmsVehicleFeatureCode;
    }
    @Column(name = "tms_vehiclefeaturedescription")
    public String getTmsVehicleFeatureDescription() {
        return tmsVehicleFeatureDescription;
    }

    public void setTmsVehicleFeatureDescription(String tmsVehicleFeatureDescription) {
        this.tmsVehicleFeatureDescription = tmsVehicleFeatureDescription;
    }

    @Column(name = "tms_vehiclefeaturevalue")
    public BigDecimal getTmsVehicleFeatureValue() {
        return tmsVehicleFeatureValue;
    }

    public void setTmsVehicleFeatureValue(BigDecimal tmsVehicleFeatureValue) {
        this.tmsVehicleFeatureValue = tmsVehicleFeatureValue;
    }
    @Column(name = "prdt_uomunit")
    public PdtUom getPdtUomunit() {
        return pdtUomunit;
    }

    public void setPdtUomunit(PdtUom pdtUomunit) {
        this.pdtUomunit = pdtUomunit;
    }
}
