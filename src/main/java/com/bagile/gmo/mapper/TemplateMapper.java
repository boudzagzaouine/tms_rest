package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Template;
import com.bagile.gmo.entities.GmoTemplate;

import java.util.*;

public class TemplateMapper {
    public TemplateMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoTemplateid");
        map.put("code", "gmoTemplatecode");
        map.put("text", "gmoTemplatetext");
        map.put("subject", "gmoTemplatesubject");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoTemplate toEntity(Template template, boolean lazy) {
        if (null == template) {
            return null;
        }
        GmoTemplate gmoTemplate = new GmoTemplate();
        gmoTemplate.setGmoTemplateId(template.getId());
        gmoTemplate.setGmoTemplateCode(template.getCode() != null ? template.getCode().toUpperCase() : null);
        gmoTemplate.setGmoTemplateText (template.getText());
        gmoTemplate.setGmoTemplateSubject (template.getSubject());

        gmoTemplate.setCreatedBy(template.getCreatedBy());
        gmoTemplate.setUpdatedBy(template.getUpdatedBy());
        gmoTemplate.setCreationDate(template.getCreationDate());
        gmoTemplate.setUpdateDate(template.getUpdateDate());

          if(!lazy){
              gmoTemplate.setOwnOwner(OwnerMapper.toEntity(template.getOwner(),true));
          }

        return gmoTemplate;

    }

    public static Template toDto(GmoTemplate gmoTemplate, boolean lazy) {
        if (null == gmoTemplate) {
            return null;
        }
        Template template = new Template();
        template.setId((int) gmoTemplate.getGmoTemplateId());
        template.setCode(gmoTemplate.getGmoTemplateCode());
        template.setText (gmoTemplate.getGmoTemplateText ());
        template.setSubject (gmoTemplate.getGmoTemplateSubject ());

 if(!lazy){
      template.setOwner(OwnerMapper.toDto(gmoTemplate.getOwnOwner(),true));
 }
        return template;

    }


    public static List<Template> toDtos(Iterable<? extends GmoTemplate> gmoTemplates, boolean lazy) {
        if (null == gmoTemplates) {
            return null;
        }
        List<Template> vehicules = new ArrayList<>();

        for (GmoTemplate gmoTemplate : gmoTemplates) {
            vehicules.add(toDto(gmoTemplate, lazy));
        }
        return vehicules;
    }

    public static Set<GmoTemplate> toEntities(Set<Template> templates, boolean lazy) {
        if (null == templates) {
            return null;
        }
        Set<GmoTemplate> gmoTemplates = new HashSet<>();
        for (Template template : templates) {
            gmoTemplates.add(toEntity(template, lazy));
        }
        return gmoTemplates;
    }

    public static Set<Template> toDtos(Set<GmoTemplate> gmoTemplates, boolean lazy) {
        if (null == gmoTemplates) {
            return null;
        }
        Set<Template> templates = new HashSet<>();
        for (GmoTemplate gmoTemplate : gmoTemplates) {
            templates.add(toDto(gmoTemplate, lazy));
        }
        return templates;
    }
}
