package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 02/12/2016.
 */
@Entity
@Table(name = "prm_containertype")
public class PrmContainerType extends EmsEntity {
    private long prmContainerTypeId;
    private String prmContainerTypeCode;
    private String prmContainerTypeDescription;
    private Date prmContainerTypeCreationDate;
    private Date prmContainerTypeUpdateDate;
    private BigDecimal prmContainerTypeWidth;
    private BigDecimal prmContainerTypeHeight;
    private BigDecimal prmContainerTypeLength;
    private BigDecimal prmContainerTypeMaxWeight;
    private BigDecimal prmContainerTypeWeight;
    private Boolean prmContainerTypeActive;
    private Boolean prmContainerTypeDefaultForReception = false;
    private Boolean prmContainerTypeDefaultForPreparation = false;
    private Boolean prmContainerTypePalette;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "prm_containertype_prm_containertypeid_seq", allocationSize = 1)
    @Column(name = "prm_containertypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmContainerTypeId() {
        return prmContainerTypeId;
    }

    public void setPrmContainerTypeId(long prmContainerTypeId) {
        this.prmContainerTypeId = prmContainerTypeId;
    }

    @Column(name = "prm_containertypecode")
    public String getPrmContainerTypeCode() {
        return prmContainerTypeCode;
    }

    public void setPrmContainerTypeCode(String prmContainerTypeCode) {
        this.prmContainerTypeCode = prmContainerTypeCode;
    }

    @Column(name = "prm_containertypedescription")

    public String getPrmContainerTypeDescription() {
        return prmContainerTypeDescription;
    }

    public void setPrmContainerTypeDescription(String prmContainerTypeDescription) {
        this.prmContainerTypeDescription = prmContainerTypeDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_containertypecreationdate")
    public Date getPrmContainerTypeCreationDate() {
        return prmContainerTypeCreationDate;
    }

    public void setPrmContainerTypeCreationDate(Date prmContainerTypeCreationDate) {
        this.prmContainerTypeCreationDate = prmContainerTypeCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_containertypeupdatedate")
    public Date getPrmContainerTypeUpdateDate() {
        return prmContainerTypeUpdateDate;
    }

    public void setPrmContainerTypeUpdateDate(Date prmContainerTypeUpdateDate) {
        this.prmContainerTypeUpdateDate = prmContainerTypeUpdateDate;
    }

    @Column(name = "prm_containertypeactive")
    public Boolean getPrmContainerTypeActive() {
        return prmContainerTypeActive;
    }

    public void setPrmContainerTypeActive(Boolean prmContainerTypeActive) {
        this.prmContainerTypeActive = prmContainerTypeActive;
    }

    @Column(name = "prm_containertypewidth")

    public BigDecimal getPrmContainerTypeWidth() {
        return prmContainerTypeWidth;
    }

    public void setPrmContainerTypeWidth(BigDecimal prmContainerTypeWidth) {
        this.prmContainerTypeWidth = prmContainerTypeWidth;
    }

    @Column(name = "prm_containertypeheight")
    public BigDecimal getPrmContainerTypeHeight() {
        return prmContainerTypeHeight;
    }

    public void setPrmContainerTypeHeight(BigDecimal prmContainerTypeHeight) {
        this.prmContainerTypeHeight = prmContainerTypeHeight;
    }

    @Column(name = "prm_containertypelength")
    public BigDecimal getPrmContainerTypeLength() {
        return prmContainerTypeLength;
    }

    public void setPrmContainerTypeLength(BigDecimal prmContainerTypeLength) {
        this.prmContainerTypeLength = prmContainerTypeLength;
    }

    @Column(name = "prm_containertypemaxweight")
    public BigDecimal getPrmContainerTypeMaxWeight() {
        return prmContainerTypeMaxWeight;
    }

    public void setPrmContainerTypeMaxWeight(BigDecimal prmContainerTypeMaxWeight) {
        this.prmContainerTypeMaxWeight = prmContainerTypeMaxWeight;
    }

    @Column(name = "prm_containertypeweight")
    public BigDecimal getPrmContainerTypeWeight() {
        return prmContainerTypeWeight;
    }

    public void setPrmContainerTypeWeight(BigDecimal prmContainerTypeWeight) {
        this.prmContainerTypeWeight = prmContainerTypeWeight;
    }

    @Column(name = "prm_containertypedefaultforreception")
    public Boolean getPrmContainerTypeDefaultForReception() {
        return prmContainerTypeDefaultForReception;
    }

    public void setPrmContainerTypeDefaultForReception(Boolean prmContainerTypeDefaultForReception) {
        this.prmContainerTypeDefaultForReception = prmContainerTypeDefaultForReception;
    }

    @Column(name = "prm_containertypedefaultforpreparation")
    public Boolean getPrmContainerTypeDefaultForPreparation() {
        return prmContainerTypeDefaultForPreparation;
    }

    public void setPrmContainerTypeDefaultForPreparation(Boolean prmContainerTypeDefaultForPreparation) {
        this.prmContainerTypeDefaultForPreparation = prmContainerTypeDefaultForPreparation;
    }

    @Column(name = "prm_containertypepalette")
    public Boolean getPrmContainerTypePalette() {
        return prmContainerTypePalette;
    }

    public void setPrmContainerTypePalette(Boolean prmContainerTypePalette) {
        this.prmContainerTypePalette = prmContainerTypePalette;
    }
}
