package com.sg.fixmastery.mic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mic {
	@Id
	private String mic;
	private String country;
	private String isocountrycode;
	private String operatingmic;
	private String os;
	private String nameinstitutiondescription;
	private String acronym;
	private String city;
	private String website;
	private String statusdate;
	private String xstatus;
	private String creationdate;
	private String comments;
	public String getMic() {
		return mic;
	}
	public String getCountry() {
		return country;
	}
	public String getIsocountrycode() {
		return isocountrycode;
	}
	public String getOperatingmic() {
		return operatingmic;
	}
	public String getOs() {
		return os;
	}
	public String getNameinstitutiondescription() {
		return nameinstitutiondescription;
	}
	public String getAcronym() {
		return acronym;
	}
	public String getCity() {
		return city;
	}
	public String getWebsite() {
		return website;
	}
	public String getStatusdate() {
		return statusdate;
	}
	public String getXstatus() {
		return xstatus;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public String getComments() {
		return comments;
	}
	
	

}
