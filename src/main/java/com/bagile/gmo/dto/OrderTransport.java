package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderTransport {

	private long id;
	private String code;
	private String description;

	private  PackagingType packagingType;
	private Boolean consignment;
	private String port; // payé  , du
	private String palletResponsibility ; //true prestataire /false client
    private MarchandiseType marchandiseType;
	private Date date ;
	private TurnType turnType;
	private LoadingType  loadingType ;
	private Account account;
	private Contact contact;
	private TurnStatus turnStatus;
	private VehicleCategory vehicleCategory ;
	private VehicleTray vehicleTray;

	private Trajet trajet;
	//private OrderTransportInfo orderTransportInfoAller;
	//private OrderTransportInfo orderTransportInfoRetour;

	private BigDecimal priceHT;
	private Vat vat;
	private BigDecimal priceTTC;
	private BigDecimal priceVat;

	private BigDecimal marginRate ;
	private BigDecimal marginValue ;

	private BigDecimal totalPriceHT;
	private BigDecimal totalPriceVat;
	private BigDecimal totalPriceTTC;

	private Owner owner;
	private List<TransportPlanServiceCatalog> orderTransportServiceCatalogs = new ArrayList<>();
	private List<OrderTransportAccompaniment> orderTransportAccompaniments = new ArrayList<>();


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotalPriceHT() {
		return totalPriceHT;
	}

	public void setTotalPriceHT(BigDecimal totalPriceHT) {
		this.totalPriceHT = totalPriceHT;
	}

	public BigDecimal getTotalPriceVat() {
		return totalPriceVat;
	}

	public void setTotalPriceVat(BigDecimal totalPriceVat) {
		this.totalPriceVat = totalPriceVat;
	}

	public BigDecimal getTotalPriceTTC() {
		return totalPriceTTC;
	}

	public void setTotalPriceTTC(BigDecimal totalPriceTTC) {
		this.totalPriceTTC = totalPriceTTC;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public PackagingType getPackagingType() {
		return packagingType;
	}

	public List<TransportPlanServiceCatalog> getOrderTransportServiceCatalogs() {
		return orderTransportServiceCatalogs;
	}

	public void setOrderTransportServiceCatalogs(List<TransportPlanServiceCatalog> orderTransportServiceCatalogs) {
		this.orderTransportServiceCatalogs = orderTransportServiceCatalogs;
	}

	public void setPackagingType(PackagingType packagingType) {
		this.packagingType = packagingType;
	}

	public Boolean getConsignment() {
		return consignment;
	}

	public void setConsignment(Boolean consignment) {
		this.consignment = consignment;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public List<OrderTransportAccompaniment> getOrderTransportAccompaniments() {
		return orderTransportAccompaniments;
	}

	public void setOrderTransportAccompaniments(List<OrderTransportAccompaniment> orderTransportAccompaniments) {
		this.orderTransportAccompaniments = orderTransportAccompaniments;
	}

	public String getPalletResponsibility() {
		return palletResponsibility;
	}

	public void setPalletResponsibility(String palletResponsibility) {
		this.palletResponsibility = palletResponsibility;
	}

	public MarchandiseType getMarchandiseType() {
		return marchandiseType;
	}

	public void setMarchandiseType(MarchandiseType marchandiseType) {
		this.marchandiseType = marchandiseType;
	}

	public TurnType getTurnType() {
		return turnType;
	}

	public void setTurnType(TurnType turnType) {
		this.turnType = turnType;
	}

	public LoadingType getLoadingType() {
		return loadingType;
	}

	public void setLoadingType(LoadingType loadingType) {
		this.loadingType = loadingType;
	}

	public BigDecimal getPriceVat() {
		return priceVat;
	}

	public void setPriceVat(BigDecimal priceVat) {
		this.priceVat = priceVat;
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

	public VehicleTray getVehicleTray() {
		return vehicleTray;
	}

	public void setVehicleTray(VehicleTray vehicleTray) {
		this.vehicleTray = vehicleTray;
	}

	public BigDecimal getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(BigDecimal marginRate) {
		this.marginRate = marginRate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public BigDecimal getMarginValue() {
		return marginValue;
	}

	public void setMarginValue(BigDecimal marginValue) {
		this.marginValue = marginValue;
	}

	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}

	public BigDecimal getPriceHT() {
		return priceHT;
	}

	public void setPriceHT(BigDecimal priceHT) {
		this.priceHT = priceHT;
	}

	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public TurnStatus getTurnStatus() {
		return turnStatus;
	}

	public void setTurnStatus(TurnStatus turnStatus) {
		this.turnStatus = turnStatus;
	}

//	public OrderTransportInfo getOrderTransportInfoAller() {
//		return orderTransportInfoAller;
//	}
//
//	public void setOrderTransportInfoAller(OrderTransportInfo orderTransportInfoAller) {
//		this.orderTransportInfoAller = orderTransportInfoAller;
//	}
//
//	public OrderTransportInfo getOrderTransportInfoRetour() {
//		return orderTransportInfoRetour;
//	}
//
//	public void setOrderTransportInfoRetour(OrderTransportInfo orderTransportInfoRetour) {
//		this.orderTransportInfoRetour = orderTransportInfoRetour;
//	}

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
		OrderTransport that = (OrderTransport) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
