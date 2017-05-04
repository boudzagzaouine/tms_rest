package com.sinno.ems.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Enissay on 28/11/2016.
 */
@Embeddable
public class EmsLicenceId implements Serializable {
    private String account;
    private String module;


    @Column(name = "ems_account")
    public String getAccount() {
        return account;
    }
    public void setModule(String module) {
        this.module = module;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    @Column(name = "ems_module")
    public String getModule() {
        return module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmsLicenceId)) return false;
        EmsLicenceId that = (EmsLicenceId) o;
        return Objects.equals(account, that.account) &&
                Objects.equals(module, that.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, module);
    }
}