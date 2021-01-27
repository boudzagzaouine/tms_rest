package com.bagile.gmo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fltr_customfilter")
public class FltrCustomFilter extends EmsEntity implements Serializable {

	private static final long serialVersionUID = -2692418708409874221L;

	private Long fltrId;
	private String fltrQuery;
	private String fltrName;
	private UsrUser fltrUser;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_fltr_id", allocationSize = 1)
    @Column(name = "fltr_filterid", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getFltrId() {
		return fltrId;
	}
	public void setFltrId(Long fltrId) {
		this.fltrId = fltrId;
	}
	
	@Column(name = "fltr_query")
	public String getFltrQuery() {
		return fltrQuery;
	}
	public void setFltrQuery(String fltrQuery) {
		this.fltrQuery = fltrQuery;
	}

	@Column(name = "fltr_name")
	public String getFltrName() {
		return fltrName;
	}
	public void setFltrName(String fltrName) {
		this.fltrName = fltrName;
	}

	@ManyToOne
	@JoinColumn(name = "usr_userid")
	public UsrUser getFltrUser() {
		return fltrUser;
	}
	public void setFltrUser(UsrUser fltrUser) {
		this.fltrUser = fltrUser;
	}
}
