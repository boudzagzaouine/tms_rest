package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gmo_programtype")
public class GmoProgramType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private long gmoProgramTypeId;
    private String gmoProgramTypeCode;
    private String gmoProgramTypeDescription;
    private GmoMaintenanceType gmoMaintenanceType ;
   private  Set<GmoOperationType> gmoOperationTypes = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_programe_type_id", allocationSize = 1)
    @Column(name = "gmo_programtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoProgramTypeId() {
        return gmoProgramTypeId;
    }

    public void setGmoProgramTypeId(long gmoProgramTypeId) {
        this.gmoProgramTypeId = gmoProgramTypeId;
    }

    @Column(name = "gmo_programtypecode", unique = true, nullable = false, length = 90)
    public String getGmoProgramTypeCode() {
        return gmoProgramTypeCode;
    }

    public void setGmoProgramTypeCode(String gmoProgramTypeCode) {
        this.gmoProgramTypeCode = gmoProgramTypeCode;
    }

    @Column(name = "gmo_programtypedescription")
    public String getGmoProgramTypeDescription() {
        return gmoProgramTypeDescription;
    }

    public void setGmoProgramTypeDescription(String gmoProgramTypeDescription) {
        this.gmoProgramTypeDescription = gmoProgramTypeDescription;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_maintenancetypeid")
    public GmoMaintenanceType getGmoMaintenanceType() {
        return gmoMaintenanceType;
    }

    public void setGmoMaintenanceType(GmoMaintenanceType gmoMaintenanceType) {
        this.gmoMaintenanceType = gmoMaintenanceType;
    }
    @OneToMany(mappedBy = "gmoProgramType", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<GmoOperationType> getGmoOperationTypes() {
        return gmoOperationTypes;
    }

    public void setGmoOperationTypes(Set<GmoOperationType> gmoOperationTypes) {
        this.gmoOperationTypes = gmoOperationTypes;
    }
}
