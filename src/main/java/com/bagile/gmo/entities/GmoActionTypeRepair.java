package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "gmo_actiontyperepair")
public class GmoActionTypeRepair extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoActionTypeRepairId;
    private String gmoActionTypeRepaireRepairType;
    private String gmoActionTypeRepaireWorkshop;
    private RcpSupplier rcpSupplier;
    private String gmoActionTypeRepaireCity;
    private BigDecimal gmoActionTypeRepairePrice;
    private BigDecimal gmoActionTypeRepaireDuration;

    private GmoActionType gmoActionType;
    private OwnOwner ownOwner;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_action_type_repair_id", allocationSize = 1)
    @Column(name = "gmo_actiontyperepairid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoActionTypeRepairId() {
        return gmoActionTypeRepairId;
    }

    public void setGmoActionTypeRepairId(Long gmoActionTypeRepairId) {
        this.gmoActionTypeRepairId = gmoActionTypeRepairId;
    }
    @Column(name = "gmo_actiontyperepairworkshop")
    public String getGmoActionTypeRepaireWorkshop() {
        return gmoActionTypeRepaireWorkshop;
    }

    public void setGmoActionTypeRepaireWorkshop(String gmoActionTypeRepaireWorkshop) {
        this.gmoActionTypeRepaireWorkshop = gmoActionTypeRepaireWorkshop;
    }

    @ManyToOne
    @JoinColumn(name = "rcp_supplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_actiontypeid")
    public GmoActionType getGmoActionType() {
        return gmoActionType;
    }

    public void setGmoActionType(GmoActionType gmoActionType) {
        this.gmoActionType = gmoActionType;
    }

    @Column(name = "gmo_actiontyperepaircity")
    public String getGmoActionTypeRepaireCity() {
        return gmoActionTypeRepaireCity;
    }
    @Column(name = "gmo_actiontyperepaircity")
    public void setGmoActionTypeRepaireCity(String gmoActionTypeRepaireCity) {
        this.gmoActionTypeRepaireCity = gmoActionTypeRepaireCity;
    }
    @Column(name = "gmo_actiontyperepairprice")
    public BigDecimal getGmoActionTypeRepairePrice() {
        return gmoActionTypeRepairePrice;
    }

    public void setGmoActionTypeRepairePrice(BigDecimal gmoActionTypeRepairePrice) {
        this.gmoActionTypeRepairePrice = gmoActionTypeRepairePrice;
    }
    @Column(name = "gmo_actiontyperepairduration")
    public BigDecimal getGmoActionTypeRepaireDuration() {
        return gmoActionTypeRepaireDuration;
    }

    public void setGmoActionTypeRepaireDuration(BigDecimal gmoActionTypeRepaireDuration) {
        this.gmoActionTypeRepaireDuration = gmoActionTypeRepaireDuration;
    }

    @Column(name = "gmo_actiontyperepairrepairtype")
    public String getGmoActionTypeRepaireRepairType() {
        return gmoActionTypeRepaireRepairType;
    }

    public void setGmoActionTypeRepaireRepairType(String gmoActionTypeRepaireRepairType) {
        this.gmoActionTypeRepaireRepairType = gmoActionTypeRepaireRepairType;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_actiontyperepairownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
