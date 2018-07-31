package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class TmsRoadState {
    private int tmsRoadStateId;
    @NotNull
    private String tmsRoadStateState;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_RoadStateid", unique = true, nullable = false, precision = 10, scale = 0)

    public int getTmsRoadStateId() {
        return tmsRoadStateId;
    }

    public void setTmsRoadStateId(int tmsRoadStateId) {
        this.tmsRoadStateId = tmsRoadStateId;
    }

    public String getTmsRoadStateState() {
        return tmsRoadStateState;
    }

    public void setTmsRoadStateState(String tmsRoadStateState) {
        this.tmsRoadStateState = tmsRoadStateState;
    }
}
