package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "gmo_subscriptioncardtype")
public class GmoSubscriptionCardType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoSubscriptionCardTypeId;
    private String gmoSubscriptionCardTypeCode;
    private String gmoSubscriptionCardTypeDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_subscription_card_type_id", allocationSize = 1)
    @Column(name = "gmo_subscriptioncardtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoSubscriptionCardTypeId() {
        return gmoSubscriptionCardTypeId;
    }

    public void setGmoSubscriptionCardTypeId(Long gmoSubscriptionCardTypeId) {
        this.gmoSubscriptionCardTypeId = gmoSubscriptionCardTypeId;
    }

    @Column(name = "gmo_subscriptioncardtypecode", unique = true, nullable = false, length = 90)
    public String getGmoSubscriptionCardTypeCode() {
        return gmoSubscriptionCardTypeCode;
    }

    public void setGmoSubscriptionCardTypeCode(String gmoSubscriptionCardTypeCode) {
        this.gmoSubscriptionCardTypeCode = gmoSubscriptionCardTypeCode;
    }

    @Column(name = "gmo_subscriptioncardtypedescription")
    public String getGmoSubscriptionCardTypeDescription() {
        return gmoSubscriptionCardTypeDescription;
    }

    public void setGmoSubscriptionCardTypeDescription(String gmoSubscriptionCardTypeDescription) {
        this.gmoSubscriptionCardTypeDescription = gmoSubscriptionCardTypeDescription;
    }




    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
