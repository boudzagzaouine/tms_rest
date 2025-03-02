package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * StkContainer generated by hbm2java
 */
@Entity
@Table(name = "stk_container", uniqueConstraints = {
        @UniqueConstraint(columnNames = "stk_containercode")})
public class StkContainer extends EmsEntity implements java.io.Serializable {

    private Long stkContainerId;
  //  @NotNull
    private LocLocation locLocation;
   // @NotNull
    private OwnOwner ownOwner;
   // @NotNull
    private WrhWarehouse wrhWarehouse;
    @Size(max = 30)
    @NotNull
    private String stkContainerCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkContainerReceptionDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkContainerCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkContainerUpdateDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkContainerOutBoundDate;
    @Size(max = 255)
    private String stkContainerVariable1;
    @Size(max = 255)
    private String stkContainerVariable2;
    @Size(max = 255)
    private String stkContainerVariable3;
    @Size(max = 255)
    private String stkContainerVariable4;
    @Size(max = 255)
    private String stkContainerVariable5;
    @Size(max = 255)
    private String stkContainerVariable6;
    @Size(max = 255)
    private String stkContainerVariable7;
    @Size(max = 255)
    private String stkContainerVariable8;
    @Size(max = 255)
    private String stkContainerVariable9;
    @Size(max = 255)
    private String stkContainerVariable10;
    private Boolean stkContainerActive;
    private Set<CmdSaleOrderStock> cmdSaleOrderStocks = new HashSet<CmdSaleOrderStock>(
            0);
    private Set<StkStock> stkStocks = new HashSet<StkStock>(0);
    private PrmContainerType prmContainerType;

    public StkContainer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_stk_container", allocationSize = 1)
    @Column(name = "stk_containerid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getStkContainerId() {
        return this.stkContainerId;
    }

    public void setStkContainerId(Long stkContainerId) {
        this.stkContainerId = stkContainerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_containerlocationid")
    public LocLocation getLocLocation() {
        return this.locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_containerownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne
    @JoinColumn(name = "stk_containercontainertypeid")
    public PrmContainerType getPrmContainerType() {
        return prmContainerType;
    }

    public void setPrmContainerType(PrmContainerType prmContainerType) {
        this.prmContainerType = prmContainerType;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_containerwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return this.wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "stk_containercode", unique = true, nullable = false, length = 30)
    public String getStkContainerCode() {
        return this.stkContainerCode;
    }

    public void setStkContainerCode(String stkContainerCode) {
        this.stkContainerCode = stkContainerCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_containerreceptiondate")
    public Date getStkContainerReceptionDate() {
        return this.stkContainerReceptionDate;
    }

    public void setStkContainerReceptionDate(Date stkContainerReceptionDate) {
        this.stkContainerReceptionDate = stkContainerReceptionDate;
    }

    @Column(name = "stk_containercreationdate", precision = 10, scale = 0)
    public Date getStkContainerCreationDate() {
        return this.stkContainerCreationDate;
    }

    public void setStkContainerCreationDate(Date stkContainerCreationDate) {
        this.stkContainerCreationDate = stkContainerCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_containerupdatedate")
    public Date getStkContainerUpdateDate() {
        return this.stkContainerUpdateDate;
    }

    public void setStkContainerUpdateDate(Date stkContainerUpdateDate) {
        this.stkContainerUpdateDate = stkContainerUpdateDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_containeroutbounddate")
    public Date getStkContainerOutBoundDate() {
		return stkContainerOutBoundDate;
	}

	public void setStkContainerOutBoundDate(Date stkContainerOutBoundDate) {
		this.stkContainerOutBoundDate = stkContainerOutBoundDate;
	}

	@Column(name = "stk_containervariable1")
    public String getStkContainerVariable1() {
        return this.stkContainerVariable1;
    }

    public void setStkContainerVariable1(String stkContainerVariable1) {
        this.stkContainerVariable1 = stkContainerVariable1;
    }

    @Column(name = "stk_containervariable2")
    public String getStkContainerVariable2() {
        return this.stkContainerVariable2;
    }

    public void setStkContainerVariable2(String stkContainerVariable2) {
        this.stkContainerVariable2 = stkContainerVariable2;
    }

    @Column(name = "stk_containervariable3")
    public String getStkContainerVariable3() {
        return this.stkContainerVariable3;
    }

    public void setStkContainerVariable3(String stkContainerVariable3) {
        this.stkContainerVariable3 = stkContainerVariable3;
    }

    @Column(name = "stk_containervariable4")
    public String getStkContainerVariable4() {
        return this.stkContainerVariable4;
    }

    public void setStkContainerVariable4(String stkContainerVariable4) {
        this.stkContainerVariable4 = stkContainerVariable4;
    }

    @Column(name = "stk_containervariable5")
    public String getStkContainerVariable5() {
        return this.stkContainerVariable5;
    }

    public void setStkContainerVariable5(String stkContainerVariable5) {
        this.stkContainerVariable5 = stkContainerVariable5;
    }

    @Column(name = "stk_containervariable6")
    public String getStkContainerVariable6() {
        return this.stkContainerVariable6;
    }

    public void setStkContainerVariable6(String stkContainerVariable6) {
        this.stkContainerVariable6 = stkContainerVariable6;
    }

    @Column(name = "stk_containervariable7")
    public String getStkContainerVariable7() {
        return this.stkContainerVariable7;
    }

    public void setStkContainerVariable7(String stkContainerVariable7) {
        this.stkContainerVariable7 = stkContainerVariable7;
    }

    @Column(name = "stk_containervariable8")
    public String getStkContainerVariable8() {
        return this.stkContainerVariable8;
    }

    public void setStkContainerVariable8(String stkContainerVariable8) {
        this.stkContainerVariable8 = stkContainerVariable8;
    }

    @Column(name = "stk_containervariable9")
    public String getStkContainerVariable9() {
        return this.stkContainerVariable9;
    }

    public void setStkContainerVariable9(String stkContainerVariable9) {
        this.stkContainerVariable9 = stkContainerVariable9;
    }

    @Column(name = "stk_containervariable10")
    public String getStkContainerVariable10() {
        return this.stkContainerVariable10;
    }

    public void setStkContainerVariable10(String stkContainerVariable10) {
        this.stkContainerVariable10 = stkContainerVariable10;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public Set<CmdSaleOrderStock> getCmdSaleOrderStocks() {
        return this.cmdSaleOrderStocks;
    }

    public void setCmdSaleOrderStocks(Set<CmdSaleOrderStock> cmdSaleOrderStocks) {
        this.cmdSaleOrderStocks = cmdSaleOrderStocks;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public Set<StkStock> getStkStocks() {
        return this.stkStocks;
    }

    public void setStkStocks(Set<StkStock> stkStocks) {
        this.stkStocks = stkStocks;
    }

     @Column(name = "stk_containeractive")
    public Boolean getStkContainerActive() {
        return stkContainerActive;
    }

    public void setStkContainerActive(Boolean stkContainerActive) {
        this.stkContainerActive = stkContainerActive;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            StkContainer obj = (StkContainer) object;
            if (this.getStkContainerId() == obj.getStkContainerId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stkContainerId);
    }

}
