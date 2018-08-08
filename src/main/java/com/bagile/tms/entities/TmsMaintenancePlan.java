package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "tms_maintenanceplan", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_maintenanceplanId","tms_maintenancepalncode"}))
public class TmsMaintenancePlan implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_maintenanceplanId")
    private long tmsMaintenancePlanId;
    
    @NotNull
    @JoinColumn(name = "tms_vehicle")
    private TmsVehicle tmsMaintenancePlanVehicle;
    
    @NotNull
    @Column(name = "tms_maintenanceplancode")
    private String tmsMaintenancePlanCode;

    @Column(name = "tms_maintenanceplandescriptif")
    private String tmsMaintenancePlanDescriptif;

    private Date tmsMaintenancePlanDate;
    
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenanceplanstate")
    private TmsMaintenanceState tmsMaintenancePlanState;
    
    @NotNull
    @Column(name = "tms_maintenanceplantitle")
    private String tmsMaintenancePlanTitle;
    
    @NotNull
    @Column(name = "tms_maintenanceplandate")
    private Date tmsMaintenanceCreationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenanceplancreationuser")
    private UsrUser tmsMaintenanceCreationUser;

    @Column(name = "tms_maintenanceplanupdatedate")
    private Date tmsMaintenanceUpDateDate;

    @JoinColumn(name = "tms_maintenancetypemaintenance")
    private TmsTypeMaintenance tmsMaintenanceTypeMaintenance;

    public TmsMaintenancePlan(){

    }
}
