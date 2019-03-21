package com.accp.vo.wdg;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvertisementVo {
	private Integer aid;
	private Integer atid;
	private String atitle;
	private Integer aorder;
	private String aimgPath;
	private String apcUrl;
	private String aappUrl;
	private String adescribe;
	private String atname;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	private Integer rentamonth;
	private Integer atpx;
	public AdvertisementVo() {
		super();
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getAtid() {
		return atid;
	}
	public void setAtid(Integer atid) {
		this.atid = atid;
	}
	public String getAtitle() {
		return atitle;
	}
	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}
	public Integer getAorder() {
		return aorder;
	}
	public void setAorder(Integer aorder) {
		this.aorder = aorder;
	}
	public String getAimgPath() {
		return aimgPath;
	}
	public void setAimgPath(String aimgPath) {
		this.aimgPath = aimgPath;
	}
	public String getApcUrl() {
		return apcUrl;
	}
	public void setApcUrl(String apcUrl) {
		this.apcUrl = apcUrl;
	}
	public String getAappUrl() {
		return aappUrl;
	}
	public void setAappUrl(String aappUrl) {
		this.aappUrl = aappUrl;
	}
	public String getAdescribe() {
		return adescribe;
	}
	public void setAdescribe(String adescribe) {
		this.adescribe = adescribe;
	}
	public String getAtname() {
		return atname;
	}
	public void setAtname(String atname) {
		this.atname = atname;
	}
	public Integer getAtpx() {
		return atpx;
	}
	public void setAtpx(Integer atpx) {
		this.atpx = atpx;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Integer getRentamonth() {
		return rentamonth;
	}
	public void setRentamonth(Integer rentamonth) {
		this.rentamonth = rentamonth;
	}
}
