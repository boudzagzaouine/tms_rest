/**
 *
 */
package com.bagile.tms.mapper;

import com.bagile.tms.dto.Account;
import com.bagile.tms.entities.CmdAccount;

import java.util.*;


/**
 * @author aelguezzar
 */
public class AccountMapper {
    private AccountMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdAccountId");
        map.put("company", "cmdCompany");
        map.put("owner", "ownOwner");
        map.put("addressByAccountDeliveryAddress", "adrAddressByCmdAccountDeliveryAddressId");
        map.put("transport", "trpTransport");
        map.put("code", "cmdAccountCode");
        map.put("comment", "cmdAccountComment");
        map.put("terms", "cmdAccountTerms");
        map.put("active", "cmdAccountIsActive");
        map.put("creationDate", "cmdAccountCreationDate");
        map.put("updateDate", "cmdAccountUpdateDate");
        map.put("variable1", "cmdAccountVariable1");
        map.put("variable2", "cmdAccountVariable2");
        map.put("variable3", "cmdAccountVariable3");
        map.put("variable4", "cmdAccountVariable4");
        map.put("variable5", "cmdAccountVariable5");
        map.put("variable6", "cmdAccountVariable6");
        map.put("variable7", "cmdAccountVariable7");
        map.put("variable8", "cmdAccountVariable8");
        map.put("variable9", "cmdAccountVariable9");
        map.put("variable10", "cmdAccountVariable10");
        map.put("contact", "cmdAccountContact");
        map.put("description", "cmdAccountDescription");
        map.put("name", "cmdAccountName");
        map.put("password", "cmdAccountPassword");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Account toDto(CmdAccount cmdAccount, boolean lazy) {
        if (null == cmdAccount) {
            return null;
        }
        Account account = new Account();
        account.setCode(cmdAccount.getCmdAccountCode());
        account.setComment(cmdAccount.getCmdAccountComment());
        account.setCreationDate(cmdAccount.getCmdAccountCreationDate());
        account.setId(cmdAccount.getCmdAccountId());
        account.setActive(cmdAccount.getCmdAccountIsActive());
        account.setUpdateDate(cmdAccount.getCmdAccountUpdateDate());
        account.setTerms(cmdAccount.getCmdAccountTerms());
        account.setVariable1(cmdAccount.getCmdAccountVariable1());
        account.setVariable2(cmdAccount.getCmdAccountVariable2());
        account.setVariable3(cmdAccount.getCmdAccountVariable3());
        account.setVariable4(cmdAccount.getCmdAccountVariable4());
        account.setVariable5(cmdAccount.getCmdAccountVariable5());
        account.setVariable6(cmdAccount.getCmdAccountVariable6());
        account.setVariable7(cmdAccount.getCmdAccountVariable7());
        account.setVariable8(cmdAccount.getCmdAccountVariable8());
        account.setVariable9(cmdAccount.getCmdAccountVariable9());
        account.setVariable10(cmdAccount.getCmdAccountVariable10());
        account.setDescription(cmdAccount.getCmdAccountDescription());
        account.setName(cmdAccount.getCmdAccountName());
        account.setPassword(cmdAccount.getCmdAccountPassword());
        if (!lazy) {
            account.setCompany(CompanyMapper.toDto(cmdAccount.getCmdCompany(), true));
            account.setOwner(OwnerMapper.toDto(cmdAccount.getOwnOwner(), true));
            account.setContact(ContactMapper.toDto(cmdAccount.getPrmContact(), true));
            account.setTransport(TransportMapper.toDto(cmdAccount.getTrpTransport(), true));
            account.setAddressByAccountDeliveryAddress(AddressMapper.toDto(cmdAccount.getAdrAddressByCmdAccountDeliveryAddressId(), true));
        }
        return account;
    }

    public static CmdAccount toEntity(Account account, boolean lazy) {
        if (null == account) {
            return null;
        }
        CmdAccount cmdAccount = new CmdAccount();
        cmdAccount.setCmdAccountCode(account.getCode() != null ? account.getCode().toUpperCase() : null);
        cmdAccount.setCmdAccountComment(account.getComment());
        cmdAccount.setCmdAccountCreationDate(account.getCreationDate());
        cmdAccount.setCmdAccountId(account.getId());
        cmdAccount.setCmdAccountIsActive(account.getActive());
        cmdAccount.setCmdAccountTerms(account.getTerms());
        cmdAccount.setCmdAccountUpdateDate(account.getUpdateDate());
        cmdAccount.setCmdAccountVariable1(account.getVariable1());
        cmdAccount.setCmdAccountVariable2(account.getVariable2());
        cmdAccount.setCmdAccountVariable3(account.getVariable3());
        cmdAccount.setCmdAccountVariable4(account.getVariable4());
        cmdAccount.setCmdAccountVariable5(account.getVariable5());
        cmdAccount.setCmdAccountVariable6(account.getVariable6());
        cmdAccount.setCmdAccountVariable7(account.getVariable7());
        cmdAccount.setCmdAccountVariable8(account.getVariable8());
        cmdAccount.setCmdAccountVariable9(account.getVariable9());
        cmdAccount.setCmdAccountVariable10(account.getVariable10());
        cmdAccount.setCmdAccountDescription(account.getDescription());
        cmdAccount.setCmdAccountName(account.getName());
        cmdAccount.setCmdAccountPassword(account.getPassword());
        if (!lazy) {
            cmdAccount.setCmdCompany(CompanyMapper.toEntity(account.getCompany(), true));
            cmdAccount.setPrmContact(ContactMapper.toEntity(account.getContact(), true));
            cmdAccount.setOwnOwner(OwnerMapper.toEntity(account.getOwner(), true));
            cmdAccount.setTrpTransport(TransportMapper.toEntity(account.getTransport(), true));
            cmdAccount.setAdrAddressByCmdAccountDeliveryAddressId(AddressMapper.toEntity(account.getAddressByAccountDeliveryAddress(), true));
        }
        return cmdAccount;
    }

    public static List<Account> toDtos(List<CmdAccount> cmdAccounts, boolean lazy) {
        if (null == cmdAccounts) {
            return null;
        }
        List<Account> accounts = new ArrayList<>();
        for (CmdAccount cmdAccount : cmdAccounts) {
            accounts.add(toDto(cmdAccount, lazy));
        }
        return accounts;
    }

    public static List<Account> toDtos(Iterable<CmdAccount> cmdAccounts, boolean lazy) {
        if (null == cmdAccounts) {
            return null;
        }
        List<Account> accounts = new ArrayList<>();
        for (CmdAccount cmdAccount : cmdAccounts) {
            accounts.add(toDto(cmdAccount, lazy));
        }
        return accounts;
    }

    public static Set<CmdAccount> toEntities(Set<Account> accounts, boolean lazy) {
        if (null == accounts) {
            return null;
        }
        Set<CmdAccount> cmdAccounts = new HashSet<>();
        for (Account account : accounts) {
            cmdAccounts.add(toEntity(account, lazy));
        }
        return cmdAccounts;
    }

    public static Set<Account> toDtos(Set<CmdAccount> cmdAccounts, boolean lazy) {
        if (null == cmdAccounts) {
            return null;
        }
        Set<Account> accounts = new HashSet<>();
        for (CmdAccount cmdAccount : cmdAccounts) {
            accounts.add(toDto(cmdAccount, lazy));
        }
        return accounts;
    }
}
