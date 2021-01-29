package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class Notification extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private String code;
    private String patrimonyType;
    private String programeType;
    private NotificationState notificationState;
    private long productId;
    private long maintenanceId;
    private String patimonyCode;
    private String intervention;
    private NotificationType notificationType;
    private String   action ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPatrimonyType() {
        return patrimonyType;
    }

    public void setPatrimonyType(String patrimonyType) {
        this.patrimonyType = patrimonyType;
    }

    public NotificationState getNotificationState() {
        return notificationState;
    }

    public void setNotificationState(NotificationState notificationState) {
        this.notificationState = notificationState;
    }

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public String getProgrameType() {
        return programeType;
    }

    public void setProgrameType(String programeType) {
        this.programeType = programeType;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getPatimonyCode() {
        return patimonyCode;
    }

    public void setPatimonyCode(String patimonyCode) {
        this.patimonyCode = patimonyCode;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }



    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification badgeType = (Notification) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
