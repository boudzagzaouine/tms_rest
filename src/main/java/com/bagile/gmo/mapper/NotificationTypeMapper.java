package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.NotificationType;
import com.bagile.gmo.entities.GmoNotificationType;

import java.util.*;

public class NotificationTypeMapper {
    public NotificationTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoNotificationTypeId");
        map.put ("code", "gmoNotificationTypeCode");
        map.put ("email", "gmoNotificationTypeEmail");

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

    public static GmoNotificationType toEntity(NotificationType notificationState, boolean lazy) {
        if (null == notificationState) {
            return null;
        }

        GmoNotificationType gmoNotificationType = new GmoNotificationType ( );
        gmoNotificationType.setGmoNotificationId (notificationState.getId ( ));
        gmoNotificationType.setGmoNotificationCode (notificationState.getCode ( ) != null ? notificationState.getCode ( ).toUpperCase ( ) : null);
        gmoNotificationType.setGmoNotificationEmail (notificationState.getEmail ( ));

        gmoNotificationType.setCreatedBy (notificationState.getCreatedBy ( ));
        gmoNotificationType.setUpdatedBy (notificationState.getUpdatedBy ( ));



        return gmoNotificationType;

    }

    public static NotificationType toDto(GmoNotificationType gmoNotificationType, boolean lazy) {
        if (null == gmoNotificationType) {
            return null;
        }
        NotificationType notificationState = new NotificationType ( );
        notificationState.setId ((int) gmoNotificationType.getGmoNotificationId ());
        notificationState.setCode (gmoNotificationType.getGmoNotificationCode ());
        notificationState.setEmail (gmoNotificationType.getGmoNotificationEmail ());

        notificationState.setCreatedBy (gmoNotificationType.getCreatedBy ());
        notificationState.setUpdatedBy (gmoNotificationType.getUpdatedBy ());
        notificationState.setCreationDate (gmoNotificationType.getCreationDate ());
        notificationState.setUpdateDate (gmoNotificationType.getUpdateDate ());


        return notificationState;

    }


    public static List<NotificationType> toDtos(Iterable<? extends GmoNotificationType> gmoNotificationTypes, boolean lazy) {
        if (null == gmoNotificationTypes) {
            return null;
        }
        List<NotificationType> vehicules = new ArrayList<> ( );

        for (GmoNotificationType gmoNotificationType : gmoNotificationTypes) {
            vehicules.add (toDto (gmoNotificationType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoNotificationType> toEntities(Set<NotificationType> notificationStates, boolean lazy) {
        if (null == notificationStates) {
            return null;
        }
        Set<GmoNotificationType> gmoNotificationTypes = new HashSet<> ( );
        for (NotificationType notificationState : notificationStates) {
            gmoNotificationTypes.add (toEntity (notificationState, lazy));
        }
        return gmoNotificationTypes;
    }

    public static Set<NotificationType> toDtos(Set<GmoNotificationType> gmoNotificationTypes, boolean lazy) {
        if (null == gmoNotificationTypes) {
            return null;
        }
        Set<NotificationType> notificationStates = new HashSet<> ( );
        for (GmoNotificationType gmoNotificationType : gmoNotificationTypes) {
            notificationStates.add (toDto (gmoNotificationType, lazy));
        }
        return notificationStates;
    }
}
