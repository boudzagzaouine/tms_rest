package com.bagile.gmo.entities;

import com.bagile.gmo.dto.Driver;
import com.bagile.gmo.dto.SinisterType;
import com.bagile.gmo.dto.Supplier;
import com.bagile.gmo.dto.Vehicle;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "gmo_sinister")
public class GmoSinister extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoSinisterId;
    private String gmoSinisterCode;
    private String gmoSinisterDescription;

    private GmoVehicle gmoVehicle;
    private GmoDriver gmoDriver;
    private GmoSinisterType gmoSinisterType;
    private Date gmoSinisterDate;
    private String  gmoSinisterVenue ;
    private RcpSupplier rcpSupplier;

    private BigDecimal gmoSinisterRepayment;
    
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_sinister_id", allocationSize = 1)
    @Column(name = "gmo_sinisterid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoSinisterId() {
        return gmoSinisterId;
    }

    public void setGmoSinisterId(Long gmoSinisterId) {
        this.gmoSinisterId = gmoSinisterId;
    }

    @Column(name = "gmo_sinistercode", unique = true, nullable = false, length = 90)
    public String getGmoSinisterCode() {
        return gmoSinisterCode;
    }

    public void setGmoSinisterCode(String gmoSinisterCode) {
        this.gmoSinisterCode = gmoSinisterCode;
    }

    @Column(name = "gmo_sinisterdescription")
    public String getGmoSinisterDescription() {
        return gmoSinisterDescription;
    }

    public void setGmoSinisterDescription(String gmoSinisterDescription) {
        this.gmoSinisterDescription = gmoSinisterDescription;
    }

  @ManyToOne()
  @JoinColumn(name = "gmo_sinistervehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }
@ManyToOne()
@JoinColumn(name = "gmo_sinsterdriverid")
    public GmoDriver getGmoDriver() {
        return gmoDriver;
    }

    public void setGmoDriver(GmoDriver gmoDriver) {
        this.gmoDriver = gmoDriver;
    }
@ManyToOne()
 @JoinColumn(name = "gmo_sinstersinistertypeid")
    public GmoSinisterType getGmoSinisterType() {
        return gmoSinisterType;
    }

    public void setGmoSinisterType(GmoSinisterType gmoSinisterType) {
        this.gmoSinisterType = gmoSinisterType;
    }

    @Column(name = "gmo_sinsterdate")
    public Date getGmoSinisterDate() {
        return gmoSinisterDate;
    }

    public void setGmoSinisterDate(Date gmoSinisterDate) {
        this.gmoSinisterDate = gmoSinisterDate;
    }
@Column(name = "gmo_sinstervenue")
    public String getGmoSinisterVenue() {
        return gmoSinisterVenue;
    }

    public void setGmoSinisterVenue(String gmoSinisterVenue) {
        this.gmoSinisterVenue = gmoSinisterVenue;
    }

    @ManyToOne()
    @JoinColumn(name = "gmo_sinstersupplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }



@Column(name = "gmo_sinisterrepayment")
    public BigDecimal getGmoSinisterRepayment() {
        return gmoSinisterRepayment;
    }

    public void setGmoSinisterRepayment(BigDecimal gmoSinisterRepayment) {
        this.gmoSinisterRepayment = gmoSinisterRepayment;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_notificationownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    
}
