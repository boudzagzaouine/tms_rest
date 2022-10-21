package com.bagile.gmo.entities;

import com.bagile.gmo.entities.EmsEntity;
import com.bagile.gmo.entities.OwnOwner;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_turnstatus")
public class TmsTurnStatus extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTurnStatusId;
    private String tmsTurnStatusCode;
    private String tmsTurnStatusDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_turn_status_id", allocationSize = 1)
    @Column(name = "tms_turnstatusid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTurnStatusId() {
        return tmsTurnStatusId;
    }

    public void setTmsTurnStatusId(Long tmsTurnStatusId) {
        this.tmsTurnStatusId = tmsTurnStatusId;
    }

    @Column(name = "tms_turnstatuscode", unique = true, nullable = false, length = 90)
    public String getTmsTurnStatusCode() {
        return tmsTurnStatusCode;
    }

    public void setTmsTurnStatusCode(String tmsTurnStatusCode) {
        this.tmsTurnStatusCode = tmsTurnStatusCode;
    }

    @Column(name = "tms_turnstatusdescription")
    public String getTmsTurnStatusDescription() {
        return tmsTurnStatusDescription;
    }

    public void setTmsTurnStatusDescription(String tmsTurnStatusDescription) {
        this.tmsTurnStatusDescription = tmsTurnStatusDescription;
    }



    @ManyToOne
    @JoinColumn(name = "tms_turnstatusownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

   
}
