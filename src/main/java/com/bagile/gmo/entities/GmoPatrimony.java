package com.bagile.gmo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gmo_patrimony")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @Column(name = "gmo_patrimonycode", unique = true, nullable = false, length = 90)
    public String getGmoPatrimonyCode() {
        return gmoPatrimonyCode;
    }

    public void setGmoPatrimonyCode(String gmoMachineCode) {
        this.gmoPatrimonyCode = gmoMachineCode;
    }
    private String gmoPatrimonyCode;



}
