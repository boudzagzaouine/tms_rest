package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ServiceProvider;
import com.bagile.gmo.entities.GmoServiceProvider;

import java.util.*;

public class ServiceProviderMapper {
    
    public ServiceProviderMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoServiceProviderId");
        map.put ("code", "gmoServiceProviderCode");
        map.put ("description", "gmoServiceProviderDescription");
        map.put ("creationDate", "creationDate");
        map.put ("updateDate", "updateDate");
        map.put ("createdBy", "createdBy");
        map.put ("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get (key);
    }

    public static GmoServiceProvider toEntity(ServiceProvider serviceProvider, boolean lazy) {
        if (null == serviceProvider) {
            return null;
        }

        GmoServiceProvider gmoServiceProvider = new GmoServiceProvider ( );
        gmoServiceProvider.setGmoServiceProviderId (serviceProvider.getId ( ));
        gmoServiceProvider.setGmoServiceProviderCode (serviceProvider.getCode ( ) != null ? serviceProvider.getCode ( ).toUpperCase ( ) : null);
        gmoServiceProvider.setGmoServiceProviderDescription (serviceProvider.getDescription ( ));
        
        gmoServiceProvider.setCreatedBy (serviceProvider.getCreatedBy ( ));
        gmoServiceProvider.setUpdatedBy (serviceProvider.getUpdatedBy ( ));

       

        return gmoServiceProvider;

    }

    public static ServiceProvider toDto(GmoServiceProvider gmoServiceProvider, boolean lazy) {
        if (null == gmoServiceProvider) {
            return null;
        }
        ServiceProvider serviceProvider = new ServiceProvider ( );
        serviceProvider.setId (gmoServiceProvider.getGmoServiceProviderId ());
        serviceProvider.setCode (gmoServiceProvider.getGmoServiceProviderCode ());
        serviceProvider.setDescription (gmoServiceProvider.getGmoServiceProviderDescription ());

        serviceProvider.setCreatedBy (gmoServiceProvider.getCreatedBy ());
        serviceProvider.setUpdatedBy (gmoServiceProvider.getUpdatedBy ());
        serviceProvider.setCreationDate (gmoServiceProvider.getCreationDate ());
        serviceProvider.setUpdateDate (gmoServiceProvider.getUpdateDate ());

      
        return serviceProvider;

    }


    public static List<ServiceProvider> toDtos(Iterable<? extends GmoServiceProvider> gmoServiceProviders, boolean lazy) {
        if (null == gmoServiceProviders) {
            return null;
        }
        List<ServiceProvider> serviceProviders = new ArrayList<> ( );

        for (GmoServiceProvider gmoServiceProvider : gmoServiceProviders) {
            serviceProviders.add (toDto (gmoServiceProvider, lazy));
        }
        return serviceProviders;
    }

    public static Set<GmoServiceProvider> toEntities(Set<ServiceProvider> serviceProviders, boolean lazy) {
        if (null == serviceProviders) {
            return null;
        }
        Set<GmoServiceProvider> gmoServiceProviders = new HashSet<> ( );
        for (ServiceProvider serviceProvider : serviceProviders) {
            gmoServiceProviders.add (toEntity (serviceProvider, lazy));
        }
        return gmoServiceProviders;
    }

    public static Set<ServiceProvider> toDtos(Set<GmoServiceProvider> gmoServiceProviders, boolean lazy) {
        if (null == gmoServiceProviders) {
            return null;
        }
        Set<ServiceProvider> serviceProviders = new HashSet<> ( );
        for (GmoServiceProvider gmoServiceProvider : gmoServiceProviders) {
            serviceProviders.add (toDto (gmoServiceProvider, lazy));
        }
        return serviceProviders;
    }
}
