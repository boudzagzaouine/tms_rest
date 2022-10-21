package com.bagile.gmo.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tms_packagedetail")
public class TmsPackageDetail extends EmsEntity{


    private Long tmsPackageDetailId;

    private PrmContainerType prmContainerType;

    private BigDecimal tmsPackageDetailnumberOfPackages;
    private BigDecimal tmsPackageDetailWeight;
    private BigDecimal tmsPackageDetailLength;
    private BigDecimal tmsPackageDetailWidth;
    private BigDecimal tmsPackageDetailHeight;

    private TmsDeliveryInfo tmsDeliveryInfo;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_packagingdetail_id", allocationSize = 1)
    @Column(name = "tms_packagingdetailid", unique = true, nullable = false, precision = 10, scale = 0)

    public Long getTmsPackageDetailId() {
        return tmsPackageDetailId;
    }

    public void setTmsPackageDetailId(Long tmsPackageDetailId) {
        this.tmsPackageDetailId = tmsPackageDetailId;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_packagingdetailcontainertypeid")
    public PrmContainerType getPrmContainerType() {
        return prmContainerType;
    }

    public void setPrmContainerType(PrmContainerType prmContainerType) {
        this.prmContainerType = prmContainerType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_packagingdetaildeliveryinfoid")
    public TmsDeliveryInfo getTmsDeliveryInfo() {
        return tmsDeliveryInfo;
    }

    public void setTmsDeliveryInfo(TmsDeliveryInfo tmsDeliveryInfo) {
        this.tmsDeliveryInfo = tmsDeliveryInfo;
    }



    @Column(name = "tms_packagingdetailnumberofpackage")
    public BigDecimal getTmsPackageDetailnumberOfPackages() {
        return tmsPackageDetailnumberOfPackages;
    }

    public void setTmsPackageDetailnumberOfPackages(BigDecimal tmsPackageDetailnumberOfPackages) {
        this.tmsPackageDetailnumberOfPackages = tmsPackageDetailnumberOfPackages;
    }

    @Column(name = "tms_packagingdetailweight")

    public BigDecimal getTmsPackageDetailWeight() {
        return tmsPackageDetailWeight;
    }

    public void setTmsPackageDetailWeight(BigDecimal tmsPackageDetailWeight) {
        this.tmsPackageDetailWeight = tmsPackageDetailWeight;
    }

    @Column(name = "tms_packagingdetaillenght")

    public BigDecimal getTmsPackageDetailLength() {
        return tmsPackageDetailLength;
    }

    public void setTmsPackageDetailLength(BigDecimal tmsPackageDetailLength) {
        this.tmsPackageDetailLength = tmsPackageDetailLength;
    }

    @Column(name = "tms_packagingdetailwidth")

    public BigDecimal getTmsPackageDetailWidth() {
        return tmsPackageDetailWidth;
    }

    public void setTmsPackageDetailWidth(BigDecimal tmsPackageDetailwidth) {
        this.tmsPackageDetailWidth = tmsPackageDetailwidth;
    }

    @Column(name = "tms_packagingdetailheight")

    public BigDecimal getTmsPackageDetailHeight() {
        return tmsPackageDetailHeight;
    }

    public void setTmsPackageDetailHeight(BigDecimal tmsPackageDetailHeight) {
        this.tmsPackageDetailHeight = tmsPackageDetailHeight;
    }
}
