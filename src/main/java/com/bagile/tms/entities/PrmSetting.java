package com.bagile.tms.entities;


import javax.persistence.*;

/**
 * Created by ASMAE on 28/04/2016.
 */

@Entity
@Table(name = "prm_setting")
public class PrmSetting {
    private long prmSettingId;
    private String prmSettingCode;
    private String prmSettingValue;
    private OrgOrganisation orgOrganisation;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_ems.prm_setting_prm_setting_id_seq", allocationSize = 1)
    @Column(name = "prm_setting_id", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmSettingId() {
        return prmSettingId;
    }

    public void setPrmSettingId(long prmSettingId) {
        this.prmSettingId = prmSettingId;
    }
    @Column(name="prm_settingcode")
    public String getPrmSettingCode() {
        return prmSettingCode;
    }
    public void setPrmSettingCode(String prmSettingCode) {
        this.prmSettingCode = prmSettingCode;
    }
    @Column(name="prm_settingvalue")
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
}
