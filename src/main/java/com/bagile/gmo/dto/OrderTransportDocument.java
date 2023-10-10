package com.bagile.gmo.dto;

public class OrderTransportDocument {
    private long id;
    private byte[] file;
    private String fileName;
    private String fileType;
    private String filePath;



    private  OrderTransportInfoLineDocument orderTransportInfoLineDocument;

    public OrderTransportInfoLineDocument getOrderTransportInfoLineDocument() {
        return orderTransportInfoLineDocument;
    }

    public void setOrderTransportInfoLineDocument(OrderTransportInfoLineDocument orderTransportInfoLineDocument) {
        this.orderTransportInfoLineDocument = orderTransportInfoLineDocument;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String fileName) {
        this.filePath = fileName;
    }
}
