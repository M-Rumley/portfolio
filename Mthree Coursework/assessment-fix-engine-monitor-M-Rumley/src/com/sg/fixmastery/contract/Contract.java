package com.sg.fixmastery.contract;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contract {
	
	@Id
	private String sym;
	private String productcode;
	private Date startdate;
	private Date enddate;
	
	public Contract() {}

	public String getSym() {
		return sym;
	}

	public String getProductcode() {
		return productcode;
	}

	public Date getStartdate() {
		return startdate;
	}

	public Date getEnddate() {
		return enddate;
	}
	
	
}
