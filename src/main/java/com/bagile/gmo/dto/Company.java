package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Company extends EmsDto implements Serializable {

    private static final long serialVersionUID = -7535874800230967001L;

    private long id;
    private Owner owner;
    private String comment;
    private String name;
    private String code;
    private Date updateDate;
    private String variable1;
    private String variable2;
    private String variable3;
    private String variable4;
    private String variable5;
    private String variable6;
    private String variable7;
    private String variable8;
    private String variable9;
    private String variable10;
    private String siret;
    private Date creationDate;
    private Set<Account> accounts;
    private Address address;
    private String commonIdentifierOfCompany; //ice
    private String fiscalIdentifier; // IF
    private String professionalTax;
    private String tradeRegister;
    private String cnssNumber;
    private Boolean syncWms=false;
    private byte[] image;
    private String commercialCourt;
    private ActivityArea activityArea;
    private String telephone;
    private BigDecimal threshold; //seuil
    private String classificationFiscale;
    private String webSite;
    private String email;
    private String patent;

    private BigDecimal turnover; //chiffre affr
    private String fax;

    private List<AccountPricing> accountPricingList = new ArrayList<>();
    private List<AccountService> accountServiceList = new ArrayList<>();

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getVariable1() {
        return this.variable1;
    }

    public void setVariable1(String variable1) {
        this.variable1 = variable1;
    }

    public String getVariable2() {
        return this.variable2;
    }

    public void setVariable2(String variable2) {
        this.variable2 = variable2;
    }

    public String getVariable3() {
        return this.variable3;
    }

    public void setVariable3(String variable3) {
        this.variable3 = variable3;
    }

    public String getVariable4() {
        return this.variable4;
    }

    public void setVariable4(String variable4) {
        this.variable4 = variable4;
    }

    public String getVariable5() {
        return this.variable5;
    }

    public void setVariable5(String variable5) {
        this.variable5 = variable5;
    }

    public String getVariable6() {
        return this.variable6;
    }

    public void setVariable6(String variable6) {
        this.variable6 = variable6;
    }

    public String getVariable7() {
        return this.variable7;
    }

    public void setVariable7(String variable7) {
        this.variable7 = variable7;
    }

    public String getVariable8() {
        return this.variable8;
    }

    public void setVariable8(String variable8) {
        this.variable8 = variable8;
    }

    public String getVariable9() {
        return this.variable9;
    }

    public void setVariable9(String variable9) {
        this.variable9 = variable9;
    }

    public String getVariable10() {
        return this.variable10;
    }

    public void setVariable10(String variable10) {
        this.variable10 = variable10;
    }

    public String getSiret() {
        return this.siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<AccountPricing> getAccountPricingList() {
        return accountPricingList;
    }

    public void setAccountPricingList(List<AccountPricing> accountPricingList) {
        this.accountPricingList = accountPricingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonIdentifierOfCompany() {
        return commonIdentifierOfCompany;
    }

    public void setCommonIdentifierOfCompany(String commonIdentifierOfCompany) {
        this.commonIdentifierOfCompany = commonIdentifierOfCompany;
    }

    public String getFiscalIdentifier() {
        return fiscalIdentifier;
    }

    public void setFiscalIdentifier(String fiscalIdentifier) {
        this.fiscalIdentifier = fiscalIdentifier;
    }

    public String getProfessionalTax() {
        return professionalTax;
    }

    public void setProfessionalTax(String professionalTax) {
        this.professionalTax = professionalTax;
    }

    public String getCnssNumber() {
        return cnssNumber;
    }

    public void setCnssNumber(String cnssNumber) {
        this.cnssNumber = cnssNumber;
    }

    public String getTradeRegister() {
        return tradeRegister;
    }

    public void setTradeRegister(String tradeRegister) {
        this.tradeRegister = tradeRegister;
    }

    /**
     * @return the accounts
     */
    public Set<Account> getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Boolean getSyncWms() {
        return syncWms;
    }

    public void setSyncWms(Boolean syncWms) {
        this.syncWms = syncWms;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCommercialCourt() {
        return commercialCourt;
    }

    public void setCommercialCourt(String commercialCourt) {
        this.commercialCourt = commercialCourt;
    }

    public ActivityArea getActivityArea() {
        return activityArea;
    }

    public void setActivityArea(ActivityArea activityArea) {
        this.activityArea = activityArea;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

    public String getClassificationFiscale() {
        return classificationFiscale;
    }

    public void setClassificationFiscale(String classificationFiscale) {
        this.classificationFiscale = classificationFiscale;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public List<AccountService> getAccountServiceList() {
        return accountServiceList;
    }

    public void setAccountServiceList(List<AccountService> accountServiceList) {
        this.accountServiceList = accountServiceList;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Company obj = (Company) object;
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