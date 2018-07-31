package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class RoadState {
    private int idRoadState;
    @NotNull
    private String State;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_RoadStateid", unique = true, nullable = false, precision = 10, scale = 0)

    public int getIdRoadState() {
        return idRoadState;
    }

    public void setIdRoadState(int idRoadState) {
        this.idRoadState = idRoadState;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
