package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="gmo_alimentationPump")
public class GmoAlimentationPump extends EmsEntity{

    private Long gmoAlimentationPumpId;
    private String gmoAlimentationPumpCode;
    private GmoFuelPump gmoFuelPump;
    private BigDecimal gmoAlimentationQuantity;
    private Date gmoAlimentationPumpdate;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_alimentationpump_id", allocationSize = 1)
    @Column(name = "gmo_alimentationpumpid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoAlimentationPumpId() {
        return gmoAlimentationPumpId;
    }

    public void setGmoAlimentationPumpId(Long gmoAlimentationPumpId) {
        this.gmoAlimentationPumpId = gmoAlimentationPumpId;
    }

    @Column(name = "gmo_alimentationpumpcode", unique = true, nullable = false, length = 90)
    public String getGmoAlimentationPumpCode() {
        return gmoAlimentationPumpCode;
    }

    public void setGmoAlimentationPumpCode(String gmoAlimentationPumpCode) {
        this.gmoAlimentationPumpCode = gmoAlimentationPumpCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_fuelpumpid", nullable = false)
    public GmoFuelPump getGmoFuelPump() {
        return gmoFuelPump;
    }

    public void setGmoFuelPump(GmoFuelPump gmoFuelPump) {
        this.gmoFuelPump = gmoFuelPump;
    }



    @Column(name = "gmo_alimentationpumpquantity")
    public BigDecimal getGmoAlimentationQuantity() {
        return gmoAlimentationQuantity;
    }

    public void setGmoAlimentationQuantity(BigDecimal gmoAlimentationquantity) {
        this.gmoAlimentationQuantity = gmoAlimentationquantity;
    }

    @Column(name = "gmo_alimentationpumpdate")
    public Date getGmoAlimentationPumpdate() {
        return gmoAlimentationPumpdate;
    }

    public void setGmoAlimentationPumpdate(Date gmoAlimentationPumpdate) {
        this.gmoAlimentationPumpdate = gmoAlimentationPumpdate;
    }
}
