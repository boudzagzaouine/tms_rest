package com.sinno.ems.dto;

import java.io.Serializable;

/**
 * Created by adadi on 2/12/2016.
 */
public class Column implements Serializable {
    private long id;
    private int position;
    private String name;
    private String classe;
    private Boolean visible;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
