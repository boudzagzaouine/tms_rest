package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_serviceprovider")
public class GmoServiceProvider extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private long gmoServiceProviderId;
    private String gmoServiceProviderCode;
    private String gmoServiceProviderDescription;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_service_provider_id", allocationSize = 1)
    @Column(name = "gmo_serviceproviderid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoServiceProviderId() {
        return gmoServiceProviderId;
    }

    public void setGmoServiceProviderId(long gmoServiceProviderId) {
        this.gmoServiceProviderId = gmoServiceProviderId;
    }

    @Column(name = "gmo_serviceprovidercode", unique = true, nullable = false, length = 90)
    public String getGmoServiceProviderCode() {
        return gmoServiceProviderCode;
    }

    public void setGmoServiceProviderCode(String gmoServiceProviderCode) {
        this.gmoServiceProviderCode = gmoServiceProviderCode;
    }

    @Column(name = "gmo_serviceproviderdescription")
    public String getGmoServiceProviderDescription() {
        return gmoServiceProviderDescription;
    }

    public void setGmoServiceProviderDescription(String gmoServiceProviderDescription) {
        this.gmoServiceProviderDescription = gmoServiceProviderDescription;
    }

  
}
