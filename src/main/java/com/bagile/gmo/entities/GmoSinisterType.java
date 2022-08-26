package com.bagile.gmo.entities;

import com.bagile.gmo.dto.Driver;
import com.bagile.gmo.dto.SinisterType;
import com.bagile.gmo.dto.Supplier;
import com.bagile.gmo.dto.Vehicle;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gmo_sinistertype")
public class GmoSinisterType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoSinisterTypeId;
    private String gmoSinisterTypeCode;
    private String gmoSinisterTypeDescription;


    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_sinister_type_id", allocationSize = 1)
    @Column(name = "gmo_sinistertypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoSinisterTypeId() {
        return gmoSinisterTypeId;
    }

    public void setGmoSinisterTypeId(Long gmoSinisterTypeId) {
        this.gmoSinisterTypeId = gmoSinisterTypeId;
    }

    @Column(name = "gmo_sinistertypecode", unique = true, nullable = false, length = 90)
    public String getGmoSinisterTypeCode() {
        return gmoSinisterTypeCode;
    }

    public void setGmoSinisterTypeCode(String gmoSinisterTypeCode) {
        this.gmoSinisterTypeCode = gmoSinisterTypeCode;
    }

    @Column(name = "gmo_sinistertypedescription")
    public String getGmoSinisterTypeDescription() {
        return gmoSinisterTypeDescription;
    }

    public void setGmoSinisterTypeDescription(String gmoSinisterTypeDescription) {
        this.gmoSinisterTypeDescription = gmoSinisterTypeDescription;
    }



    @ManyToOne
    @JoinColumn(name = "gmo_notificationtypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }


}
