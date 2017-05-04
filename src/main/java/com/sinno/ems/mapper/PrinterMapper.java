package com.sinno.ems.mapper;

import com.sinno.ems.dto.Printer;
import com.sinno.ems.entities.PrmPrinter;

import java.util.*;

/**
 * Created by Enissay on 03/08/2016.
 */
public class PrinterMapper {
    private PrinterMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmPrinterId");
        map.put("name", "prmPrinterName");
        map.put("description", "prmPrinterDescription");
        map.put("ip", "prmPrinterip");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Printer toDto(PrmPrinter prmPrinter, boolean lazy) {
        if (null == prmPrinter) {
            return null;
        }
        Printer printer = new Printer();
        printer.setId(prmPrinter.getPrmPrinterId());
        printer.setDescription(prmPrinter.getPrmPrinterDescription());
        printer.setName(prmPrinter.getPrmPrinterName());
        printer.setIp(prmPrinter.getPrmPrinterIp());
        return printer;
    }

    public static PrmPrinter toEntity(Printer printer, boolean lazy) {
        if (null == printer) {
            return null;
        }
        PrmPrinter prmPrinter = new PrmPrinter();
        prmPrinter.setPrmPrinterId(printer.getId());
        prmPrinter.setPrmPrinterName(printer.getName());
        prmPrinter.setPrmPrinterDescription(printer.getDescription());
        prmPrinter.setPrmPrinterIp(printer.getIp());
        return prmPrinter;
    }

    public static List<Printer> toDtos(List<PrmPrinter> prmPrinters, boolean lazy) {
        if (null == prmPrinters) {
            return null;
        }
        List<Printer> printers = new ArrayList<>();
        for (PrmPrinter prmPrinter : prmPrinters) {
            printers.add(toDto(prmPrinter, lazy));
        }
        return printers;
    }

    public static List<Printer> toDtos(Iterable<PrmPrinter> prmPrinters, boolean lazy) {
        if (null == prmPrinters) {
            return null;
        }
        List<Printer> printers = new ArrayList<>();
        for (PrmPrinter prmPrinter : prmPrinters) {
            printers.add(toDto(prmPrinter, lazy));
        }
        return printers;
    }

    public static Set<PrmPrinter> toEntities(Set<Printer> printers, boolean lazy) {
        if (null == printers) {
            return null;
        }
        Set<PrmPrinter> prmPrinters = new HashSet<>();
        for (Printer printer : printers) {
            prmPrinters.add(toEntity(printer, lazy));
        }
        return prmPrinters;
    }

    public static Set<Printer> toDtos(Set<PrmPrinter> prmPrinters, boolean lazy) {
        if (null == prmPrinters) {
            return null;
        }
        Set<Printer> printers = new HashSet<>();
        for (PrmPrinter prmPrinter : prmPrinters) {
            printers.add(toDto(prmPrinter, lazy));
        }
        return printers;
    }
}
