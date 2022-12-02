package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "tms_paymentrule")
public class TmsPaymentRule extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsPaymentRuleId;
    private PrmPaymentType prmPaymentType;
    private Boolean tmsPaymentRulcontreBL;
    private Boolean tmsPaymentRuleContreFacture;
    private byte[] tmsPaymentRuleFile;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_paymentrule_id", allocationSize = 1)
    @Column(name = "tms_paymentruleid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsPaymentRuleId() {
        return tmsPaymentRuleId;
    }

    public void setTmsPaymentRuleId(Long tmsPaymentRuleId) {
        this.tmsPaymentRuleId = tmsPaymentRuleId;
    }

    @ManyToOne
    @JoinColumn(name = "tms_paymenttype")
    public PrmPaymentType getPrmPaymentType() {
        return prmPaymentType;
    }

    public void setPrmPaymentType(PrmPaymentType prmPaymentType) {
        this.prmPaymentType = prmPaymentType;
    }

    @Column(name = "tms_paymentrulecontrebl")
    public Boolean getTmsPaymentRulcontreBL() {
        return tmsPaymentRulcontreBL;
    }

    public void setTmsPaymentRulcontreBL(Boolean tmsPaymentRulcontreBL) {
        this.tmsPaymentRulcontreBL = tmsPaymentRulcontreBL;
    }

    @Column(name = "tms_paymentrulecontrefacture")
    public Boolean getTmsPaymentRuleContreFacture() {
        return tmsPaymentRuleContreFacture;
    }

    public void setTmsPaymentRuleContreFacture(Boolean tmsPaymentRuleContreFacture) {
        this.tmsPaymentRuleContreFacture = tmsPaymentRuleContreFacture;
    }

    @Column(name = "tms_paymentrulefile")

    public byte[] getTmsPaymentRuleFile() {
        return tmsPaymentRuleFile;
    }

    public void setTmsPaymentRuleFile(byte[] tmsPaymentRuleFile) {
        this.tmsPaymentRuleFile = tmsPaymentRuleFile;
    }

    @ManyToOne
    @JoinColumn(name = "tms_notificationtypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

   
}
