package com.bagile.tms.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Enissay on 09/06/2016.
 */
public class TableNames {
    private TableNames() {
    }

    private static Map<String, String> map;

    static {
        map=new HashMap();
        map.put("address","adress");
        map.put("account","client");
        map.put("company","Soci�t�");
        map.put("delivery","livraison");
        map.put("deliveryline","ligne de livraison");
        map.put("saleorder","commande de vente");
        map.put("saleorderline","ligne de commande de vente");
        map.put("invoice","facturation");
        map.put("invoiceline","ligne de facturation");
        map.put("invoicerules","r�gle de facturation");
        map.put("location","emplacement");
        map.put("zone","zone");
        map.put("owner","propri�taire");
        map.put("alias","alias");
        map.put("kit","kit");
        map.put("product","produit");
        map.put("productpack","conditionnement");
        map.put("producttype","famille de produit");
        map.put("uom","unit� de mesure");
        map.put("blocktype","type de blocage");
        map.put("color","coleur");
        map.put("contact","contact");
        map.put("image","image");
        map.put("locationstatus","status d'emplacement");
        map.put("orderstatus","type de commande");
        map.put("purshaseorder","commande d'achat");
        map.put("purshaseorderline","ligne de commande d'achat");
        map.put("reception","r�ception");
        map.put("receptionline","ligne de r�ception");
        map.put("receptionstock","stock de r�ception");
        map.put("supplier","fournisseur");
        map.put("container","conteneur");
        map.put("stock","stock");
        map.put("transport","transporteur");
        map.put("grouphabilitation","groupe d'habilitation");
        map.put("habilitation","habilitation");
        map.put("user","utilisateur");
        map.put("usergroup","group d'utilisateur");
        map.put("warehouse","entrep�t");
        map.put("stockexception","Stock Exception");

    }
    public static String getField(String key) {
        return map.get(key);
    }

}
