package com.sg.fixmastery.ric;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Ric {
	
	
	private String Id;
	@Id
	private String market;
	private String tag;
	
	public String getId() {
		return Id;
	}
	public String getMarket() {
		return market;
	}
	public String getTag() {
		return tag;
	}
	
	
	
}
