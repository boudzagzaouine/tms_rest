package com.bagile.gmo.entities;


import javax.persistence.*;

/**
 * Created by ASMAE on 28/04/2016.
 */

@Entity
@Table(name = "prm_setting")
public class PrmSetting extends EmsEntity {
    private Long prmSettingId;
    private String prmSettingCode;
    private String prmSettingValue;
    private OrgOrganisation orgOrganisation;
    private Boolean prmSettingGestCo;
    private Boolean prmSettingCrm;
    private Boolean prmSettingPos;
    private String prmSettingDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_tmsvoieexpress.prm_setting_prm_setting_id_seq", allocationSize = 1)
    @Column(name = "prm_setting_id", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmSettingId() {
        return prmSettingId;
    }

    public void setPrmSettingId(Long prmSettingId) {
        this.prmSettingId = prmSettingId;
    }

    @Column(name = "prm_settingcode")
    public String getPrmSettingCode() {
        return prmSettingCode;
    }

    public void setPrmSettingCode(String prmSettingCode) {
        this.prmSettingCode = prmSettingCode;
    }

    @Column(name = "prm_settingvalue")
    public String getPrmSettingValue() {
        return prmSettingValue;
    }

    public void setPrmSettingValue(String prmSettingValue) {
        this.prmSettingValue = prmSettingValue;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_settingorganisationid")
    public OrgOrganisation getOrgOrganisation() {
        return orgOrganisation;
    }

    public void setOrgOrganisation(OrgOrganisation orgOrganisation) {
        this.orgOrganisation = orgOrganisation;
    }

    @Column(name = "prm_settinggestco")
    public Boolean getPrmSettingGestCo() {
        return prmSettingGestCo;
    }

    public void setPrmSettingGestCo(Boolean prmSettingGestCo) {
        this.prmSettingGestCo = prmSettingGestCo;
    }

    @Column(name = "prm_settingcrm")
    public Boolean getPrmSettingCrm() {
        return prmSettingCrm;
    }

    public void setPrmSettingCrm(Boolean prmSettingCrm) {
        this.prmSettingCrm = prmSettingCrm;
    }

    @Column(name = "prm_settingpos")
    public Boolean getPrmSettingPos() {
        return prmSettingPos;
    }

    public void setPrmSettingPos(Boolean prmSettingPos) {
        this.prmSettingPos = prmSettingPos;
    }

    @Column(name = "prm_settingdescription")
    public String getPrmSettingDescription() {
        return prmSettingDescription;
    }

    public void setPrmSettingDescription(String prmSettingDescription) {
        this.prmSettingDescription = prmSettingDescription;
    }
}
