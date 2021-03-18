package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gmo_agent")
public class GmoAgent extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = 7465274138053290715L;

    private Long gmoAgentId;

    private String gmoAgentCode;
    private String gmoAgentCin;

    private Date gmoAgentBirthDate;

    private Date gmoAgentLastMedicalVisit;


    private Boolean gmoWorking=false;

    
    private String gmoAgentName;


    private String gmoAgentTele1;
private GmoResponsability gmoResponsability;

    private OwnOwner ownOwner;

    public GmoAgent() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_agent_id", allocationSize = 1)
    @Column(name = "gmo_agentid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoAgentId() {
        return gmoAgentId;
    }

    public void setGmoAgentId(Long gmoAgentId) {
        this.gmoAgentId = gmoAgentId;
    }

    @Column(name = "gmo_agentcode", unique = true, nullable = false, length = 90)
    public String getGmoAgentCode() {
        return gmoAgentCode;
    }

    public void setGmoAgentCode(String gmoAgentCode) {
        this.gmoAgentCode = gmoAgentCode;
    }

    @Column(name = "gmo_agentcin")
    public String getGmoAgentCin() {
        return gmoAgentCin;
    }

    public void setGmoAgentCin(String gmoAgentCin) {
        this.gmoAgentCin = gmoAgentCin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "gmo_agentbirthdate")
    public Date getGmoAgentBirthDate() {
        return gmoAgentBirthDate;
    }

    public void setGmoAgentBirthDate(Date gmoAgentBirthDate) {
        this.gmoAgentBirthDate = gmoAgentBirthDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "gmo_agentlastmedicalvisit")
    public Date getGmoAgentLastMedicalVisit() {
        return gmoAgentLastMedicalVisit;
    }

    public void setGmoAgentLastMedicalVisit(Date gmoAgentLastMedicalVisit) {
        this.gmoAgentLastMedicalVisit = gmoAgentLastMedicalVisit;
    }



   


    @Column(name = "gmo_agentisworking")
    public Boolean isGmoWorking() {
        return gmoWorking;
    }

    public void setGmoWorking(Boolean gmoWorking) {
        if(gmoWorking==null){
            this.gmoWorking=false;
        }
        else {this.gmoWorking = gmoWorking;}
    }


  @ManyToOne()
  @JoinColumn(name="gmo_ownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_responsabilityid")
    public GmoResponsability getGmoResponsability() {
        return gmoResponsability;
    }

    public void setGmoResponsability(GmoResponsability gmoResponsability) {
        this.gmoResponsability = gmoResponsability;
    }

    @Column(name = "gmo_agentname")
    public String getGmoAgentName() {
        return gmoAgentName;
    }

    public void setGmoAgentName(String gmoAgentName) {
        this.gmoAgentName = gmoAgentName;
    }

    @Column(name = "gmo_agenttele1")

    public String getGmoAgentTele1() {
        return gmoAgentTele1;
    }

    public void setGmoAgentTele1(String gmoAgentTele1) {
        this.gmoAgentTele1 = gmoAgentTele1;
    }








}
