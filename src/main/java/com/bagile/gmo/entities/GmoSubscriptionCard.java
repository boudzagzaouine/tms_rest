package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "gmo_subscriptioncard")
public class GmoSubscriptionCard extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoSubscriptionCardId;
    private String gmoSubscriptionCardCode;
    private String gmoSubscriptionCardDescription;

    private BigDecimal gmoSubscriptionCardPrice ;


    private GmoSubscriptionCardType gmoSubscriptionCardType;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_subscription_card_id", allocationSize = 1)
    @Column(name = "gmo_subscriptioncardid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoSubscriptionCardId() {
        return gmoSubscriptionCardId;
    }

    public void setGmoSubscriptionCardId(Long gmoSubscriptionCardId) {
        this.gmoSubscriptionCardId = gmoSubscriptionCardId;
    }

    @Column(name = "gmo_subscriptioncardcode", unique = true, nullable = false, length = 90)
    public String getGmoSubscriptionCardCode() {
        return gmoSubscriptionCardCode;
    }

    public void setGmoSubscriptionCardCode(String gmoSubscriptionCardCode) {
        this.gmoSubscriptionCardCode = gmoSubscriptionCardCode;
    }

    @Column(name = "gmo_subscriptioncarddescription")
    public String getGmoSubscriptionCardDescription() {
        return gmoSubscriptionCardDescription;
    }

    public void setGmoSubscriptionCardDescription(String gmoSubscriptionCardDescription) {
        this.gmoSubscriptionCardDescription = gmoSubscriptionCardDescription;
    }

    @Column(name="gmo_subscriptioncardprice")

    public BigDecimal getGmoSubscriptionCardPrice() {
        return gmoSubscriptionCardPrice;
    }

    public void setGmoSubscriptionCardPrice(BigDecimal gmoSubscriptionCardPrice) {
        this.gmoSubscriptionCardPrice = gmoSubscriptionCardPrice;
    }



    @ManyToOne
    @JoinColumn(name="gmo_subscriptioncardtypeid")

    public GmoSubscriptionCardType getGmoSubscriptionCardType() {
        return gmoSubscriptionCardType;
    }

    public void setGmoSubscriptionCardType(GmoSubscriptionCardType gmoSubscriptionCardType) {
        this.gmoSubscriptionCardType = gmoSubscriptionCardType;
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
