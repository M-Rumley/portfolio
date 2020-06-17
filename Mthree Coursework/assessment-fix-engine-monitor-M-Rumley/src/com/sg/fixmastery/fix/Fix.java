package com.sg.fixmastery.fix;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fix {
	@Id
	private Long id;
	private Long tag;
	private String name;
	private String value;
	private String descr;
	public Long getId() {
		return id;
	}
	public Long getTag() {
		return tag;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	public String getDescr() {
		return descr;
	}
	
	
}
