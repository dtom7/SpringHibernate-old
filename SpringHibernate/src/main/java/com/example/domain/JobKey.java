package com.example.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JobKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="EMPLID", length=10)
	private int emplId;
	@Column(name="EMPL_RCD", length=2)
	private int emplRcd;
	@Column(name="EFFDT")
	private Date effdt;
	@Column(name="EFFSEQ", length=2)
	private int effseq;
	
	public JobKey() {
		
	}
	
	public JobKey(int emplId, int emplRcd, Date effdt, int effseq) {
		super();
		this.emplId = emplId;
		this.emplRcd = emplRcd;
		this.effdt = effdt;
		this.effseq = effseq;
	}
	public int getEmplId() {
		return emplId;
	}
	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}
	public int getEmplRcd() {
		return emplRcd;
	}
	public void setEmplRcd(int emplRcd) {
		this.emplRcd = emplRcd;
	}
	public Date getEffdt() {
		return effdt;
	}
	public void setEffdt(Date effdt) {
		this.effdt = effdt;
	}
	public int getEffseq() {
		return effseq;
	}
	public void setEffseq(int effseq) {
		this.effseq = effseq;
	}

}
