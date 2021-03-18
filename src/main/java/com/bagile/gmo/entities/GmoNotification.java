package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name="gmo_notification")
public class GmoNotification extends EmsEntity{


    private Long gmoNotificationId;
    private String gmoNotificationCode;
    private GmoNotificationState gmoNotificationState;
    private String  gmoNotificationPatrimonyType;
    private String gmoNotificationProgrameType;
    private String gmoNotificationIntervention;
    private Long gmoNotificationProductId;
    private Long gmoNotificationMaintenanceId;
    private String gmoNotificationPatrimonyCode ;
    private GmoNotificationType gmoNotificationType;
    private String gmoNotificationAction;

    private GmoResponsability gmoResponsability;

    private GmoServiceProvider gmoServiceProvider;
    //private  String gmoAgent;
 private GmoAgent gmoAgent;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_notification_id", allocationSize = 1)
    @Column(name = "gmo_notificationid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoNotificationId() {
        return gmoNotificationId;
    }

    public void setGmoNotificationId(Long gmoNotificationId) {
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_responsabilityid")
    public GmoResponsability getGmoResponsability() {
        return gmoResponsability;
    }

    public void setGmoResponsability(GmoResponsability gmoResponsability) {
        this.gmoResponsability = gmoResponsability;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_serviceproviderid")
    public GmoServiceProvider getGmoServiceProvider() {
        return gmoServiceProvider;
    }

    public void setGmoServiceProvider(GmoServiceProvider gmoServiceProvider) {
        this.gmoServiceProvider = gmoServiceProvider;
    }

  /*  @Column(name = "gmo_agent", length = 90)
    public String getGmoAgent() {
        return gmoAgent;
    }

    public void setGmoAgent(String gmoAgent) {
        this.gmoAgent = gmoAgent;
    }*/

    @ManyToOne
    @JoinColumn(name = "gmo_agentid")
    public GmoAgent getGmoAgent() {
        return gmoAgent;
    }

    public void setGmoAgent(GmoAgent gmoAgent) {
        this.gmoAgent = gmoAgent;
    }

    @Column(name = "gmo_notificationpatrimonytype", length = 90)
    public String getGmoNotificationPatrimonyType() {
        return gmoNotificationPatrimonyType;
    }

    public void setGmoNotificationPatrimonyType(String gmoNotificationPatrimonyType) {
        this.gmoNotificationPatrimonyType = gmoNotificationPatrimonyType;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_notificationtypeid")
    public GmoNotificationType getGmoNotificationType() {
        return gmoNotificationType;
    }

    public void setGmoNotificationType(GmoNotificationType gmoNotificationTypePatrimony) {
        this.gmoNotificationType = gmoNotificationTypePatrimony;
    }

    @Column(name = "gmo_notificationprogrametype")
    public String getGmoNotificationProgrameType() {
        return gmoNotificationProgrameType;
    }

    public void setGmoNotificationProgrameType(String gmoNotificationProgrameType) {
        this.gmoNotificationProgrameType = gmoNotificationProgrameType;
    }

    @Column(name = "gmo_notificationintervention")
    public String getGmoNotificationIntervention() {
        return gmoNotificationIntervention;
    }

    public void setGmoNotificationIntervention(String gmoNotificationIntervention) {
        this.gmoNotificationIntervention = gmoNotificationIntervention;
    }

    @Column(name = "gmo_notificationproductid")
    public Long getGmoNotificationProductId() {
        return gmoNotificationProductId;
    }

    public void setGmoNotificationProductId(Long gmoNotificationProductID) {
        this.gmoNotificationProductId = gmoNotificationProductID;
    }

    @Column(name = "gmo_notifiationmaintenanceid")
    public Long getGmoNotificationMaintenanceId() {
        return gmoNotificationMaintenanceId;
    }

    public void setGmoNotificationMaintenanceId(Long gmoNotificationMaintenanceId) {
        this.gmoNotificationMaintenanceId = gmoNotificationMaintenanceId;
    }


    @Column(name = "gmo_notifiationPatrimonyCode")
    public String getGmoNotificationPatrimonyCode() {
        return gmoNotificationPatrimonyCode;
    }

    public void setGmoNotificationPatrimonyCode(String gmoNotificationPatrimonyCode) {
        this.gmoNotificationPatrimonyCode = gmoNotificationPatrimonyCode;
    }



    @Column(name = "gmo_notifiationaction")
    public String getGmoNotificationAction() {
        return gmoNotificationAction;
    }

    public void setGmoNotificationAction(String gmoNotificationAction) {
        this.gmoNotificationAction = gmoNotificationAction;
    }
}
