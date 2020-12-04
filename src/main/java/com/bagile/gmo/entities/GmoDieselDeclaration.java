package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="gmo_dieseldeclaration")
public class GmoDieselDeclaration extends EmsEntity{

    private long gmoDieselDeclarationId;
    private String gmoDieselDeclarationCode;
    private GmoVehicle gmoVehicle;
    private BigDecimal gmoDieselDeclarationAmount;
    private BigDecimal gmoDieselDeclarationMileage;
    private Date gmoDieselDeclarationDate;
 private OwnOwner ownOwner;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_diesel_declaration_id", allocationSize = 1)
    @Column(name = "gmo_dieseldeclarationid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoDieselDeclarationId() {
        return gmoDieselDeclarationId;
    }

    public void setGmoDieselDeclarationId(long gmoBadgeId) {
        this.gmoDieselDeclarationId = gmoBadgeId;
    }


    @Column(name = "gmo_dieseldeclarationcode")
    public String getGmoDieselDeclarationCode() {
        return gmoDieselDeclarationCode;
    }

    public void setGmoDieselDeclarationCode(String gmoDieselDeclarationCode) {
        this.gmoDieselDeclarationCode = gmoDieselDeclarationCode;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_vehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }



    @Column(name = "gmo_dieseldeclarationamount")
    public BigDecimal getGmoDieselDeclarationAmount() {
        return gmoDieselDeclarationAmount;
    }

    public void setGmoDieselDeclarationAmount(BigDecimal gmoDieselDeclarationAmount) {
        this.gmoDieselDeclarationAmount = gmoDieselDeclarationAmount;
    }

    @Column(name = "gmo_dieseldeclarationmileage")
    public BigDecimal getGmoDieselDeclarationMileage() {
        return gmoDieselDeclarationMileage;
    }

    public void setGmoDieselDeclarationMileage(BigDecimal gmoDieselDeclarationMileage) {
        this.gmoDieselDeclarationMileage = gmoDieselDeclarationMileage;
    }

    @Column(name = "gmo_dieseldeclarationdate")
    public Date getGmoDieselDeclarationDate() {
        return gmoDieselDeclarationDate;
    }

    public void setGmoDieselDeclarationDate(Date gmoDieselDeclarationDate) {
        this.gmoDieselDeclarationDate = gmoDieselDeclarationDate;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
