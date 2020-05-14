package com.bagile.gmo.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gmo_maintenancelineref")
public class GmoMaintenanceLineRef extends EmsEntity {

	private static final long serialVersionUID = -4873869381241068519L;

	private long gmoMaintenanceLineRefId;
	private String gmoMaintenanceLineRefCode;
	private Set<GmoAction> gmoMaintenanceLineRefActions;
	private String gmoMaintenanceLineRefDescription;
	private Set<GmoMaintenanceLine> gmoMaintenanceLines;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq")
    @SequenceGenerator (name = "seq", sequenceName = "seq_gmo_maintenance_line_ref_id", allocationSize = 1)
    @Column(name = "gmo_maintenancelinerefid")
    public long getGmoMaintenanceLineRefId() {
        return gmoMaintenanceLineRefId;
    }

    public void setGmoMaintenanceLineRefId(long gmoMaintenanceLineRefId) {
        this.gmoMaintenanceLineRefId = gmoMaintenanceLineRefId;
    }

    @Column(name = "gmo_maintenancelinerefdescription")
    public String getGmoMaintenanceLineRefDescription() {
        return gmoMaintenanceLineRefDescription;
    }

    public void setGmoMaintenanceLineRefDescription(String gmoMaintenanceLineRefDescription) {
        this.gmoMaintenanceLineRefDescription = gmoMaintenanceLineRefDescription;
    }

 
    @Column(name ="gmo_maintenancelinerefcode")
    public String getGmoMaintenanceLineRefCode() {
        return gmoMaintenanceLineRefCode;
    }

    public void setGmoMaintenanceLineRefCode(String gmoMaintenanceLineRefCode) {
        this.gmoMaintenanceLineRefCode = gmoMaintenanceLineRefCode;
    }

    @OneToMany
    @JoinColumn(name = "gmo_maintenancelinesid")
	public Set<GmoMaintenanceLine> getGmoMaintenanceLines() {
		return gmoMaintenanceLines;
	}

	public void setGmoMaintenanceLines(Set<GmoMaintenanceLine> gmoMaintenanceLines) {
		this.gmoMaintenanceLines = gmoMaintenanceLines;
	}    

	@OneToMany
	public Set<GmoAction> getGmoMaintenanceLineRefActions() {
		return gmoMaintenanceLineRefActions;
	}

	public void setGmoMaintenanceLineRefActions(Set<GmoAction> gmoMaintenanceLineRefActions) {
		this.gmoMaintenanceLineRefActions = gmoMaintenanceLineRefActions;
	}
}
