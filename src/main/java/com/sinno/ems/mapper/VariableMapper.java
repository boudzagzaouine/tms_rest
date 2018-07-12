package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Adil on 3/21/2017.
 */
public class VariableMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmVariableId");
        map.put("code", "prmVariableCode");
        map.put("description", "prmVariableDescription");
        map.put("active", "prmVariableActive");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }
    
    public static PrmVariable toEntity(Variable variable, boolean lazy){
        PrmVariable prmVariable = new PrmVariable();
        prmVariable.setPrmVariableId(variable.getId());
        prmVariable.setPrmVariableCode(variable.getCode());
        prmVariable.setPrmVariableDescription(variable.getDescription());
        prmVariable.setPrmVariableActive(variable.getActive());
        return prmVariable;
    }
    
    public static Variable toDto(PrmVariable prmVariable, boolean lazy){
        Variable variable = new Variable();
        variable.setId(prmVariable.getPrmVariableId());
        variable.setCode(prmVariable.getPrmVariableCode());
        variable.setDescription(prmVariable.getPrmVariableDescription());
        variable.setActive(prmVariable.getPrmVariableActive());
        
        return variable;
    }

    public static List<Variable> toDtos(List<PrmVariable> prmVariables, boolean lazy) {
        if (null == prmVariables) {
            return null;
        }
        List<Variable> variables = new ArrayList<>();
        for (PrmVariable prmVariable : prmVariables) {
            variables.add(toDto(prmVariable, lazy));
        }
        return variables;
    }

    public static List<Variable> toDtos(Iterable<PrmVariable> prmVariables, boolean lazy) {
        if (null == prmVariables) {
            return null;
        }
        List<Variable> variables = new ArrayList<>();
        for (PrmVariable prmVariable : prmVariables) {
            variables.add(toDto(prmVariable, lazy));
        }
        return variables;
    }

    public static Set<PrmVariable> toEntities(Set<Variable> variables, boolean lazy) {
        if (null == variables) {
            return null;
        }
        Set<PrmVariable> prmVariables = new HashSet<>();
        for (Variable variable : variables) {
            prmVariables.add(toEntity(variable, lazy));
        }
        return prmVariables;
    }

    public static Set<Variable> toDtos(Set<PrmVariable> prmVariables, boolean lazy) {
        if (null == prmVariables) {
            return null;
        }
        Set<Variable> variables = new HashSet<>();
        for (PrmVariable prmVariable : prmVariables) {
            variables.add(toDto(prmVariable, lazy));
        }
        return variables;
    }
}
