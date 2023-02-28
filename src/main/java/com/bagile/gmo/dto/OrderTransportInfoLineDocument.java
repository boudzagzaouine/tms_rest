package com.bagile.gmo.dto;

import java.util.Date;

public class OrderTransportInfoLineDocument {

	private long id;
	private String contreType  ; // BL ou FACTURE
	private long type ; // 1 Enlevement . 2 Livraison . 3 Enlevement/Livraison
	private String numero;
	private byte[] file;
	private String fileType;
	private String fileName;
	private Date date;
	private OrderTransportInfoLine orderTransportInfoLine;

 private Owner owner;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getContreType() {
		return contreType;
	}

	public void setContreType(String contreType) {
		this.contreType = contreType;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public OrderTransportInfoLine getOrderTransportInfoLine() {
		return orderTransportInfoLine;
	}

	public void setOrderTransportInfoLine(OrderTransportInfoLine orderTransportInfoLine) {
		this.orderTransportInfoLine = orderTransportInfoLine;
	}
}
