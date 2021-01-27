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

        map.put ("id", "gmoNotificationId");
        map.put ("code", "gmoNotificationCode");
        map.put ("email", "gmoNotificationEmail");

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

    public static GmoNotificationType toEntity(NotificationType notificationType, boolean lazy) {
        if (null == notificationType) {
            return null;
        }

        GmoNotificationType gmoNotificationType = new GmoNotificationType ( );
        gmoNotificationType.setGmoNotificationId (notificationType.getId ( ));
        gmoNotificationType.setGmoNotificationCode (notificationType.getCode ( ) != null ? notificationType.getCode ( ).toUpperCase ( ) : null);
        gmoNotificationType.setGmoNotificationEmail (notificationType.getEmail ( ));

        gmoNotificationType.setCreatedBy (notificationType.getCreatedBy ( ));
        gmoNotificationType.setUpdatedBy (notificationType.getUpdatedBy ( ));

        if (!lazy) {
            gmoNotificationType.setOwnOwner(OwnerMapper.toEntity(notificationType.getOwner(), true));
        }
       
            return gmoNotificationType;

    }

    public static NotificationType toDto(GmoNotificationType gmoNotificationType, boolean lazy) {
        if (null == gmoNotificationType) {
            return null;
        }
        NotificationType notificationType = new NotificationType ( );
        notificationType.setId (gmoNotificationType.getGmoNotificationId ());
        notificationType.setCode (gmoNotificationType.getGmoNotificationCode ());
        notificationType.setEmail (gmoNotificationType.getGmoNotificationEmail ());

        notificationType.setCreatedBy (gmoNotificationType.getCreatedBy ());
        notificationType.setUpdatedBy (gmoNotificationType.getUpdatedBy ());
        notificationType.setCreationDate (gmoNotificationType.getCreationDate ());
        notificationType.setUpdateDate (gmoNotificationType.getUpdateDate ());


        if (!lazy) {
            notificationType.setOwner(OwnerMapper.toDto(gmoNotificationType.getOwnOwner(), true));
        }
        return notificationType;

    }


    public static List<NotificationType> toDtos(Iterable<? extends GmoNotificationType> gmoNotificationTypes, boolean lazy) {
        if (null == gmoNotificationTypes) {
            return null;
        }
        List<NotificationType> notificationTypes = new ArrayList<> ( );

        for (GmoNotificationType gmoNotificationType : gmoNotificationTypes) {
            notificationTypes.add (toDto (gmoNotificationType, lazy));
        }
        return notificationTypes;
    }

    public static Set<GmoNotificationType> toEntities(Set<NotificationType> notificationTypes, boolean lazy) {
        if (null == notificationTypes) {
            return null;
        }
        Set<GmoNotificationType> gmoNotificationTypes = new HashSet<> ( );
        for (NotificationType notificationType : notificationTypes) {
            gmoNotificationTypes.add (toEntity (notificationType, lazy));
        }
        return gmoNotificationTypes;
    }

    public static Set<NotificationType> toDtos(Set<GmoNotificationType> gmoNotificationTypes, boolean lazy) {
        if (null == gmoNotificationTypes) {
            return null;
        }
        Set<NotificationType> notificationTypes = new HashSet<> ( );
        for (GmoNotificationType gmoNotificationType : gmoNotificationTypes) {
            notificationTypes.add (toDto (gmoNotificationType, lazy));
        }
        return notificationTypes;
    }
}
