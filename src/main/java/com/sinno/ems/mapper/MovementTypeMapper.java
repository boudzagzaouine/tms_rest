/**
 *
 */
package com.sinno.ems.mapper;

import java.util.*;

/**
 * @author aelguezzar
 */
public class MovementTypeMapper {
    private MovementTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invMovementTypeId");
        map.put("code", "invMovementTypeCode");
        map.put("description", "invMovementTypeDescription");
        map.put("active", "invMovementTypeActive");
        map.put("creationDate", "invMovementTypeCreationDate");
        map.put("updateDate", "invMovementTypeUpdateDate");
        map.put("organisation", "orgOrganisation");


    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static MovementType toDto(InvMovementType invMovementType, boolean lazy) {
        if (null == invMovementType) {
            return null;
        }
        MovementType movementType = new MovementType();
        movementType.setCode(invMovementType.getInvMovementTypeCode());
        movementType.setDescription(invMovementType.getInvMovementTypeDescription());
        movementType.setId(invMovementType.getInvMovementTypeId());
        movementType.setCreationDate(invMovementType.getInvMovementTypeCreationDate());
        movementType.setUpdateDate(invMovementType.getInvMovementTypeUpdateDate());
        movementType.setActive(invMovementType.getInvMovementTypeActive());
        if (!lazy) {
            movementType.setOrganisation(OrganisationMapper.toDto(invMovementType.getOrgOrganisation(), true));

        }
        return movementType;
    }

    public static InvMovementType toEntity(MovementType movementType, boolean lazy) {
        if (null == movementType) {
            return null;
        }
        InvMovementType invMovementType = new InvMovementType();
        invMovementType.setInvMovementTypeCode(movementType.getCode() != null ? movementType.getCode().toUpperCase() : null);
        invMovementType.setInvMovementTypeDescription(movementType.getDescription());
        invMovementType.setInvMovementTypeId(movementType.getId());
        invMovementType.setInvMovementTypeActive(movementType.getActive());
        invMovementType.setInvMovementTypeCreationDate(movementType.getCreationDate());
        invMovementType.setInvMovementTypeUpdateDate(movementType.getUpdateDate());
        if (!lazy) {
            invMovementType.setOrgOrganisation(OrganisationMapper.toEntity(movementType.getOrganisation(), true));
        }
        return invMovementType;

    }

    public static List<MovementType> toDtos(List<InvMovementType> invMovementTypes, boolean lazy) {
        if (null == invMovementTypes) {
            return null;
        }
        List<MovementType> movementTypes = new ArrayList<>();
        for (InvMovementType invMovementType : invMovementTypes) {
            movementTypes.add(toDto(invMovementType, lazy));
        }
        return movementTypes;
    }

    public static List<MovementType> toDtos(Iterable<InvMovementType> invMovementTypes, boolean lazy) {
        if (null == invMovementTypes) {
            return null;
        }
        List<MovementType> movementTypes = new ArrayList<>();
        for (InvMovementType invMovementType : invMovementTypes) {
            movementTypes.add(toDto(invMovementType, lazy));
        }
        return movementTypes;
    }

    public static Set<InvMovementType> toEntities(Set<MovementType> movementTypes, boolean lazy) {
        if (null == movementTypes) {
            return null;
        }
        Set<InvMovementType> invMovementType = new HashSet<>();
        for (MovementType movementType : movementTypes) {
            invMovementType.add(toEntity(movementType, lazy));
        }
        return invMovementType;
    }

    public static Set<MovementType> toDtos(Set<InvMovementType> invMovementTypes, boolean lazy) {
        if (null == invMovementTypes) {
            return null;
        }
        Set<MovementType> movementTypes = new HashSet<>();
        for (InvMovementType invMovementType : invMovementTypes) {
            movementTypes.add(toDto(invMovementType, lazy));
        }
        return movementTypes;
    }

}
