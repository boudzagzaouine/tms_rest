package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name="gmo_notificationtypetype")
public class GmoNotificationType extends EmsEntity{

    private long gmoNotificationId;
    private String gmoNotificationCode;
    private String gmoNotificationEmail;

   // @NotNull
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_notificationtype_id", allocationSize = 1)
    @Column(name = "gmo_notificationtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoNotificationId() {
        return gmoNotificationId;
    }

    public void setGmoNotificationId(long gmoNotificationId) {
        this.gmoNotificationId = gmoNotificationId;
    }

    @Column(name = "gmo_notificationtypecode", unique = true, nullable = false, length = 90)
    public String getGmoNotificationCode() {
        return gmoNotificationCode;
    }

    public void setGmoNotificationCode(String gmoNotificationCode) {
        this.gmoNotificationCode = gmoNotificationCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_notificationtypeownerid")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }



    @Column(name = "gmo_notificationtypeemail")
    public String getGmoNotificationEmail() {
        return gmoNotificationEmail;
    }

    public void setGmoNotificationEmail(String gmoNotificationEmail) {
        this.gmoNotificationEmail = gmoNotificationEmail;
    }
}
