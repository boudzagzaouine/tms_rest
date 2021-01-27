package com.bagile.gmo.entities;

import javax.persistence.*;

/**
 * Created by Enissay on 03/05/2016.
 */
@Entity(name="prm_locationstatus")
public class PrmLocationStatus extends EmsEntity {
    private Long prmLocationStatusId;
    private String prmLocationStatusCode;
    private String prmLocationStatusDescription;
    private OrgOrganisation orgOrganisation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_locationstatut", allocationSize = 1)
    @Column(name = "prm_locationstatusid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmLocationStatusId() {
        return prmLocationStatusId;
    }
    public void setPrmLocationStatusId(Long prmLocationStatusId) {
        this.prmLocationStatusId = prmLocationStatusId;
    }
    @Column(name="prm_locationstatuscode",length = 50)

    public String getPrmLocationStatusCode() {
        return prmLocationStatusCode;
    }

    public void setPrmLocationStatusCode(String prmLocationStatusCode) {
        this.prmLocationStatusCode = prmLocationStatusCode;
    }
    @Column(name="prm_locationstatusdescription",length = 255)

    public String getPrmLocationStatusDescription() {
        return prmLocationStatusDescription;
    }

    public void setPrmLocationStatusDescription(String prmLocationStatusDescription) {
        this.prmLocationStatusDescription = prmLocationStatusDescription;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_locationstatusorganisationid")
    public OrgOrganisation getOrgOrganisation() {
        return orgOrganisation;
    }

    public void setOrgOrganisation(OrgOrganisation orgOrganisation) {
        this.orgOrganisation = orgOrganisation;
    }
}
