package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderTransportInfoLine {

	private long id;

	private OrderTransportType orderTransportType;
    private Account account;

    private Address address;
	private Contact contact;
	//private AddressContactOrderTransportInfo addressContactDeliveryInfo;
	private BigDecimal numberOfPalletEnlevement ;
	private BigDecimal weightEnlevement ;
	private BigDecimal capacityEnlevement;
	private String  commentEnlevement;

	private Boolean contreBlEnlevement ;
	private Boolean contreFactureEnlevement;
	private PaymentType  paymentTypeEnlevement;
	private BigDecimal paymentAmountEnlevement;
	private Date dateEnlevement;


	private BigDecimal numberOfPalletLivraison ;

	private BigDecimal weightLivraison ;
	private BigDecimal capacityLivraison;
	private String  commentLivraison;
	private Boolean contreBlLivraison ;
	private Boolean contreFactureLivraison;
	private PaymentType  paymentTypeLivraison;
	private BigDecimal paymentAmountLivraison;
	private Date dateLivraison;

	private TurnStatus turnStatus;

	private Long lineNumber;
	private OrderTransportInfo orderTransportInfo;
	private Owner owner;
	private Date dateArriver;
	private Date dateCommancerChargement;
	private Date dateCommancerDechargement;
	private Date dateFinDechargement;
	private Date dateFinChargement;
	private Date closeDate;

	private BigDecimal priceHT;
	private Vat vat ;
	private BigDecimal priceTTC;
	private List<OrderTransportInfoLineDocument> orderTransportInfoLineDocuments = new ArrayList();

	private Date date; // local

	public Date getDateArriver() {
		return dateArriver;
	}

	public void setDateArriver(Date dateArriver) {
		this.dateArriver = dateArriver;
	}

	public Date getDateCommancerChargement() {
		return dateCommancerChargement;
	}

	public void setDateCommancerChargement(Date dateCommancerChargement) {
		this.dateCommancerChargement = dateCommancerChargement;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Date getDateCommancerDechargement() {
		return dateCommancerDechargement;
	}

	public void setDateCommancerDechargement(Date dateCommancerDechargement) {
		this.dateCommancerDechargement = dateCommancerDechargement;
	}

	public Date getDateFinDechargement() {
		return dateFinDechargement;
	}

	public void setDateFinDechargement(Date dateFinDechargement) {
		this.dateFinDechargement = dateFinDechargement;
	}

	public Date getDateFinChargement() {
		return dateFinChargement;
	}

	public void setDateFinChargement(Date dateFinChargement) {
		this.dateFinChargement = dateFinChargement;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public OrderTransportType getOrderTransportType() {
		return orderTransportType;
	}

	public void setOrderTransportType(OrderTransportType orderTransportType) {
		this.orderTransportType = orderTransportType;
	}

	public BigDecimal getPriceHT() {
		return priceHT;
	}

	public void setPriceHT(BigDecimal priceHT) {
		this.priceHT = priceHT;
	}

	public Vat getVat() {
		return vat;
	}

	public void setVat(Vat vat) {
		this.vat = vat;
	}

	public BigDecimal getPriceTTC() {
		return priceTTC;
	}

	public void setPriceTTC(BigDecimal priceTTC) {
		this.priceTTC = priceTTC;
	}

	public TurnStatus getTurnStatus() {
		return turnStatus;
	}

	public void setTurnStatus(TurnStatus turnStatus) {
		this.turnStatus = turnStatus;
	}

	public Boolean getContreBlEnlevement() {
		return contreBlEnlevement;
	}

	public void setContreBlEnlevement(Boolean contreBlEnlevement) {
		this.contreBlEnlevement = contreBlEnlevement;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Boolean getContreFactureEnlevement() {
		return contreFactureEnlevement;
	}

	public void setContreFactureEnlevement(Boolean contreFactureEnlevement) {
		this.contreFactureEnlevement = contreFactureEnlevement;
	}

	public List<OrderTransportInfoLineDocument> getOrderTransportInfoLineDocuments() {
		return orderTransportInfoLineDocuments;
	}

	public void setOrderTransportInfoLineDocuments(List<OrderTransportInfoLineDocument> orderTransportInfoLineDocuments) {
		this.orderTransportInfoLineDocuments = orderTransportInfoLineDocuments;
	}

	public Date getDateEnlevement() {
		return dateEnlevement;
	}

	public void setDateEnlevement(Date dateEnlevement) {
		this.dateEnlevement = dateEnlevement;
	}

	public BigDecimal getPaymentAmountEnlevement() {
		return paymentAmountEnlevement;
	}

	public void setPaymentAmountEnlevement(BigDecimal paymentAmountEnlevement) {
		this.paymentAmountEnlevement = paymentAmountEnlevement;
	}

	public BigDecimal getPaymentAmountLivraison() {
		return paymentAmountLivraison;
	}

	public void setPaymentAmountLivraison(BigDecimal paymentAmountLivraison) {
		this.paymentAmountLivraison = paymentAmountLivraison;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public PaymentType getPaymentTypeEnlevement() {
		return paymentTypeEnlevement;
	}

	public void setPaymentTypeEnlevement(PaymentType paymentTypeEnlevement) {
		this.paymentTypeEnlevement = paymentTypeEnlevement;
	}

	public Boolean getContreBlLivraison() {
		return contreBlLivraison;
	}

	public void setContreBlLivraison(Boolean contreBlLivraison) {
		this.contreBlLivraison = contreBlLivraison;
	}

	public Boolean getContreFactureLivraison() {
		return contreFactureLivraison;
	}

	public void setContreFactureLivraison(Boolean contreFactureLivraison) {
		this.contreFactureLivraison = contreFactureLivraison;
	}

	public PaymentType getPaymentTypeLivraison() {
		return paymentTypeLivraison;
	}

	public void setPaymentTypeLivraison(PaymentType paymentTypeLivraison) {
		this.paymentTypeLivraison = paymentTypeLivraison;
	}
/*
public AddressContactOrderTransportInfo getAddressContactDeliveryInfo() {
		return addressContactDeliveryInfo;
	}

	public void setAddressContactDeliveryInfo(AddressContactOrderTransportInfo addressContactDeliveryInfo) {
		this.addressContactDeliveryInfo = addressContactDeliveryInfo;
	}*/

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public BigDecimal getWeightEnlevement() {
		return weightEnlevement;
	}

	public void setWeightEnlevement(BigDecimal weightEnlevement) {
		this.weightEnlevement = weightEnlevement;
	}

	public BigDecimal getCapacityEnlevement() {
		return capacityEnlevement;
	}

	public void setCapacityEnlevement(BigDecimal capacityEnlevement) {
		this.capacityEnlevement = capacityEnlevement;
	}

	public BigDecimal getNumberOfPalletEnlevement() {
		return numberOfPalletEnlevement;
	}

	public void setNumberOfPalletEnlevement(BigDecimal numberOfPalletEnlevement) {
		this.numberOfPalletEnlevement = numberOfPalletEnlevement;
	}

	public BigDecimal getNumberOfPalletLivraison() {
		return numberOfPalletLivraison;
	}

	public void setNumberOfPalletLivraison(BigDecimal numberOfPalletLivraison) {
		this.numberOfPalletLivraison = numberOfPalletLivraison;
	}

	public OrderTransportInfo getOrderTransportInfo() {
		return orderTransportInfo;
	}

	public void setOrderTransportInfo(OrderTransportInfo orderTransportInfo) {
		this.orderTransportInfo = orderTransportInfo;
	}

	public String getCommentEnlevement() {
		return commentEnlevement;
	}

	public void setCommentEnlevement(String commentEnlevement) {
		this.commentEnlevement = commentEnlevement;
	}



	public BigDecimal getWeightLivraison() {
		return weightLivraison;
	}

	public void setWeightLivraison(BigDecimal weightLivraison) {
		this.weightLivraison = weightLivraison;
	}

	public BigDecimal getCapacityLivraison() {
		return capacityLivraison;
	}

	public void setCapacityLivraison(BigDecimal capacityLivraison) {
		this.capacityLivraison = capacityLivraison;
	}

	public String getCommentLivraison() {
		return commentLivraison;
	}

	public void setCommentLivraison(String commentLivraison) {
		this.commentLivraison = commentLivraison;
	}

	public Long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderTransportInfoLine that = (OrderTransportInfoLine) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




}
