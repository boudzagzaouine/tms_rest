package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "gmo_patrimony")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GmoPatrimony extends EmsEntity {


    private Long gmoPatrimonyId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_patrimony_id", allocationSize = 1)
    @Column(name = "gmo_patrimonyid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoPatrimonyId() {
        return gmoPatrimonyId;
    }

    public void setGmoPatrimonyId(Long gmoPatrimonyId) {
        this.gmoPatrimonyId = gmoPatrimonyId;
    }


}
