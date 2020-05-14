package com.bagile.gmo.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gmo_maintenanceproduct")
public class GmoMaintenanceProduct extends EmsEntity {

	private static final long serialVersionUID = -1994449451482503160L;

	private Long gmoMaintenanceProductId;
	private PdtProduct gmoMaintenanceProductProduct;
	private BigDecimal gmoMaintenanceProductQuantity;
	private BigDecimal gmoMaintenanceProductUnitPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq")
    @SequenceGenerator (name = "seq", sequenceName = "seq_gmo_maintenance_product_id", allocationSize = 1)
    @Column(name = "gmo_maintenanceproductid")
	public Long getGmoMaintenanceProductId() {
		return gmoMaintenanceProductId;
	}

	public void setGmoMaintenanceProductId(Long gmoMaintenanceProductId) {
		this.gmoMaintenanceProductId = gmoMaintenanceProductId;
	}

	@Column
	public PdtProduct getGmoMaintenanceProductProduct() {
		return gmoMaintenanceProductProduct;
	}

	public void setGmoMaintenanceProductProduct(PdtProduct gmoMaintenanceProductProduct) {
		this.gmoMaintenanceProductProduct = gmoMaintenanceProductProduct;
	}

	@Column
	public BigDecimal getGmoMaintenanceProductQuantity() {
		return gmoMaintenanceProductQuantity;
	}

	public void setGmoMaintenanceProductQuantity(BigDecimal gmoMaintenanceProductQuantity) {
		this.gmoMaintenanceProductQuantity = gmoMaintenanceProductQuantity;
	}

	@Column
	public BigDecimal getGmoMaintenanceProductUnitPrice() {
		return gmoMaintenanceProductUnitPrice;
	}

	public void setGmoMaintenanceProductUnitPrice(BigDecimal gmoMaintenanceProductUnitPrice) {
		this.gmoMaintenanceProductUnitPrice = gmoMaintenanceProductUnitPrice;
	}
}
