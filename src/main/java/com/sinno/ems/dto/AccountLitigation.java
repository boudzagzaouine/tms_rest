package com.sinno.ems.dto;

import com.sinno.ems.entities.CmdAccount;
import com.sinno.ems.entities.InvAccountInvoice;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 03/12/2016.
 */
public class AccountLitigation {
    private long id;
    private BigDecimal amount;
    private Date creationDate;
    private Date updateDate;
    private AccountInvoice accountInvoice;
    private String objet;
    private String comment;
    private Account account;
    private Currency currency;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public AccountInvoice getAccountInvoice() {
        return accountInvoice;
    }

    public void setAccountInvoice(AccountInvoice accountInvoice) {
        this.accountInvoice = accountInvoice;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
