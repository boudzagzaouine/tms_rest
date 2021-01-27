package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "gmo_template")
public class GmoTemplate extends EmsEntity{

    private Long gmoTemplateId;
    private String gmoTemplateCode;
    private String gmoTemplateText;
    private String gmoTemplateSubject;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_template_id")
    @Column(name = "gmo_templateid", unique = true, nullable = false, precision = 10, scale = 0)

    public Long getGmoTemplateId() {
        return gmoTemplateId;
    }

    public void setGmoTemplateId(Long gmoTemplateId) {
        this.gmoTemplateId = gmoTemplateId;
    }

    @Column(name = "gmo_templatecode")
    public String getGmoTemplateCode() {
        return gmoTemplateCode;
    }

    public void setGmoTemplateCode(String gmoTemplateCode) {
        this.gmoTemplateCode = gmoTemplateCode;
    }

    @Column(name = "gmo_templatetexte")
    public String getGmoTemplateText() {
        return gmoTemplateText;
    }

    public void setGmoTemplateText(String gmoTemplateText) {
        this.gmoTemplateText = gmoTemplateText;
    }

    @Column(name = "gmo_templatesubject")
    public String getGmoTemplateSubject() {
        return gmoTemplateSubject;
    }

    public void setGmoTemplateSubject(String gmoTemplateSubject) {
        this.gmoTemplateSubject = gmoTemplateSubject;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
