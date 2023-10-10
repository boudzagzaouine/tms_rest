/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Setting;
import com.bagile.gmo.entities.PrmSetting;

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
        map.put("organisation", "orgOrganisation");
        map.put("pos", "prmSettingPos");
        map.put("gestCo", "prmSettingGestCo");
        map.put("crm", "prmSettingCrm");
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
        setting.setDescription(prmSetting.getPrmSettingDescription());

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
        prmSetting.setPrmSettingDescription(setting.getDescription());

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
