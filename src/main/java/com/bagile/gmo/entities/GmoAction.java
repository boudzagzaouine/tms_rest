package com.bagile.gmo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gmo_action")
public class GmoAction extends EmsEntity implements java.io.Serializable {

	private static final long serialVersionUID = -4665243667186730037L;

	@NotNull
    private long gmoActionId;

	@NotNull
	private String gmoActionCode;
	private String gmoActionDescription;
	private GmoMaintenanceLineRef gmoMaintenanceLineRef;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_action_id", allocationSize = 1)
    @Column(name = "gmo_actionid", unique = true, nullable = false, precision = 10, scale = 0)
	public long getGmoActionId() {
		return gmoActionId;
	}
	public void setGmoActionId(long gmoActionId) {
		this.gmoActionId = gmoActionId;
	}
	
    @Column(name = "gmo_actioncode")
	public String getGmoActionCode() {
		return gmoActionCode;
	}
	public void setGmoActionCode(String gmoActionCode) {
		this.gmoActionCode = gmoActionCode;
	}

	@Column(name = "gmo_actiondescription")
	public String getGmoActionDescription() {
		return gmoActionDescription;
	}
	public void setGmoActionDescription(String gmoActionDescription) {
		this.gmoActionDescription = gmoActionDescription;
	}

	@ManyToOne
    public GmoMaintenanceLineRef getGmoMaintenanceLineRef() {
		return gmoMaintenanceLineRef;
	}
	public void setGmoMaintenanceLineRef(GmoMaintenanceLineRef gmoMaintenanceLineRef) {
		this.gmoMaintenanceLineRef = gmoMaintenanceLineRef;
	}
}
