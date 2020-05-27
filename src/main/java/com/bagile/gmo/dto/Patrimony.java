package com.bagile.gmo.dto;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "patrimony_type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Vehicle.class, name = "vehicule"),
		@JsonSubTypes.Type(value = Machine.class, name = "machine"),

})
//@MappedSuperclass
public abstract class Patrimony extends EmsDto {

	private static final long serialVersionUID = 4830216181817746409L;


	private long id ;
	private String Code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}
}
