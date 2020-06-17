package com.sg.fixmastery.instrument;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//DTO
@Entity
public class Instrument {
	
	@Id @GeneratedValue
	private Long Id;
	private String name;
	private String instrument;
	private String ric;
	

	private String isin;
	private String sedol;
	private String cusip;
	private String bbid;
	private String mic;
	private String cik;
	
	
	
	public Instrument(String name) {
		super();
		this.name = name;
	}
	public Instrument() {}

	public Long getId() {
		return Id;
	}
	public String getInstrument() {
		return instrument;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getRic() {
		return ric;
	}
	public String getIsin() {
		return isin;
	}
	public String getSedol() {
		return sedol;
	}
	public String getCusip() {
		return cusip;
	}
	public String getBbid() {
		return bbid;
	}
	public String getMic() {
		return mic;
	}
	public String getCik() {
		return cik;
	}
}
