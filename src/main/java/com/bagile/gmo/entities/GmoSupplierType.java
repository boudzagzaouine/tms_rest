package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_suppliertype")
public class GmoSupplierType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;
	private Long gmoSupplierTypeId;
    private String gmoSupplierTypeCode;
    private String gmoSupplierTypeDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_supplier_type_id", allocationSize = 1)
    @Column(name = "gmo_suppliertypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoSupplierTypeId() {
        return gmoSupplierTypeId;
    }

    public void setGmoSupplierTypeId(Long gmoSupplierTypeId) {
        this.gmoSupplierTypeId = gmoSupplierTypeId;
    }

    @Column(name = "gmo_suppliertypecode", unique = true, nullable = false, length = 90)
    public String getGmoSupplierTypeCode() {
        return gmoSupplierTypeCode;
    }

    public void setGmoSupplierTypeCode(String gmoSupplierTypeCode) {
        this.gmoSupplierTypeCode = gmoSupplierTypeCode;
    }

    @Column(name = "gmo_suppliertypedescription")
    public String getGmoSupplierTypeDescription() {
        return gmoSupplierTypeDescription;
    }

    public void setGmoSupplierTypeDescription(String gmoSupplierTypeDescription) {
        this.gmoSupplierTypeDescription = gmoSupplierTypeDescription;
    }



    @ManyToOne
    @JoinColumn(name = "gmo_suppliertypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
