package com.example.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="PS_JOB")
public class Job {
	
	@EmbeddedId
	private JobKey jobkey;
	@Column(name="EMPL_STATUS", length=1)
	private String emplStatus;
	@Column(name="HOURLY_RT", columnDefinition="Decimal(10,2) default '0.00'")
	private double hourlyRate;
	
	public JobKey getJobkey() {
		return jobkey;
	}
	public void setJobkey(JobKey jobkey) {
		this.jobkey = jobkey;
	}
	public String getEmplStatus() {
		return emplStatus;
	}
	public void setEmplStatus(String emplStatus) {
		this.emplStatus = emplStatus;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
