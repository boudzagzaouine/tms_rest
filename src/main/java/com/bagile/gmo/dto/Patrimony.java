package com.bagile.gmo.dto;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Vehicle.class, name = "vehicle"),
})
@MappedSuperclass
public abstract class Patrimony extends EmsDto {

	private static final long serialVersionUID = 4830216181817746409L;

}
