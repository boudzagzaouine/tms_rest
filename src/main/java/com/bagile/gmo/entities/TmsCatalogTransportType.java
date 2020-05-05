package com.bagile.gmo.entities;

import javax.persistence.*;

import com.bagile.gmo.dto.Transport;
import com.bagile.gmo.dto.Vat;
import com.bagile.gmo.dto.VehicleCategory;
import com.bagile.gmo.dto.Zone;

import java.math.BigDecimal;

@Entity
@Table(name="tms_catalogtransport")
public class TmsCatalogTransportType extends EmsEntity{

    private long tmsCatalogTransportId;
    private TrpTransport trpTransport;
    private GmoVehicleCategory tmsVehicleCategory;
    private TmsZone tmsZoneSource ;
    private TmsZone tmsZoneDestination;
    private BigDecimal tmsCatalogTransportAmountHt;
    private BigDecimal tmsCatalogTransportAmountTtc;
    private BigDecimal tmsCatalogTransportAmountTva;
    private PrmVat prmvat;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_catalogtransportcategoryvehicle_id", allocationSize = 1)
    @Column(name = "tms_catalogtransportcategoryvehicleid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsCatalogTransportCategoryVehicleId() {
        return tmsCatalogTransportId;
    }

    public void setTmsCatalogTransportCategoryVehicleId(long tmsCatalogTransportCategoryVehicleId) {
        this.tmsCatalogTransportId = tmsCatalogTransportCategoryVehicleId;
    }

    @ManyToOne()
    @JoinColumn(name = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_vehiclecategoryid")
    public GmoVehicleCategory getTmsVehicleCategory() {
        return tmsVehicleCategory;
    }

    public void setTmsVehicleCategory(GmoVehicleCategory tmsVehicleCategory) {
        this.tmsVehicleCategory = tmsVehicleCategory;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_zonesournceid")
    public TmsZone getTmsZoneSource() {
        return tmsZoneSource;
    }

    public void setTmsZoneSource(TmsZone tmsZoneSource) {
        this.tmsZoneSource = tmsZoneSource;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_zonedistinationid")
    public TmsZone getTmsZoneDestination() {
        return tmsZoneDestination;
    }

    public void setTmsZoneDestination(TmsZone tmsZoneDestination) {
        this.tmsZoneDestination = tmsZoneDestination;
    }

    @Column(name = "tms_catalogtransportamountht")
    public BigDecimal getTmsCatalogTransportCategoryVehicleAmountHt() {
        return tmsCatalogTransportAmountHt;
    }

    public void setTmsCatalogTransportCategoryVehicleAmountHt(BigDecimal tmsCatalogTransportCategoryVehicleAmountHt) {
        this.tmsCatalogTransportAmountHt = tmsCatalogTransportCategoryVehicleAmountHt;
    }

    @Column(name = "tms_catalogtransportamountttc")
    public BigDecimal getTmsCatalogTransportCategoryVehicleAmountTtc() {
        return tmsCatalogTransportAmountTtc;
    }

    public void setTmsCatalogTransportCategoryVehicleAmountTtc(BigDecimal tmsCatalogTransportCategoryVehicleAmountTtc) {
        this.tmsCatalogTransportAmountTtc = tmsCatalogTransportCategoryVehicleAmountTtc;
    }

    @Column(name = "tms_catalogtransportamounttva")
    public BigDecimal getTmsCatalogTransportCategoryVehicleAmountTva() {
        return tmsCatalogTransportAmountTva;
    }

    public void setTmsCatalogTransportCategoryVehicleAmountTva(BigDecimal tmsCatalogTransportCategoryVehicleAmountTva) {
        this.tmsCatalogTransportAmountTva = tmsCatalogTransportCategoryVehicleAmountTva;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "prm_vatid")
    public PrmVat getPrmvat() {
        return prmvat;
    }

    public void setPrmvat(PrmVat prmvat) {
        this.prmvat = prmvat;
    }
}

