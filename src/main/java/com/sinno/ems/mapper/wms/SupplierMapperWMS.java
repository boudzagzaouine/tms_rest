package com.sinno.ems.mapper.wms;

import com.sinno.wms.crud.model.sup.Suppliers;

public class SupplierMapperWMS {



    public SupplierMapperWMS() {

    }


   public Suppliers toModel(RcpSupplier supplierDto , String operation){

       Suppliers suppliersModel = new Suppliers();
       suppliersModel.setOperation(operation);
       suppliersModel.setSupplierCode(supplierDto.getRcpSupplierCode());
       suppliersModel.setDescription(supplierDto.getRcpSupplierDescription());

       suppliersModel.setAddrNameFrom(supplierDto.getAdrAddress().getAdrAddressCode());
       suppliersModel.setAddrLine1From(supplierDto.getAdrAddress().getAdrAddressLine1());
       suppliersModel.setAddrLine2From(supplierDto.getAdrAddress().getAdrAdressLine2());

       suppliersModel.setCountryFrom(supplierDto.getAdrAddress().getAdrAddressCountry());
       suppliersModel.setZipFrom(supplierDto.getAdrAddress().getAdrAddressZip());
       suppliersModel.setContactNameFrom(supplierDto.getPrmContact().getPrmContactName());
       suppliersModel.setContactTelFrom(supplierDto.getPrmContact().getPrmContactTel1());
       suppliersModel.setContactExtFrom(supplierDto.getPrmContact().getPrmContactTel2());
       suppliersModel.setCityTo(supplierDto.getAdrAddress().getAdrAddressCity());

       suppliersModel.setCountryTo(supplierDto.getAdrAddress().getAdrAddressCountry());
       suppliersModel.setZipTo(supplierDto.getAdrAddress().getAdrAddressZip());
       suppliersModel.setContactNameTo(supplierDto.getPrmContact().getPrmContactName());
       suppliersModel.setContactTelTo(supplierDto.getPrmContact().getPrmContactTel1());
       suppliersModel.setContactExtTo(supplierDto.getPrmContact().getPrmContactTel2());
       suppliersModel.setContactFaxTo(supplierDto.getPrmContact().getPrmContactFax());
       suppliersModel.setCommentTo(supplierDto.getRcpSupplierComment());




       //TODO suppliersModel.setTerms(supplierDto.getTerms());
       suppliersModel.setDamagedOwnerCode(supplierDto.getOwnOwner().getOwnOwnerCode());
       suppliersModel.setAttribute1(supplierDto.getRcpSupplierVariable1());
       suppliersModel.setAttribute2(supplierDto.getRcpSupplierVariable2());
       suppliersModel.setAttribute3(supplierDto.getRcpSupplierVariable3());
       suppliersModel.setAttribute4(supplierDto.getRcpSupplierVariable4());
       suppliersModel.setAttribute5(supplierDto.getRcpSupplierVariable5());
       suppliersModel.setAttribute6(supplierDto.getRcpSupplierVariable6());
       suppliersModel.setAttribute7(supplierDto.getRcpSupplierVariable7());
       suppliersModel.setAttribute8(supplierDto.getRcpSupplierVariable8());
       suppliersModel.setAttribute9(supplierDto.getRcpSupplierVariable9());
       suppliersModel.setAttribute10(supplierDto.getRcpSupplierVariable10());

       if (null != supplierDto.getTrpTransport() && null != supplierDto.getTrpTransport().getTrpTransportCode())
         suppliersModel.setCarrierCode(supplierDto.getTrpTransport().getTrpTransportCode());
       if (null != supplierDto.getTrpTransport() && null != supplierDto.getTrpTransport().getTrpTransportDescription())
       suppliersModel.setDescCarrier(supplierDto.getTrpTransport().getTrpTransportDescription());
       if (null != supplierDto.getTrpTransport()&& null != supplierDto.getTrpTransport().getPrmContact() && null != supplierDto.getTrpTransport().getPrmContact().getPrmContactName())
       suppliersModel.setCarrierName(supplierDto.getTrpTransport().getPrmContact().getPrmContactName());







       return suppliersModel;
   }
}
