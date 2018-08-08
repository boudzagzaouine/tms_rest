package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="tms_roadState",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_roadStateId"}))
public class TmsRoadState {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_roadStateId")
    private int tmsRoadStateId;

    @NotNull
    @Column(name = "tms_roadStatestate")
    private String tmsRoadStateState;

    @OneToMany(mappedBy = "tmsRoadRoadState")
    private Set<TmsRoad> tmsRoadRoads;


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
