package com.sinno.ems.dto;

/**
 * Created by Enissay on 15/12/2016.
 */
public class PaymentAccountInvoice {
    private long id;
    private PaymentAccount paymentAccount;
    private AccountInvoice accountInvoice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public AccountInvoice getAccountInvoice() {
        return accountInvoice;
    }

    public void setAccountInvoice(AccountInvoice accountInvoice) {
        this.accountInvoice = accountInvoice;
    }
}
