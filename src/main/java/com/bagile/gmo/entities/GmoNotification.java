package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name="gmo_notification")
public class GmoNotification extends EmsEntity{


    private long gmoNotificationId;
    private String gmoNotificationCode;
    private String gmoNotificationType;
    private GmoNotificationState gmoNotificationState ;
    private long gmoNotificationProductId;
    private long gmoNotificationMaintenanceId;
    private String gmoNotificationPatrimonyCode ;
    private  String gmoNotificationTypePatrimony;
    private String gmoNotificationAction;

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

    @Column(name = "gmo_notificationcode", length = 90)
    public String getGmoNotificationCode() {
        return gmoNotificationCode;
    }

    public void setGmoNotificationCode(String gmoNotificationCode) {
        this.gmoNotificationCode = gmoNotificationCode;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_notificationnotstateid")
    public GmoNotificationState getGmoNotificationState() {
        return gmoNotificationState;
    }

    public void setGmoNotificationState(GmoNotificationState gmoNotificationState) {
        this.gmoNotificationState = gmoNotificationState;
    }

    @Column(name = "gmo_Notificationtype")
    public String getGmoNotificationType() {
        return gmoNotificationType;
    }

    public void setGmoNotificationType(String gmoNotificationDescription) {
        this.gmoNotificationType = gmoNotificationDescription;
    }

    @Column(name = "gmo_productid")
    public long getGmoNotificationProductId() {
        return gmoNotificationProductId;
    }

    public void setGmoNotificationProductId(long gmoNotificationProductID) {
        this.gmoNotificationProductId = gmoNotificationProductID;
    }

    @Column(name = "gmo_notifiationmaintenanceid")
    public long getGmoNotificationMaintenanceId() {
        return gmoNotificationMaintenanceId;
    }

    public void setGmoNotificationMaintenanceId(long gmoNotificationMaintenanceId) {
        this.gmoNotificationMaintenanceId = gmoNotificationMaintenanceId;
    }


    @Column(name = "gmo_notifiationPatrimonyCode")
    public String getGmoNotificationPatrimonyCode() {
        return gmoNotificationPatrimonyCode;
    }

    public void setGmoNotificationPatrimonyCode(String gmoNotificationPatrimonyCode) {
        this.gmoNotificationPatrimonyCode = gmoNotificationPatrimonyCode;
    }

    @Column(name = "gmo_notifiationTypePatrimony")
    public String getGmoNotificationTypePatrimony() {
        return gmoNotificationTypePatrimony;
    }

    public void setGmoNotificationTypePatrimony(String gmoNotificationTypePatrimony) {
        this.gmoNotificationTypePatrimony = gmoNotificationTypePatrimony;
    }


    @Column(name = "gmo_notifiationaction")
    public String getGmoNotificationAction() {
        return gmoNotificationAction;
    }

    public void setGmoNotificationAction(String gmoNotificationAction) {
        this.gmoNotificationAction = gmoNotificationAction;
    }
}
