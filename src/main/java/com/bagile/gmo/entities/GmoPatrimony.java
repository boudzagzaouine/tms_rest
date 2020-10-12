package com.bagile.gmo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "gmo_patrimony")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class GmoPatrimony extends EmsEntity {


    private Long gmoPatrimonyId;
    private GmoMaintenancePlan gmoMaintenancePlan;
    private String gmoPatrimonyCode;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_patrimony_id", allocationSize = 1)
    @Column(name = "gmo_patrimonyid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoPatrimonyId() {
        return gmoPatrimonyId;
    }

    public void setGmoPatrimonyId(Long gmoPatrimonyId) {
        this.gmoPatrimonyId = gmoPatrimonyId;
    }

    @Column(name = "gmo_patrimonycode", unique = true, nullable = false, length = 90)
    public String getGmoPatrimonyCode() {
        return gmoPatrimonyCode;
    }

    public void setGmoPatrimonyCode(String gmoMachineCode) {
        this.gmoPatrimonyCode = gmoMachineCode;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_maintenanceplan")
    public GmoMaintenancePlan getGmoMaintenancePlan() {
        return gmoMaintenancePlan;
    }

    public void setGmoMaintenancePlan(GmoMaintenancePlan gmoMaintenancePlan) {
        this.gmoMaintenancePlan = gmoMaintenancePlan;
    }
}
