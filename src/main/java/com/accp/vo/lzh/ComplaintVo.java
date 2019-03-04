package com.accp.vo.lzh;

import java.util.Date;

/**
 * 
 * @author bige
 * @description 服务投诉
 * @version v1.0
 * @date 2019年3月2日
 */
public class ComplaintVo {
	private Integer cid;
	private String userName;
	private String ctName;
	private Integer isClear;
	private Date timeOfComplaint;
	private Integer type;
	private String serviceTitle;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public Integer getIsClear() {
		return isClear;
	}
	public void setIsClear(Integer isClear) {
		this.isClear = isClear;
	}
	
	public Date getTimeOfComplaint() {
		return timeOfComplaint;
	}
	public void setTimeOfComplaint(Date timeOfComplaint) {
		this.timeOfComplaint = timeOfComplaint;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	
	
}
