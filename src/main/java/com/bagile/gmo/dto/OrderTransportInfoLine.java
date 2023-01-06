package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderTransportInfoLine {

	private long id;

	private OrderTransportType orderTransportType;
    private Account account;


	private AddressContactOrderTransportInfo addressContactDeliveryInfo;
	private BigDecimal numberOfPalletEnlevement ;
	private BigDecimal weightEnlevement ;
	private BigDecimal capacityEnlevement;
	private String  commentEnlevement;

	private Boolean contreBlEnlevement ;
	private Boolean contreFactureEnlevement;
	private PaymentType  paymentTypeEnlevement;


	private BigDecimal numberOfPalletLivraison ;

	private BigDecimal weightLivraison ;
	private BigDecimal capacityLivraison;
	private String  commentLivraison;
	private Boolean contreBlLivraison ;
	private Boolean contreFactureLivraison;
	private PaymentType  paymentTypeLivraison;
	private TurnStatus turnStatus;

	private Long lineNumber;
	private OrderTransportInfo orderTransportInfo;
	private Owner owner;


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

	public Boolean getContreFactureEnlevement() {
		return contreFactureEnlevement;
	}

	public void setContreFactureEnlevement(Boolean contreFactureEnlevement) {
		this.contreFactureEnlevement = contreFactureEnlevement;
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

	public AddressContactOrderTransportInfo getAddressContactDeliveryInfo() {
		return addressContactDeliveryInfo;
	}

	public void setAddressContactDeliveryInfo(AddressContactOrderTransportInfo addressContactDeliveryInfo) {
		this.addressContactDeliveryInfo = addressContactDeliveryInfo;
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
