package com.sinno.ems.mapper;

import com.sinno.ems.dto.MsgReceive;
import com.sinno.ems.entities.PrmMsgReceive;

import java.util.*;

/**
 * Created by ASMAE on 03/05/2016.
 */
public class MsgReceiveMapper {
    private MsgReceiveMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "prmMsgRecieveId");
        map.put("fileType", "prmMsgRecieveFileType");
        map.put("active", "prmMsgRecieveActive");
        map.put("format", "prmMsgRecieveFormat");
        map.put("path", "prmMsgRecievePath");
        map.put("arcPath", "prmMsgRecieveArcPath");
        map.put("frequency", "prmMsgRecieveFrequency");
        map.put("arcDelay", "prmMsgRecieveArcDelay");
        map.put("creationDate", "prmMsgRecieveCreationDate");
        map.put("updateDate", "prmMsgRecieveUpdateDate");
        map.put("priority", "prmMsgRecievePriority");



    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmMsgReceive toEntity(MsgReceive msgReceive, boolean lazy) {
        if (null == msgReceive) {
            return null;
        }
        PrmMsgReceive prmMsgRecieve = new PrmMsgReceive();
        prmMsgRecieve.setPrmMsgRecieveId(msgReceive.getId());
        prmMsgRecieve.setPrmMsgRecieveFileType(msgReceive.getFileType());
        prmMsgRecieve.setPrmMsgRecieveActive(msgReceive.getActive());
        prmMsgRecieve.setPrmMsgRecieveFormat(msgReceive.getFormat());
        prmMsgRecieve.setPrmMsgRecievePath(msgReceive.getPath());
        prmMsgRecieve.setPrmMsgRecieveArcPath(msgReceive.getArcPath());
        prmMsgRecieve.setPrmMsgRecieveFrequency(msgReceive.getFrequency());
        prmMsgRecieve.setPrmMsgRecieveArcDelay(msgReceive.getArcDelay());
        prmMsgRecieve.setPrmMsgRecieveCreationDate(msgReceive.getCreationDate());
        prmMsgRecieve.setPrmMsgRecieveUpdateDate(msgReceive.getUpdateDate());
        prmMsgRecieve.setPrmMsgRecievePriority(msgReceive.getPriority());

        return prmMsgRecieve;
    }

    public static MsgReceive toDto(PrmMsgReceive prmMsgRecieve, boolean lazy) {
        if (null == prmMsgRecieve) {
            return null;
        }
        MsgReceive msgReceive = new MsgReceive();
        msgReceive.setId(prmMsgRecieve.getPrmMsgRecieveId());
        msgReceive.setFileType(prmMsgRecieve.getPrmMsgRecieveFileType());
        msgReceive.setActive(prmMsgRecieve.isPrmMsgRecieveActive());
        msgReceive.setFormat(prmMsgRecieve.getPrmMsgRecieveFormat());
        msgReceive.setPath(prmMsgRecieve.getPrmMsgRecievePath());
        msgReceive.setArcPath(prmMsgRecieve.getPrmMsgRecieveArcPath());
        msgReceive.setFrequency(prmMsgRecieve.getPrmMsgRecieveFrequency());
        msgReceive.setArcDelay(prmMsgRecieve.getPrmMsgRecieveArcDelay());
        msgReceive.setCreationDate(prmMsgRecieve.getPrmMsgRecieveCreationDate());
        msgReceive.setUpdateDate(prmMsgRecieve.getPrmMsgRecieveUpdateDate());
        msgReceive.setPriority(prmMsgRecieve.getPrmMsgRecievePriority());

        return msgReceive;
    }

    public static List<MsgReceive> toDtos(List<PrmMsgReceive> prmMsgRecieves, boolean lazy) {
        if (null == prmMsgRecieves) {
            return null;
        }
        List<MsgReceive> msgReceives = new ArrayList<>();
        for (PrmMsgReceive prmMsgRecieve : prmMsgRecieves) {
            msgReceives.add(toDto(prmMsgRecieve, lazy));
        }
        return msgReceives;
    }

    public static List<MsgReceive> toDtos(Iterable<PrmMsgReceive> prmMsgRecieves, boolean lazy) {
        if (null == prmMsgRecieves) {
            return null;
        }
        List<MsgReceive> msgRecieves = new ArrayList<>();
        for (PrmMsgReceive prmMsgRecieve : prmMsgRecieves) {
            msgRecieves.add(toDto(prmMsgRecieve, lazy));
        }
        return msgRecieves;
    }

    public static Set<PrmMsgReceive> toEntities(Set<MsgReceive> msgRecieves, boolean lazy) {
        if (null == msgRecieves) {
            return null;
        }
        Set<PrmMsgReceive> prmMsgRecieves = new HashSet<>();
        for (MsgReceive msgReceive : msgRecieves) {
            prmMsgRecieves.add(toEntity(msgReceive, lazy));
        }
        return prmMsgRecieves;
    }

    public static Set<MsgReceive> toDtos(Set<PrmMsgReceive> prmMsgRecieves, boolean lazy) {
        if (null == prmMsgRecieves) {
            return null;
        }
        Set<MsgReceive> msgRecieves = new HashSet<>();
        for (PrmMsgReceive prmMsgRecieve : prmMsgRecieves) {
            msgRecieves.add(toDto(prmMsgRecieve, lazy));
        }
        return msgRecieves;
    }
}
