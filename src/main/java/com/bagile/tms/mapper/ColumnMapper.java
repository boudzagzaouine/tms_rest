package com.bagile.tms.mapper;

import com.sinno.ems.entities.PrmColumn;

import java.util.*;

public class ColumnMapper {
    private ColumnMapper(){}

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","prmColumnId");
        map.put("name","prmColumnName");
        map.put("classe","prmColumnClasse");
        map.put("position","prmColumnPosition");
        map.put("visible","prmColumnVisible");
        map.put("user","usrUser");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmColumn toEntity(Column column, boolean lazy) {
        if (null == column) {
            return null;
        }
        PrmColumn prmColumn = new PrmColumn();
        prmColumn.setPrmColumnId(column.getId());
        prmColumn.setPrmColumnName(column.getName());
        prmColumn.setPrmColumnClasse(column.getClasse());
        prmColumn.setPrmColumnPosition(column.getPosition());
        prmColumn.setPrmColumnVisible(column.getVisible());
        return prmColumn;
    }

    public static Column toDto(PrmColumn prmColumn, boolean lazy) {
        if (null == prmColumn) {
            return null;
        }
        Column column = new Column();
        column.setId(prmColumn.getPrmColumnId());
        column.setName(prmColumn.getPrmColumnName());
        column.setClasse(prmColumn.getPrmColumnClasse());
        column.setPosition(prmColumn.getPrmColumnPosition());
        column.setVisible(prmColumn.getPrmColumnVisible());
        return column;
    }

    public static List<Column> toDtos(List<PrmColumn> prmColumns, boolean lazy) {
        if (null == prmColumns) {
            return null;
        }
        List<Column> columns = new ArrayList<>();
        for (PrmColumn prmColumn : prmColumns) {
            columns.add(toDto(prmColumn, lazy));
        }
        return columns;
    }

    public static List<Column> toDtos(Iterable<PrmColumn> prmColumns, boolean lazy) {
        if (null == prmColumns) {
            return null;
        }
        List<Column> columns = new ArrayList<>();
        for (PrmColumn prmColumn : prmColumns) {
            columns.add(toDto(prmColumn, lazy));
        }
        return columns;
    }

    public static Set<PrmColumn> toEntities(Set<Column> columns, boolean lazy) {
        if (null == columns) {
            return null;
        }
        Set<PrmColumn> prmColumns = new HashSet<>();
        for (Column column : columns) {
            prmColumns.add(toEntity(column, lazy));
        }
        return prmColumns;
    }

    public static Set<Column> toDtos(Set<PrmColumn> prmColumns, boolean lazy) {
        if (null == prmColumns) {
            return null;
        }
        Set<Column> columns = new HashSet<>();
        for (PrmColumn prmColumn : prmColumns) {
            columns.add(toDto(prmColumn, lazy));
        }
        return columns;
    }
}
