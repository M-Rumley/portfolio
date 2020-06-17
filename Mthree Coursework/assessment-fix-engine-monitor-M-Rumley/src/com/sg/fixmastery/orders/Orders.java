package com.sg.fixmastery.orders;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Orders {
	
	@Id
	private Long Id;
	private Date datetimestamp;
	private String clientid;
	private String rootordid;
	private String parentordid;
	private String msgtype;
	private String orderid;
	private String systemid;
	private String instrument;
	private String ordstatus;
	private String ordtype;
	private String venue;
	private String side;
	private String orderqty;
	private String cumquty;
	private String leavesqty;
	private String price;
	private String descr;
	
	public Long getId() {
		return Id;
	}
	public Date getDatetimestamp() {
		return datetimestamp;
	}
	public String getClientid() {
		return clientid;
	}
	public String getRootordid() {
		return rootordid;
	}
	public String getParentordid() {
		return parentordid;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public String getOrderid() {
		return orderid;
	}
	public String getSystemid() {
		return systemid;
	}
	public String getInstrument() {
		return instrument;
	}
	public String getOrdstatus() {
		return ordstatus;
	}
	public String getOrdtype() {
		return ordtype;
	}
	public String getVenue() {
		return venue;
	}
	public String getSide() {
		return side;
	}
	public String getOrderqty() {
		return orderqty;
	}
	public String getCumquty() {
		return cumquty;
	}
	public String getLeavesqty() {
		return leavesqty;
	}
	public String getPrice() {
		return price;
	}
	public String getDescr() {
		return descr;
	}

}
