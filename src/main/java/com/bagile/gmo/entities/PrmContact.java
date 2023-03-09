package com.bagile.gmo.entities;


import javax.persistence.*;

@Entity
@Table(name="prm_contact")
public class PrmContact extends EmsEntity {

    private static final long serialVersionUID = -2556249835469329497L;

    private Long prmContactId;

    private String prmContactCode;
    private String prmContactName;
    private String prmContactSurname;
    private String prmContactTel1;
    private String prmContactTel2;
    private String prmContactFax;
   // private String prmContactType;
    private String prmContactEmail;
    private String prmContactComment;
    private Boolean prmContactActive;
    private OwnOwner ownOwner;

    private CmdAccount cmdAccount ;

    private TrpTransport trpTransport;
    private AdrAddress adrAddress;
    private TmsContactFunction tmsContactFunction;

    private Boolean tmsContactDelivery;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_contact_id", allocationSize = 1)
    @Column(name = "prm_contactid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmContactId() {
        return prmContactId;
    }
    public void setPrmContactId(Long prmContactId) {
        this.prmContactId = prmContactId;
    }

    @Column(name = "prm_contactname")
    public String getPrmContactName() {
        return prmContactName;
    }
    public void setPrmContactName(String prmContactName) {
        this.prmContactName = prmContactName;
    }

    @Column(name = "prm_contactcode")
    public String getPrmContactCode() {
        return prmContactCode;
    }

    public void setPrmContactCode(String prmContactCode) {
        this.prmContactCode = prmContactCode;
    }

    @Column(name = "prm_contactsurname")
    public String getPrmContactSurname() {
        return prmContactSurname;
    }

    public void setPrmContactSurname(String prmContactSurname) {
        this.prmContactSurname = prmContactSurname;
    }

    @Column(name = "prm_contacttel1")
    public String getPrmContactTel1() {
        return prmContactTel1;
    }

    public void setPrmContactTel1(String prmContactTel1) {
        this.prmContactTel1 = prmContactTel1;
    }

    @Column(name = "prm_contacttel2")
    public String getPrmContactTel2() {
        return prmContactTel2;
    }

    public void setPrmContactTel2(String prmContactTel2) {
        this.prmContactTel2 = prmContactTel2;
    }

    @Column(name = "prm_contactdelivery")

    public Boolean getTmsContactDelivery() {
        return tmsContactDelivery;
    }

    public void setTmsContactDelivery(Boolean tmsContactDelivery) {
        this.tmsContactDelivery = tmsContactDelivery;
    }

    @Column(name = "prm_contactfax")
    public String getPrmContactFax() {
        return prmContactFax;
    }

    public void setPrmContactFax(String prmContactFax) {
        this.prmContactFax = prmContactFax;
    }

  /*  @Column(name = "prm_contacttype")
    public String getPrmContactType() {
        return prmContactType;
    }
    public void setPrmContactType(String prmContactType) {
        this.prmContactType = prmContactType;
    }
*/
    @Column(name = "prm_contactemail")
    public String getPrmContactEmail() {
        return prmContactEmail;
    }
    public void setPrmContactEmail(String prmContactEmail) {
        this.prmContactEmail = prmContactEmail;
    }

    @Column(name = "prm_contactcomment")
    public String getPrmContactComment() {
        return prmContactComment;
    }
    public void setPrmContactComment(String prmContactComment) {
        this.prmContactComment = prmContactComment;
    }

    @OneToOne
    @JoinColumn(name = "prm_contacttransportid", referencedColumnName = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @ManyToOne
    @JoinColumn(name="prm_contactaddressid")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }

    @Column(name = "prm_contactactive")
    public Boolean isPrmContactActive() {
        return prmContactActive;
    }
    public void setPrmContactActive(Boolean prmContactActive) {
        if (prmContactActive == null) {
            this.prmContactActive = false;
            return;
        }
        this.prmContactActive = prmContactActive;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adr_addressownerid")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_contactfunctionid")
    public TmsContactFunction getTmsContactFunction() {
        return tmsContactFunction;
    }

    public void setTmsContactFunction(TmsContactFunction tmsContactFunction) {
        this.tmsContactFunction = tmsContactFunction;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adr_addressaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }
}
