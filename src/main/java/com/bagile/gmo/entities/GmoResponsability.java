package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_responsability")
public class GmoResponsability extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private long gmoResponsabilityId;
    private String gmoResponsabilityCode;
    private String gmoResponsabilityDescription;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_responsability_id", allocationSize = 1)
    @Column(name = "gmo_responsabilityid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoResponsabilityId() {
        return gmoResponsabilityId;
    }

    public void setGmoResponsabilityId(long gmoResponsabilityId) {
        this.gmoResponsabilityId = gmoResponsabilityId;
    }

    @Column(name = "gmo_responsabilitycode", unique = true, nullable = false, length = 90)
    public String getGmoResponsabilityCode() {
        return gmoResponsabilityCode;
    }

    public void setGmoResponsabilityCode(String gmoResponsabilityCode) {
        this.gmoResponsabilityCode = gmoResponsabilityCode;
    }

    @Column(name = "gmo_responsabilitydescription")
    public String getGmoResponsabilityDescription() {
        return gmoResponsabilityDescription;
    }

    public void setGmoResponsabilityDescription(String gmoResponsabilityDescription) {
        this.gmoResponsabilityDescription = gmoResponsabilityDescription;
    }

  
}
