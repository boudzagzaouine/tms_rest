package com.bagile.gmo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTransportInfoLineDocument {

	private long id;
	private String contreType  ; // BL ou FACTURE
	private long type ; // 1 Enlevement . 2 Livraison
	private String numero;
	private OrderTransportDocumentType orderTransportDocumentType;
//	private byte[] file;
//	private String fileType;
//	private String fileName;
	private Date date;
	private OrderTransportInfoLine orderTransportInfoLine;

	private List<OrderTransportDocument> orderTransportDocumentList = new ArrayList<>();
 private Owner owner;
 private int  documentStatus;


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

	public OrderTransportDocumentType getOrderTransportDocumentType() {
		return orderTransportDocumentType;
	}

	public void setOrderTransportDocumentType(OrderTransportDocumentType orderTransportDocumentType) {
		this.orderTransportDocumentType = orderTransportDocumentType;
	}

	public List<OrderTransportDocument> getOrderTransportDocumentList() {
		return orderTransportDocumentList;
	}

	public void setOrderTransportDocumentList(List<OrderTransportDocument> orderTransportDocumentList) {
		this.orderTransportDocumentList = orderTransportDocumentList;
	}

	public int getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(int documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

//	public byte[] getFile() {
//		return file;
//	}
//
//	public void setFile(byte[] file) {
//		this.file = file;
//	}
//
//	public String getFileName() {
//		return fileName;
//	}
//
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}

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

//	public String getFileType() {
//		return fileType;
//	}
//
//	public void setFileType(String fileType) {
//		this.fileType = fileType;
//	}

	public OrderTransportInfoLine getOrderTransportInfoLine() {
		return orderTransportInfoLine;
	}

	public void setOrderTransportInfoLine(OrderTransportInfoLine orderTransportInfoLine) {
		this.orderTransportInfoLine = orderTransportInfoLine;
	}
}
