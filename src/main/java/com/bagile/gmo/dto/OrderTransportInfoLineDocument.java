package com.bagile.gmo.dto;

import java.util.Date;

public class OrderTransportInfoLineDocument {

	private long id;
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
