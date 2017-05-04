package com.sinno.ems.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ASMAE on 27/04/2016.
 */
public class StockException implements Serializable {

    private long id;
    private String reason;
    private Location locationOld;
    private Owner owner;
    private Date updateDateOld;
    private String variable1Old;
    private String variable2Old;
    private String variable3Old;
    private String variable4Old;
    private String variable5Old;
    private String variable6Old;
    private String variable7Old;
    private String variable8Old;
    private String variable9Old;
    private String variable10Old;
    private Date creationDateOld;
    private Date receptionDateOld;
    private Date creationDateNew;
    private Product productOld;
    private BlockType blockTypeOld;
    private Supplier supplierOld;
    private Color colorOld;
    private Date dlcOld;
    private Date dluoOld;
    private String serialNoOld;
    private String lotOld;
    private Container containerOld;
    private BigDecimal quantityOld;
    private BigDecimal quantityNew;
    private String qualityOld;
    private BigDecimal weightOld;
    private String qualityNew;
    private BigDecimal weightNew;
    private Uom uomOld;
    private Uom uomNew;
    private ProductDimension productDimensionOld;
    private ProductDimension productDimensionNew;
    private Boolean kitOld;
    private ReceptionLine receptionLineOld;

    private Exception exception;
    private String action;
    private User user;

/*    private Location locationNew;
    private Owner ownerNew;
    private Date updateDateNew;
    private String variable1New;
    private String variable2New;
    private String variable3New;
    private String variable4New;
    private String variable5New;
    private String variable6New;
    private String variable7New;
    private String variable8New;
    private String variable9New;
    private String variable10New;
    private Date creationDateNew;
    private Date receptionDateNew;
    private Product productNew;
    private BlockType blockTypeNew;
    private Supplier supplierNew;
    private Color colorNew;
    private Date dlcNew;
    private Date dluoNew;
    private String serialNoNew;
    private String lotNew;
    private Container containerNew;
    private BigDecimal quantityNew;
    private Uom uomNew;

    private Boolean kitNew;*/

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Location getLocationOld() {
        return this.locationOld;
    }

    public void setLocationOld(Location locationOld) {
        this.locationOld = locationOld;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getUpdateDateOld() {
        return this.updateDateOld;
    }

    public void setUpdateDateOld(Date updateDateOld) {
        this.updateDateOld = updateDateOld;
    }

    public String getVariable1Old() {
        return this.variable1Old;
    }

    public void setVariable1Old(String variable1Old) {
        this.variable1Old = variable1Old;
    }

    public String getVariable2Old() {
        return this.variable2Old;
    }

    public void setVariable2Old(String variable2Old) {
        this.variable2Old = variable2Old;
    }

    public String getVariable3Old() {
        return this.variable3Old;
    }

    public void setVariable3Old(String variable3Old) {
        this.variable3Old = variable3Old;
    }

    public String getVariable4Old() {
        return this.variable4Old;
    }

    public void setVariable4Old(String variable4Old) {
        this.variable4Old = variable4Old;
    }

    public String getVariable5Old() {
        return this.variable5Old;
    }

    public void setVariable5Old(String variable5Old) {
        this.variable5Old = variable5Old;
    }

    public String getVariable6Old() {
        return this.variable6Old;
    }

    public void setVariable6Old(String variable6Old) {
        this.variable6Old = variable6Old;
    }

    public String getVariable7Old() {
        return this.variable7Old;
    }

    public void setVariable7Old(String variable7Old) {
        this.variable7Old = variable7Old;
    }

    public String getVariable8Old() {
        return this.variable8Old;
    }

    public void setVariable8Old(String variable8Old) {
        this.variable8Old = variable8Old;
    }

    public String getVariable9Old() {
        return this.variable9Old;
    }

    public void setVariable9Old(String variable9Old) {
        this.variable9Old = variable9Old;
    }

    public String getVariable10Old() {
        return this.variable10Old;
    }

    public void setVariable10Old(String variable10Old) {
        this.variable10Old = variable10Old;
    }

    public Date getCreationDateOld() {
        return this.creationDateOld;
    }

    public void setCreationDateOld(Date creationDateOld) {
        this.creationDateOld = creationDateOld;
    }

    public Date getReceptionDateOld() {
        return this.receptionDateOld;
    }

    public void setReceptionDateOld(Date receptionDateOld) {
        this.receptionDateOld = receptionDateOld;
    }

    public Date getCreationDateNew() {
        return this.creationDateNew;
    }

    public void setCreationDateNew(Date creationDateNew) {
        this.creationDateNew = creationDateNew;
    }

    public Product getProductOld() {
        return this.productOld;
    }

    public void setProductOld(Product productOld) {
        this.productOld = productOld;
    }

    public BlockType getBlockTypeOld() {
        return this.blockTypeOld;
    }

    public void setBlockTypeOld(BlockType blockTypeOld) {
        this.blockTypeOld = blockTypeOld;
    }

    public Supplier getSupplierOld() {
        return this.supplierOld;
    }

    public void setSupplierOld(Supplier supplierOld) {
        this.supplierOld = supplierOld;
    }

    public Color getColorOld() {
        return this.colorOld;
    }

    public void setColorOld(Color colorOld) {
        this.colorOld = colorOld;
    }

    public Date getDlcOld() {
        return this.dlcOld;
    }

    public void setDlcOld(Date dlcOld) {
        this.dlcOld = dlcOld;
    }

    public Date getDluoOld() {
        return this.dluoOld;
    }

    public void setDluoOld(Date dluoOld) {
        this.dluoOld = dluoOld;
    }

    public String getSerialNoOld() {
        return this.serialNoOld;
    }

    public void setSerialNoOld(String serialNoOld) {
        this.serialNoOld = serialNoOld;
    }

    public String getLotOld() {
        return this.lotOld;
    }

    public void setLotOld(String lotOld) {
        this.lotOld = lotOld;
    }

    public Container getContainerOld() {
        return this.containerOld;
    }

    public void setContainerOld(Container containerOld) {
        this.containerOld = containerOld;
    }

    public BigDecimal getQuantityOld() {
        return this.quantityOld;
    }

    public void setQuantityOld(BigDecimal quantityOld) {
        this.quantityOld = quantityOld;
    }

    public BigDecimal getQuantityNew() {
        return this.quantityNew;
    }

    public void setQuantityNew(BigDecimal quantityNew) {
        this.quantityNew = quantityNew;
    }

    public Uom getUomOld() {
        return this.uomOld;
    }

    public void setUomOld(Uom uomOld) {
        this.uomOld = uomOld;
    }

    public Uom getUomNew() {
        return uomNew;
    }

    public void setUomNew(Uom uomNew) {
        this.uomNew = uomNew;
    }

    public Boolean getKitOld() {
        return this.kitOld;
    }

    public void setKitOld(Boolean kitOld) {
        this.kitOld = kitOld;
    }

    public ReceptionLine getReceptionLineOld() {
        return this.receptionLineOld;
    }

    public void setReceptionLineOld(ReceptionLine receptionLineOld) {
        this.receptionLineOld = receptionLineOld;
    }

    public String getQualityOld() {
        return qualityOld;
    }

    public void setQualityOld(String qualityOld) {
        this.qualityOld = qualityOld;
    }

    public BigDecimal getWeightOld() {
        return weightOld;
    }

    public void setWeightOld(BigDecimal weightOld) {
        this.weightOld = weightOld;
    }

    public String getQualityNew() {
        return qualityNew;
    }

    public void setQualityNew(String qualityNew) {
        this.qualityNew = qualityNew;
    }

    public BigDecimal getWeightNew() {
        return weightNew;
    }

    public void setWeightNew(BigDecimal weightNew) {
        this.weightNew = weightNew;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductDimension getProductDimensionOld() {
        return productDimensionOld;
    }

    public void setProductDimensionOld(ProductDimension productDimensionOld) {
        this.productDimensionOld = productDimensionOld;
    }

    public ProductDimension getProductDimensionNew() {
        return productDimensionNew;
    }

    public void setProductDimensionNew(ProductDimension productDimensionNew) {
        this.productDimensionNew = productDimensionNew;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            StockException obj = (StockException) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }
}
