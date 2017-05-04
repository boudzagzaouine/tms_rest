package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Enissay on 03/08/2016.
 */
@Entity
@Table(name = "prm_printer")

public class PrmPrinter implements Serializable {
    private long prmPrinterId;
    @Size(max = 50)
    private String prmPrinterName;
    @Size(max = 255)
    private String prmPrinterDescription;
    @Size(max = 15)
    private String prmPrinterIp;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_printer", allocationSize = 1)
    @Column(name = "prm_printerid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmPrinterId() {
        return prmPrinterId;
    }

    public void setPrmPrinterId(long prmPrinterId) {
        this.prmPrinterId = prmPrinterId;
    }

    @Column(name = "prm_printername", length = 50)
    public String getPrmPrinterName() {
        return prmPrinterName;
    }

    public void setPrmPrinterName(String prmPrinterName) {
        this.prmPrinterName = prmPrinterName;
    }

    @Column(name = "prm_printerdescription", length = 255)

    public String getPrmPrinterDescription() {
        return prmPrinterDescription;
    }

    public void setPrmPrinterDescription(String prmPrinterDescription) {
        this.prmPrinterDescription = prmPrinterDescription;
    }

    @Column(name = "prm_printerip", length = 15)

    public String getPrmPrinterIp() {
        return prmPrinterIp;
    }

    public void setPrmPrinterIp(String prmPrinterIp) {
        this.prmPrinterIp = prmPrinterIp;
    }
}
