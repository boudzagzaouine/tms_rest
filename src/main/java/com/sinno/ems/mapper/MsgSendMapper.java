package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by ASMAE on 04/05/2016.
 */
public class MsgSendMapper {
    private MsgSendMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "prmMsgSendId");
        map.put("fileType", "prmMsgSendFileType");
        map.put("active", "prmMsgSendActive");
        map.put("format", "prmMsgSendFormat");
        map.put("path", "prmMsgSendPath");
        map.put("arcPath", "prmMsgSendArcPath");
        map.put("frequency", "prmMsgSendFrequency");
        map.put("arcDelay", "prmMsgSendArcDelay");
        map.put("creationDate", "prmMsgSendCreationDate");
        map.put("updateDate", "prmMsgSendUpdateDate");
        map.put("priority", "prmMsgSendPriority");
        map.put("fileName", "prmMsgSendFileName");
        map.put("langue","prmMsgSendLangue");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmMsgSend toEntity(MsgSend msgSend, boolean lazy) {
        if (null == msgSend) {
            return null;
        }
        PrmMsgSend prmMsgSend = new PrmMsgSend();
        prmMsgSend.setPrmMsgSendId(msgSend.getId());
        prmMsgSend.setPrmMsgSendFileType(msgSend.getFileType());
        prmMsgSend.setPrmMsgSendActive(msgSend.getActive());
        prmMsgSend.setPrmMsgSendFormat(msgSend.getFormat());
        prmMsgSend.setPrmMsgSendPath(msgSend.getPath());
        prmMsgSend.setPrmMsgSendArcPath(msgSend.getArcPath());
        prmMsgSend.setPrmMsgSendFrequency(msgSend.getFrequency());
        prmMsgSend.setPrmMsgSendArcDelay(msgSend.getArcDelay());
        prmMsgSend.setPrmMsgSendCreationDate(msgSend.getCreationDate());
        prmMsgSend.setPrmMsgSendUpdateDate(msgSend.getUpdateDate());
        prmMsgSend.setPrmMsgSendPriority(msgSend.getPriority());
        prmMsgSend.setPrmMsgSendFileName(msgSend.getFileName());
        prmMsgSend.setPrmMsgSendLangue(msgSend.getLangue());

        return prmMsgSend;
    }

    public static MsgSend toDto(PrmMsgSend prmMsgSend, boolean lazy) {
        if (null == prmMsgSend) {
            return null;
        }
        MsgSend msgSend = new MsgSend();
        msgSend.setId(prmMsgSend.getPrmMsgSendId());
        msgSend.setFileType(prmMsgSend.getPrmMsgSendFileType());
        msgSend.setActive(prmMsgSend.isPrmMsgSendActive());
        msgSend.setFormat(prmMsgSend.getPrmMsgSendFormat());
        msgSend.setPath(prmMsgSend.getPrmMsgSendPath());
        msgSend.setArcPath(prmMsgSend.getPrmMsgSendArcPath());
        msgSend.setFrequency(prmMsgSend.getPrmMsgSendFrequency());
        msgSend.setArcDelay(prmMsgSend.getPrmMsgSendArcDelay());
        msgSend.setCreationDate(prmMsgSend.getPrmMsgSendCreationDate());
        msgSend.setUpdateDate(prmMsgSend.getPrmMsgSendUpdateDate());
        msgSend.setPriority(prmMsgSend.getPrmMsgSendPriority());
        msgSend.setFileName(prmMsgSend.getPrmMsgSendFileName());
        msgSend.setLangue(prmMsgSend.getPrmMsgSendLangue());

        return msgSend;
    }

    public static List<MsgSend> toDtos(List<PrmMsgSend> prmMsgSends, boolean lazy) {
        if (null == prmMsgSends) {
            return null;
        }
        List<MsgSend> msgSends = new ArrayList<>();
        for (PrmMsgSend prmMsgSend : prmMsgSends) {
            msgSends.add(toDto(prmMsgSend, lazy));
        }
        return msgSends;
    }

    public static List<MsgSend> toDtos(Iterable<PrmMsgSend> prmMsgSends, boolean lazy) {
        if (null == prmMsgSends) {
            return null;
        }
        List<MsgSend> msgSends = new ArrayList<>();
        for (PrmMsgSend prmMsgSend : prmMsgSends) {
            msgSends.add(toDto(prmMsgSend, lazy));
        }
        return msgSends;
    }

    public static Set<PrmMsgSend> toEntities(Set<MsgSend> msgSends, boolean lazy) {
        if (null == msgSends) {
            return null;
        }
        Set<PrmMsgSend> prmMsgSends = new HashSet<>();
        for (MsgSend msgSend : msgSends) {
            prmMsgSends.add(toEntity(msgSend, lazy));
        }
        return prmMsgSends;
    }

    public static Set<MsgSend> toDtos(Set<PrmMsgSend> prmMsgSends, boolean lazy) {
        if (null == prmMsgSends) {
            return null;
        }
        Set<MsgSend> msgSends = new HashSet<>();
        for (PrmMsgSend prmMsgSend : prmMsgSends) {
            msgSends.add(toDto(prmMsgSend, lazy));
        }
        return msgSends;
    }
}
