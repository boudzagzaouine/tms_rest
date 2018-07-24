package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Adil on 2/24/2017.
 */
public class WalletMapper {
    private WalletMapper(){

    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id","prmWalletId");
        map.put("code","prmWalletCode");
        map.put("balance","prmWalletbalance");
        map.put("creationDate","prmWalletCreationDate");
        map.put("updateDate","prmWalletUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }
    public static String getField(String key) {
        return map.get(key);
    }

    public static PrmWallet toEntity(Wallet wallet, boolean lazy) {
        PrmWallet prmWallet = new PrmWallet();
        prmWallet.setPrmWalletId(wallet.getId());
        prmWallet.setPrmWalletCode(wallet.getCode());
        prmWallet.setPrmWalletCode(wallet.getCode());
        prmWallet.setPrmWalletCreationDate(wallet.getCreationDate());
        prmWallet.setPrmWalletUpdateDate(wallet.getUpdateDate());
        return prmWallet;
    }

    public static Wallet toDto(PrmWallet prmWallet, boolean lazy){
        Wallet wallet = new Wallet();
        wallet.setId(prmWallet.getPrmWalletId());
        wallet.setCode(prmWallet.getPrmWalletCode());
        wallet.setCode(prmWallet.getPrmWalletCode());
        wallet.setCreationDate(prmWallet.getPrmWalletCreationDate());
        wallet.setUpdateDate(prmWallet.getPrmWalletUpdateDate());

        return wallet;
    }

    public static List<Wallet> toDtos(List<PrmWallet> prmWallets, boolean lazy) {
        if (null == prmWallets) {
            return null;
        }
        List<Wallet> wallets = new ArrayList<>();
        for (PrmWallet prmWallet : prmWallets) {
            wallets.add(toDto(prmWallet, lazy));
        }
        return wallets;
    }

    public static List<Wallet> toDtos(Iterable<PrmWallet> prmWallets, boolean lazy) {
        if (null == prmWallets) {
            return null;
        }
        List<Wallet> wallets = new ArrayList<>();
        for (PrmWallet prmWallet : prmWallets) {
            wallets.add(toDto(prmWallet, lazy));
        }
        return wallets;
    }

    public static Set<PrmWallet> toEntities(Set<Wallet> wallets, boolean lazy) {
        if (null == wallets) {
            return null;
        }
        Set<PrmWallet> prmWallets = new HashSet<>();
        for (Wallet wallet : wallets) {
            prmWallets.add(toEntity(wallet, lazy));
        }
        return prmWallets;
    }

    public static Set<Wallet> toDtos(Set<PrmWallet> prmWallets, boolean lazy) {
        if (null == prmWallets) {
            return null;
        }
        Set<Wallet> wallets = new HashSet<>();
        for (PrmWallet prmWallet : prmWallets) {
            wallets.add(toDto(prmWallet, lazy));
        }
        return wallets;
    }
}
