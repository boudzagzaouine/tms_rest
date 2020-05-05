package com.bagile.gmo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gmo_maintenance")
public class GmoMaintenance extends EmsEntity implements Serializable {

	private static final long serialVersionUID = -2692418708409874221L;

	private long gmoMaintenanceId;
	private List<GmoMaintenanceTask> gmoMaintenanceTasks;
	private String description;
	private GmoMaintenanceCategory gmoMaintenanceCategory;
	private GmoMaintenanceType gmaoMaintenanceType;
	private BigDecimal kilometrage;
	private GmoVehicle gmoVehicle;
	private String location;
	private Integer labourCost;
	private PdtProduct productCost;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_maintenance_id", allocationSize = 1)
    @Column(name = "gmo_maintenanceid", unique = true, nullable = false, precision = 10, scale = 0)
	public long getGmoMaintenanceId() {
		return gmoMaintenanceId;
	}
	public void setGmoMaintenanceId(long gmoMaintenanceId) {
		this.gmoMaintenanceId = gmoMaintenanceId;
	}
}
