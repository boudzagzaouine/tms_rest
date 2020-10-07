package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.NotificationState;
import com.bagile.gmo.entities.GmoNotificationState;

import java.util.*;

public class NotificationStateMapper {
    public NotificationStateMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoNotificationStateId");
        map.put ("code", "gmoNotificationStateCode");
        map.put ("description", "gmoNotificationStateDescription");

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

    public static GmoNotificationState toEntity(NotificationState notificationState, boolean lazy) {
        if (null == notificationState) {
            return null;
        }

        GmoNotificationState gmoNotificationState = new GmoNotificationState ( );
        gmoNotificationState.setGmoNotificationId (notificationState.getId ( ));
        gmoNotificationState.setGmoNotificationCode (notificationState.getCode ( ) != null ? notificationState.getCode ( ).toUpperCase ( ) : null);
        gmoNotificationState.setGmoNotificationDescription (notificationState.getDescription ( ));

        gmoNotificationState.setCreatedBy (notificationState.getCreatedBy ( ));
        gmoNotificationState.setUpdatedBy (notificationState.getUpdatedBy ( ));



        return gmoNotificationState;

    }

    public static NotificationState toDto(GmoNotificationState gmoNotificationState, boolean lazy) {
        if (null == gmoNotificationState) {
            return null;
        }
        NotificationState notificationState = new NotificationState ( );
        notificationState.setId ((int) gmoNotificationState.getGmoNotificationId ());
        notificationState.setCode (gmoNotificationState.getGmoNotificationCode ());
        notificationState.setDescription (gmoNotificationState.getGmoNotificationDescription ());

        notificationState.setCreatedBy (gmoNotificationState.getCreatedBy ());
        notificationState.setUpdatedBy (gmoNotificationState.getUpdatedBy ());
        notificationState.setCreationDate (gmoNotificationState.getCreationDate ());
        notificationState.setUpdateDate (gmoNotificationState.getUpdateDate ());


        return notificationState;

    }


    public static List<NotificationState> toDtos(Iterable<? extends GmoNotificationState> gmoNotificationStates, boolean lazy) {
        if (null == gmoNotificationStates) {
            return null;
        }
        List<NotificationState> vehicules = new ArrayList<> ( );

        for (GmoNotificationState gmoNotificationState : gmoNotificationStates) {
            vehicules.add (toDto (gmoNotificationState, lazy));
        }
        return vehicules;
    }

    public static Set<GmoNotificationState> toEntities(Set<NotificationState> notificationStates, boolean lazy) {
        if (null == notificationStates) {
            return null;
        }
        Set<GmoNotificationState> gmoNotificationStates = new HashSet<> ( );
        for (NotificationState notificationState : notificationStates) {
            gmoNotificationStates.add (toEntity (notificationState, lazy));
        }
        return gmoNotificationStates;
    }

    public static Set<NotificationState> toDtos(Set<GmoNotificationState> gmoNotificationStates, boolean lazy) {
        if (null == gmoNotificationStates) {
            return null;
        }
        Set<NotificationState> notificationStates = new HashSet<> ( );
        for (GmoNotificationState gmoNotificationState : gmoNotificationStates) {
            notificationStates.add (toDto (gmoNotificationState, lazy));
        }
        return notificationStates;
    }
}
