package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Notification;
import com.bagile.gmo.entities.GmoNotification;

import java.util.*;

public class NotificationMapper {
    public NotificationMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoNotificationId");
        map.put ("code", "gmoNotificationCode");
        map.put ("notificationState", "gmoNotificationState");
        map.put ("notificationType", "gmoNotificationType");
        map.put ("productId", "gmoNotificationProductId");
        map.put ("maintenanceId", "gmoNotificationMaintenanceId");


        map.put ("patimonyCode", "gmoNotificationPatrimonyCode");
        map.put ("patrimonyType", "gmoNotificationPatrimonyType");
        map.put ("action", "gmoNotificationAction");

        map.put ("responsability", "gmoResponsability");
        map.put ("serviceProvider", "gmoServiceProvider");
        map.put ("agent", "gmoAgent");

        map.put ("creationDate", "creationDate");
        map.put ("updateDate", "updateDate");
        map.put ("createdBy", "createdBy");
        map.put ("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get (key);
    }

    public static GmoNotification toEntity(Notification notification, boolean lazy) {
        if (null == notification) {
            return null;
        }

        GmoNotification gmoNotification = new GmoNotification ( );
        gmoNotification.setGmoNotificationId (notification.getId ( ));
        gmoNotification.setGmoNotificationCode (notification.getCode ( ) != null ? notification.getCode ( ).toUpperCase ( ) : null);
        gmoNotification.setGmoNotificationProductId(notification.getProductId ());

        gmoNotification.setGmoNotificationMaintenanceId(notification.getMaintenanceId ( ));
        gmoNotification.setGmoNotificationPatrimonyCode(notification.getPatimonyCode ( ));
        gmoNotification.setGmoNotificationAction(notification.getAction ( ));
        gmoNotification.setGmoNotificationPatrimonyType(notification.getPatrimonyType ( ));
        gmoNotification.setGmoNotificationIntervention(notification.getIntervention ( ));
        gmoNotification.setGmoNotificationProgrameType(notification.getProgrameType ());
        //gmoNotification.setGmoAgent(notification.getAgent ());

        gmoNotification.setCreatedBy (notification.getCreatedBy ( ));
        gmoNotification.setUpdatedBy (notification.getUpdatedBy ( ));

        if (!lazy) {
            gmoNotification.setGmoNotificationState (NotificationStateMapper.toEntity (notification.getNotificationState ( ), true));
            gmoNotification.setGmoNotificationType (NotificationTypeMapper.toEntity (notification.getNotificationType ( ), true));
            gmoNotification.setGmoResponsability (ResponsabilityMapper.toEntity (notification.getResponsability ( ), true));
            gmoNotification.setGmoServiceProvider (ServiceProviderMapper.toEntity (notification.getServiceProvider ( ), true));
            gmoNotification.setGmoAgent (AgentMapper.toEntity (notification.getAgent ( ), true));

        }

        return gmoNotification;

    }

    public static Notification toDto(GmoNotification gmoNotification, boolean lazy) {
        if (null == gmoNotification) {
            return null;
        }
        Notification notification = new Notification ( );
        notification.setId (gmoNotification.getGmoNotificationId ());
        notification.setCode (gmoNotification.getGmoNotificationCode ());
        notification.setPatrimonyType (gmoNotification.getGmoNotificationPatrimonyType ());

        notification.setProductId (gmoNotification.getGmoNotificationProductId());
        notification.setMaintenanceId (gmoNotification.getGmoNotificationMaintenanceId());
        notification.setAction (gmoNotification.getGmoNotificationAction());
        notification.setPatimonyCode (gmoNotification.getGmoNotificationPatrimonyCode());
        notification.setIntervention (gmoNotification.getGmoNotificationIntervention());
        notification.setProgrameType (gmoNotification.getGmoNotificationProgrameType());
     //   notification.setAgent (gmoNotification.getGmoAgent());


        notification.setCreatedBy (gmoNotification.getCreatedBy ());
        notification.setUpdatedBy (gmoNotification.getUpdatedBy ());
        notification.setCreationDate (gmoNotification.getCreationDate ());
        notification.setUpdateDate (gmoNotification.getUpdateDate ());

        if (!lazy) {
            notification.setNotificationState (NotificationStateMapper.toDto (gmoNotification.getGmoNotificationState(), true));
            notification.setNotificationType (NotificationTypeMapper.toDto (gmoNotification.getGmoNotificationType(), true));
            notification.setResponsability (ResponsabilityMapper.toDto (gmoNotification.getGmoResponsability(), true));
            notification.setServiceProvider (ServiceProviderMapper.toDto (gmoNotification.getGmoServiceProvider(), true));
            notification.setAgent (AgentMapper.toDto (gmoNotification.getGmoAgent(), true));


        }
        return notification;

    }


    public static List<Notification> toDtos(Iterable<? extends GmoNotification> gmoNotifications, boolean lazy) {
        if (null == gmoNotifications) {
            return null;
        }
        List<Notification> vehicules = new ArrayList<> ( );

        for (GmoNotification gmoNotification : gmoNotifications) {
            vehicules.add (toDto (gmoNotification, lazy));
        }
        return vehicules;
    }

    public static Set<GmoNotification> toEntities(Set<Notification> notifications, boolean lazy) {
        if (null == notifications) {
            return null;
        }
        Set<GmoNotification> gmoNotifications = new HashSet<> ( );
        for (Notification notification : notifications) {
            gmoNotifications.add (toEntity (notification, lazy));
        }
        return gmoNotifications;
    }

    public static Set<Notification> toDtos(Set<GmoNotification> gmoNotifications, boolean lazy) {
        if (null == gmoNotifications) {
            return null;
        }
        Set<Notification> notifications = new HashSet<> ( );
        for (GmoNotification gmoNotification : gmoNotifications) {
            notifications.add (toDto (gmoNotification, lazy));
        }
        return notifications;
    }
}
