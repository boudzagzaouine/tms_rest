package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name="gmo_notificationstate")
public class GmoNotificationState extends EmsEntity{

    private long gmoNotificationId;
    private String gmoNotificationCode;
    private String gmoNotificationDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_notification_id", allocationSize = 1)
    @Column(name = "gmo_notificationid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoNotificationId() {
        return gmoNotificationId;
    }

    public void setGmoNotificationId(long gmoNotificationId) {
        this.gmoNotificationId = gmoNotificationId;
    }

    @Column(name = "gmo_notificationcode", unique = true, nullable = false, length = 90)
    public String getGmoNotificationCode() {
        return gmoNotificationCode;
    }

    public void setGmoNotificationCode(String gmoNotificationCode) {
        this.gmoNotificationCode = gmoNotificationCode;
    }



    @Column(name = "gmo_notificationdescription")
    public String getGmoNotificationDescription() {
        return gmoNotificationDescription;
    }

    public void setGmoNotificationDescription(String gmoNotificationDescription) {
        this.gmoNotificationDescription = gmoNotificationDescription;
    }
}
