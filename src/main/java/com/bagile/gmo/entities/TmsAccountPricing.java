package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_account_pricing")
public class TmsAccountPricing extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsAccountPricingId;
    private CmdAccount cmdAccount;
    private GmoCatalogTransportType gmoCatalogTransportType;
    private BigDecimal tmsAccountPricingPrice ;

    private TrpTransport trpTransport;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_account_pricing_id", allocationSize = 1)
    @Column(name = "gmo_accountpricingid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsAccountPricingId() {
        return tmsAccountPricingId;
    }

    public void setTmsAccountPricingId(Long tmsAccountPricingId) {
        this.tmsAccountPricingId = tmsAccountPricingId;
    }

    @ManyToOne()
    @JoinColumn(name="tms_cmdaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @ManyToOne()
    @JoinColumn(name="tms_gmocatalogtransporttypeid")
    public GmoCatalogTransportType getGmoCatalogTransportType() {
        return gmoCatalogTransportType;
    }

    public void setGmoCatalogTransportType(GmoCatalogTransportType gmoCatalogTransportType) {
        this.gmoCatalogTransportType = gmoCatalogTransportType;
    }

    @Column(name = "tms_aacountpricingprice")
    public BigDecimal getTmsAccountPricingPrice() {
        return tmsAccountPricingPrice;
    }

    public void setTmsAccountPricingPrice(BigDecimal tmsAccountPricingPrice) {
        this.tmsAccountPricingPrice = tmsAccountPricingPrice;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
    @ManyToOne()
    @JoinColumn(name="tms_trptransportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }


    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }
}
