package com.bagile.gmo.dto;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceLineRef extends EmsDto {

	private static final long serialVersionUID = -2523885174048641991L;

	private long id;
	private String code;
	private List<ActionType> actions = new ArrayList<>();
	private String description;

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

	public List<ActionType> getActions() {
		return actions;
	}

	public void setActions(List<ActionType> actions) {
		this.actions = actions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    
}
