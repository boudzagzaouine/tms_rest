package com.bagile.gmo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 22/12/2016.
 */
@Entity
@Table(name="prm_currency",uniqueConstraints = @UniqueConstraint(columnNames = "prm_currencycode"))
public class PrmCurrency extends EmsEntity{
    private long prmCurrencyId;
    @NotNull
    private String prmCurrencyCode;
    private String prmCurrencySymbol;
    private String prmCurrencyDescription;
    private Date prmCurrencyCreationDate;
    private Date prmCurrencyUpdateDate;
    private Boolean prmCurrencyByDefault;
    private BigDecimal prmCurrencyExchagenRate;
    private BigDecimal prmCurrencyExchagenRatePurchase;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_tmsvoieexpress.prm_currency_prm_currencyid_seq", allocationSize = 1)
    @Column(name = "prm_currencyid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmCurrencyId() {
        return prmCurrencyId;
    }

    public void setPrmCurrencyId(long prmCurrencyId) {
        this.prmCurrencyId = prmCurrencyId;
    }
    @Column(name = "prm_currencycode")
    public String getPrmCurrencyCode() {
        return prmCurrencyCode;
    }

    public void setPrmCurrencyCode(String prmCurrencyCode) {
        this.prmCurrencyCode = prmCurrencyCode;
    }
    @Column(name = "prm_currencydescription")
    public String getPrmCurrencyDescription() {
        return prmCurrencyDescription;
    }

    public void setPrmCurrencyDescription(String prmCurrencyDescription) {
        this.prmCurrencyDescription = prmCurrencyDescription;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_currencycreationdate")
    public Date getPrmCurrencyCreationDate() {
        return prmCurrencyCreationDate;
    }

    public void setPrmCurrencyCreationDate(Date prmCurrencyCreationDate) {
        this.prmCurrencyCreationDate = prmCurrencyCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_currencyupdatedate")
    public Date getPrmCurrencyUpdateDate() {
        return prmCurrencyUpdateDate;
    }

    public void setPrmCurrencyUpdateDate(Date prmCurrencyUpdateDate) {
        this.prmCurrencyUpdateDate = prmCurrencyUpdateDate;
    }

    @Column(name="prm_currencybydefault")
    public Boolean getPrmCurrencyByDefault() {
        return prmCurrencyByDefault;
    }

    public void setPrmCurrencyByDefault(Boolean prmCurrencyByDefault) {
        this.prmCurrencyByDefault = prmCurrencyByDefault;
    }
    @Column(name="prm_currencysymbol")

    public String getPrmCurrencySymbol() {
        return prmCurrencySymbol;
    }

    public void setPrmCurrencySymbol(String prmCurrencySymbol) {
        this.prmCurrencySymbol = prmCurrencySymbol;
    }
    @Column(name="prm_currencyexchangerate")

    public BigDecimal getPrmCurrencyExchagenRate() {
        return prmCurrencyExchagenRate;
    }

    public void setPrmCurrencyExchagenRate(BigDecimal prmCurrencyExchagenRate) {
        this.prmCurrencyExchagenRate = prmCurrencyExchagenRate;
    }
    @Column(name = "prm_currencyexchangeratepurchase")
    public BigDecimal getPrmCurrencyExchagenRatePurchase() {
        return prmCurrencyExchagenRatePurchase;
    }

    public void setPrmCurrencyExchagenRatePurchase(BigDecimal prmCurrencyExchagenRatePurchase) {
        this.prmCurrencyExchagenRatePurchase = prmCurrencyExchagenRatePurchase;
    }
}
