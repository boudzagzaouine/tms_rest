package com.bagile.gmo.dto;

import java.util.ArrayList;
import java.util.List;

public class  ActionType {

	private long id;
	private String code;
	private String description;
 private Owner owner;
	private List<ActionTypeRepair> actionTypeRepairs= new ArrayList<>();


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<ActionTypeRepair> getActionTypeRepairs() {
		return actionTypeRepairs;
	}

	public void setActionTypeRepairs(List<ActionTypeRepair> actionTypeRepairs) {
		this.actionTypeRepairs = actionTypeRepairs;
	}
}
