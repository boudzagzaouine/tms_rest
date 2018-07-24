/**
 *
 */
package com.bagile.tms.mapper;

import com.sinno.ems.dto.Setting;
import com.sinno.ems.entities.PrmSetting;

import java.util.*;

/**
 * @author aelguezzar
 */
public class SettingMapper {
    private SettingMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmSettingId");
        map.put("code", "prmSettingCode");
        map.put("value", "prmSettingValue");


    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Setting toDto(PrmSetting prmSetting, boolean lazy) {
        if (null == prmSetting) {
            return null;
        }
        Setting setting = new Setting();
        setting.setId(prmSetting.getPrmSettingId());
        setting.setCode(prmSetting.getPrmSettingCode());
        setting.setValue(prmSetting.getPrmSettingValue());
        if (!lazy) {
            setting.setOrganisation(OrganisationMapper.toDto(prmSetting.getOrgOrganisation(), true));
        }
        return setting;
    }

    public static PrmSetting toEntity(Setting setting, boolean lazy) {
        if (null == setting) {
            return null;
        }
        PrmSetting prmSetting = new PrmSetting();
        prmSetting.setPrmSettingId(setting.getId());
        prmSetting.setPrmSettingCode(setting.getCode());
        prmSetting.setPrmSettingValue(setting.getValue());
        if (!lazy) {
            prmSetting.setOrgOrganisation(OrganisationMapper.toEntity(setting.getOrganisation(), false));
        }
        return prmSetting;
    }

    public static List<Setting> toDtos(List<PrmSetting> prmSettings, boolean lazy) {
        if (null == prmSettings) {
            return null;
        }
        List<Setting> settings = new ArrayList<>();
        for (PrmSetting prmSetting : prmSettings) {
            settings.add(toDto(prmSetting, lazy));
        }
        return settings;
    }

    public static List<Setting> toDtos(Iterable<PrmSetting> prmSettings, boolean lazy) {
        if (null == prmSettings) {
            return null;
        }
        List<Setting> settings = new ArrayList<>();
        for (PrmSetting prmSetting : prmSettings) {
            settings.add(toDto(prmSetting, lazy));
        }
        return settings;
    }

    public static Set<PrmSetting> toEntities(Set<Setting> settings, boolean lazy) {
        if (null == settings) {
            return null;
        }
        Set<PrmSetting> prmSettings = new HashSet<>();
        for (Setting setting : settings) {
            prmSettings.add(toEntity(setting, lazy));
        }
        return prmSettings;
    }

    public static Set<Setting> toDtos(Set<PrmSetting> prmSettings, boolean lazy) {
        if (null == prmSettings) {
            return null;
        }
        Set<Setting> settings = new HashSet<>();
        for (PrmSetting prmSetting : prmSettings) {
            settings.add(toDto(prmSetting, lazy));
        }
        return settings;
    }
}
