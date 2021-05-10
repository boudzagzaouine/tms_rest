package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="gmo_pump")
public class GmoPump extends EmsEntity{

    private Long gmoPumpId;
    private String gmoPumpCode;
    private String gmoPumpDescription;
    private BigDecimal gmoPumpCapacity;
  

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_pump_id", allocationSize = 1)
    @Column(name = "gmo_pumpid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoPumpId() {
        return gmoPumpId;
    }

    public void setGmoPumpId(Long gmoPumpId) {
        this.gmoPumpId = gmoPumpId;
    }

    @Column(name = "gmo_pumpcode", unique = true, nullable = false, length = 90)
    public String getGmoPumpCode() {
        return gmoPumpCode;
    }

    public void setGmoPumpCode(String gmoPumpCode) {
        this.gmoPumpCode = gmoPumpCode;
    }

    @Column(name = "gmo_pumpdescription")
    public String getGmoPumpDescription() {
        return gmoPumpDescription;
    }

    public void setGmoPumpDescription(String gmoPumpDescription) {
        this.gmoPumpDescription = gmoPumpDescription;
    }

    @Column(name = "gmo_pumpcapacity")
    public BigDecimal getGmoPumpCapacity() {
        return gmoPumpCapacity;
    }

    public void setGmoPumpCapacity(BigDecimal gmoPumpQuantity) {
        this.gmoPumpCapacity = gmoPumpQuantity;
    }
}
