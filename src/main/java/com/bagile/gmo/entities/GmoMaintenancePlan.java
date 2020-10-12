package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gmo_maintenanceplan")
public class GmoMaintenancePlan extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1640304759359470684L;

    private Long gmoMaintenancePlanId;

    private String gmoMaintenancePlanCode;
    private String gmoMaintenancePlanDescription;
    private Set<GmoActionPlan> gmoActionPlans = new HashSet<>();

    public GmoMaintenancePlan() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_maintenanceplan__id", allocationSize = 1)
    @Column(name = "gmo_maintenanceplanid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoMaintenancePlanId() {
        return gmoMaintenancePlanId;
    }

    public void setGmoMaintenancePlanId(Long gmoMaintenancePlanId) {
        this.gmoMaintenancePlanId = gmoMaintenancePlanId;
    }


    @Column(name = "gmo_maintenanceplancode", nullable = false, length = 90)
    public String getGmoMaintenancePlanCode() {
        return gmoMaintenancePlanCode;
    }

    public void setGmoMaintenancePlanCode(String gmoMaintenancePlanCode) {
        this.gmoMaintenancePlanCode = gmoMaintenancePlanCode;
    }

    @Column(name = "gmo_maintenanceplandescription")
    public String getGmoMaintenancePlanDescription() {
        return gmoMaintenancePlanDescription;
    }

    public void setGmoMaintenancePlanDescription(String gmoMaintenancePlanDescription) {
        this.gmoMaintenancePlanDescription = gmoMaintenancePlanDescription;
    }




    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL,CascadeType.MERGE}, mappedBy = "gmoMaintenancePlan", orphanRemoval=true)
    public Set<GmoActionPlan> getGmoActionPlans() {
        return gmoActionPlans;
    }

    public void setGmoActionPlans(Set<GmoActionPlan> gmoActionPlans) {
        this.gmoActionPlans = gmoActionPlans;
    }
}
