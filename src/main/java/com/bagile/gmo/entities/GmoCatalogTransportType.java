package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="gmo_catalogtransport",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"gmo_vehiclecategoryid","trp_transportid",
                               "gmo_villesournceid","gmo_villedistinationid","gmo_tmsturntypeid"})})
public class GmoCatalogTransportType extends EmsEntity{

    private Long gmoCatalogTransportId;
    private TrpTransport trpTransport;
    private GmoVehicleCategory gmoVehicleCategory;

    private TmsTurnType tmsTurnType;
    private PrmVille gmoVilleSource ;
    private PrmVille gmoVilleDestination;
    private BigDecimal gmoCatalogTransportAmountHt;
    private BigDecimal gmoCatalogTransportAmountTtc;
    private BigDecimal gmoCatalogTransportAmountTva;
    private PrmVat prmvat;


    private BigDecimal gmoCatalogTransportGroupingAmountHt;
    private BigDecimal gmoCatalogTransportGroupingAmountTtc;
    private BigDecimal gmoCatalogTransportGroupingAmountTva;
    private PrmVat prmGroupingVat;

    private Boolean gmoCatalogTransportInternOrExterne ;
    private OwnOwner ownOwner;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_catalogtransportcategoryvehicle_id", allocationSize = 1)
    @Column(name = "gmo_catalogtransportcategoryvehicleid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoCatalogTransportId() {
        return gmoCatalogTransportId;
    }

    public void setGmoCatalogTransportId(Long gmoCatalogTransportId) {
        this.gmoCatalogTransportId = gmoCatalogTransportId;
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
    @JoinColumn(name = "gmo_vehiclecategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_villesournceid")
    public PrmVille getGmoVilleSource() {
        return gmoVilleSource;
    }

    public void setGmoVilleSource(PrmVille gmoVilleSource) {
        this.gmoVilleSource = gmoVilleSource;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_tmsturntypeid")
    public TmsTurnType getTmsTurnType() {
        return tmsTurnType;
    }

    public void setTmsTurnType(TmsTurnType tmsTurnType) {
        this.tmsTurnType = tmsTurnType;
    }




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_villedistinationid")
    public PrmVille getGmoVilleDestination() {
        return gmoVilleDestination;
    }

    public void setGmoVilleDestination(PrmVille gmoVilleDestination) {
        this.gmoVilleDestination = gmoVilleDestination;
    }



    @Column(name = "gmo_catalogtransportamountht")
    public BigDecimal getGmoCatalogTransportCategoryVehicleAmountHt() {
        return gmoCatalogTransportAmountHt;
    }

    public void setGmoCatalogTransportCategoryVehicleAmountHt(BigDecimal gmoCatalogTransportCategoryVehicleAmountHt) {
        this.gmoCatalogTransportAmountHt = gmoCatalogTransportCategoryVehicleAmountHt;
    }

    @Column(name = "gmo_catalogtransportinternorexterne")
    public Boolean getGmoCatalogTransportInternOrExterne() {
        return gmoCatalogTransportInternOrExterne;
    }

    public void setGmoCatalogTransportInternOrExterne(Boolean gmoCatalogTransportInternOrExterne) {
        this.gmoCatalogTransportInternOrExterne = gmoCatalogTransportInternOrExterne;
    }

    @Column(name = "gmo_catalogtransportamountttc")
    public BigDecimal getGmoCatalogTransportCategoryVehicleAmountTtc() {
        return gmoCatalogTransportAmountTtc;
    }

    public void setGmoCatalogTransportCategoryVehicleAmountTtc(BigDecimal gmoCatalogTransportCategoryVehicleAmountTtc) {
        this.gmoCatalogTransportAmountTtc = gmoCatalogTransportCategoryVehicleAmountTtc;
    }

    @Column(name = "gmo_catalogtransportamounttva")
    public BigDecimal getGmoCatalogTransportCategoryVehicleAmountTva() {
        return gmoCatalogTransportAmountTva;
    }

    public void setGmoCatalogTransportCategoryVehicleAmountTva(BigDecimal gmoCatalogTransportCategoryVehicleAmountTva) {
        this.gmoCatalogTransportAmountTva = gmoCatalogTransportCategoryVehicleAmountTva;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "prm_vatid")
    public PrmVat getPrmvat() {
        return prmvat;
    }

    public void setPrmvat(PrmVat prmvat) {
        this.prmvat = prmvat;
    }


   @ManyToOne()
   @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }


    @Column(name = "gmo_catalogtransportgroupingamountht")
    public BigDecimal getGmoCatalogTransportGroupingAmountHt() {
        return gmoCatalogTransportGroupingAmountHt;
    }

    public void setGmoCatalogTransportGroupingAmountHt(BigDecimal gmoCatalogTransportGroupingAmountHt) {
        this.gmoCatalogTransportGroupingAmountHt = gmoCatalogTransportGroupingAmountHt;
    }

    @Column(name = "gmo_catalogtransportgroupingamountttc")
    public BigDecimal getGmoCatalogTransportGroupingAmountTtc() {
        return gmoCatalogTransportGroupingAmountTtc;
    }

    public void setGmoCatalogTransportGroupingAmountTtc(BigDecimal gmoCatalogTransportGroupingAmountTtc) {
        this.gmoCatalogTransportGroupingAmountTtc = gmoCatalogTransportGroupingAmountTtc;
    }
    @Column(name = "gmo_catalogtransportgroupingamounttva")
    public BigDecimal getGmoCatalogTransportGroupingAmountTva() {
        return gmoCatalogTransportGroupingAmountTva;
    }

    public void setGmoCatalogTransportGroupingAmountTva(BigDecimal gmoCatalogTransportGroupingAmountTva) {
        this.gmoCatalogTransportGroupingAmountTva = gmoCatalogTransportGroupingAmountTva;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_groupingvatid")
    public PrmVat getPrmGroupingVat() {
        return prmGroupingVat;
    }

    public void setPrmGroupingVat(PrmVat prmGroupingVat) {
        this.prmGroupingVat = prmGroupingVat;
    }
}

