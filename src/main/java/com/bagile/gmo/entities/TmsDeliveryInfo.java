
package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_deliveryinfo")
public class TmsDeliveryInfo extends EmsEntity {

    private Long tmsDeliveryInfoId;


    private TmsPackagingType tmsDeliveryInfoPackagingType ;



    private Set<TmsPackageDetail> tmsPackageDetails=new HashSet<>();
    private TmsAddressContactDeliveryInfo addressContactDeliveryInfoSource;
    private TmsAddressContactDeliveryInfo addressContactDeliveryInfoDistination;


 


    private BigDecimal tmsDeliveryInfoWeightTotal ;
    private BigDecimal tmsDeliveryInfoCapacityTotal ;

    private BigDecimal tmsDeliveryInfoPriceTTC;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_deliveryinfo_id", allocationSize = 1)
    @Column(name = "tms_deliveryinfoid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsDeliveryInfoId() {
        return tmsDeliveryInfoId;
    }

    public void setTmsDeliveryInfoId(Long tmsDeliveryInfoId) {
        this.tmsDeliveryInfoId = tmsDeliveryInfoId;
    }

   

    

   

   
    @ManyToOne()
    @JoinColumn(name = "tms_packagingtypeid")
    public TmsPackagingType getTmsDeliveryInfoPackagingType() {
        return tmsDeliveryInfoPackagingType;
    }

    public void setTmsDeliveryInfoPackagingType(TmsPackagingType tmsDeliveryInfoPackagingTypeAller) {
        this.tmsDeliveryInfoPackagingType = tmsDeliveryInfoPackagingTypeAller;
    }

 

    
    @OneToMany(mappedBy = "tmsDeliveryInfo",cascade = CascadeType.MERGE)
    public Set<TmsPackageDetail> getTmsPackageDetails() {
        return tmsPackageDetails;
    }

    public void setTmsPackageDetails(Set<TmsPackageDetail> tmsPackageDetails) {
        this.tmsPackageDetails = tmsPackageDetails;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoName", column = @Column(name = "tms_addresscontactdeliveryinfosourcename")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoTel1", column = @Column(name = "tms_addresscontactdeliveryinfosourcetel1")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoEmail", column = @Column(name = "tms_addresscontactdeliveryinfosourceemail")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoCompany", column = @Column(name = "tms_addresscontactdeliveryinfosourcecompany")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoLine1", column = @Column(name = "tms_addresscontactdeliveryinfosourceline")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoCity", column = @Column(name = "tms_addresscontactdeliveryinfosourcecity")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoZip", column = @Column(name = "tms_addresscontactdeliveryinfosourcezipcountry")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoCountry", column = @Column(name = "tms_addresscontactdeliveryinfosourcedate")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoDate", column = @Column(name = "tms_addresscontactdeliveryinfosource")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoLatitude", column = @Column(name = "tms_addresscontactdeliveryinfosourcelatitude")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoLongitude", column = @Column(name = "tms_addresscontactdeliveryinfosourcelongitude")),
    })
    public TmsAddressContactDeliveryInfo getAddressContactDeliveryInfoSource() {
        return addressContactDeliveryInfoSource;
    }

    public void setAddressContactDeliveryInfoSource(TmsAddressContactDeliveryInfo addressContactDeliveryInfoSource) {
        this.addressContactDeliveryInfoSource = addressContactDeliveryInfoSource;
    }


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoName", column = @Column(name = "tms_addresscontactdeliveryinfodistinationname")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoTel1", column = @Column(name = "tms_addresscontactdeliveryinfodistinationtel1")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoEmail", column = @Column(name = "tms_addresscontactdeliveryinfodistinationemail")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoCompany", column = @Column(name = "tms_addresscontactdeliveryinfodistinationcompany")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoLine1", column = @Column(name = "tms_addresscontactdeliveryinfodistinationline")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoCity", column = @Column(name = "tms_addresscontactdeliveryinfodistinationcity")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoZip", column = @Column(name = "tms_addresscontactdeliveryinfodistinationzipcountry")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoCountry", column = @Column(name = "tms_addresscontactdeliveryinfodistinationdate")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoDate", column = @Column(name = "tms_addresscontactdeliveryinfodistination")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoLatitude", column = @Column(name = "tms_addresscontactdeliveryinfodistinationlatitude")),
            @AttributeOverride(name = "tmsAddressContactDeliveryInfoLongitude", column = @Column(name = "tms_addresscontactdeliveryinfodistinationlongitude")),
    })
    public TmsAddressContactDeliveryInfo getAddressContactDeliveryInfoDistination() {
        return addressContactDeliveryInfoDistination;
    }

    public void setAddressContactDeliveryInfoDistination(TmsAddressContactDeliveryInfo getAddressContactDeliveryInfoDistiantion) {
        this.addressContactDeliveryInfoDistination = getAddressContactDeliveryInfoDistiantion;
    }




    @Column(name="tms_deliveryinfoweighttotal")
    public BigDecimal getTmsDeliveryInfoWeightTotal() {
        return tmsDeliveryInfoWeightTotal;
    }

    public void setTmsDeliveryInfoWeightTotal(BigDecimal tmsDeliveryInfoWeightTotal) {
        this.tmsDeliveryInfoWeightTotal = tmsDeliveryInfoWeightTotal;
    }
    @Column(name="tms_deliveryinfocapacitytoal")

    public BigDecimal getTmsDeliveryInfoCapacityTotal() {
        return tmsDeliveryInfoCapacityTotal;
    }

    public void setTmsDeliveryInfoCapacityTotal(BigDecimal tmsDeliveryInfoCapacityToal) {
        this.tmsDeliveryInfoCapacityTotal = tmsDeliveryInfoCapacityToal;
    }

    @Column(name="tms_deliveryinfopricettc")

    public BigDecimal getTmsDeliveryInfoPriceTTC() {
        return tmsDeliveryInfoPriceTTC;
    }

    public void setTmsDeliveryInfoPriceTTC(BigDecimal tmsDeliveryInfoPriceTTC) {
        this.tmsDeliveryInfoPriceTTC = tmsDeliveryInfoPriceTTC;
    }

}
