package com.accp.vo.lzh;

import java.util.Date;

public class ReimburseVo {
	private Integer refundid;
	private Integer userid;
	private String username;
	private Date applicationtime;
	private Date audittime;
	private String remarks;
	private Integer orderstatus;
	private String servicetitle;
	private float applyrefundmoney;
	private Integer serviceid;
	private String orderid;
	private String dateStart;
	private String dateEnd;
	private Integer refundstatus;
	
	
	public Integer getRefundstatus() {
		return refundstatus;
	}
	public void setRefundstatus(Integer refundstatus) {
		this.refundstatus = refundstatus;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Integer getRefundid() {
		return refundid;
	}
	public void setRefundid(Integer refundid) {
		this.refundid = refundid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getApplicationtime() {
		return applicationtime;
	}
	public void setApplicationtime(Date applicationtime) {
		this.applicationtime = applicationtime;
	}
	public Date getAudittime() {
		return audittime;
	}
	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getServicetitle() {
		return servicetitle;
	}
	public void setServicetitle(String servicetitle) {
		this.servicetitle = servicetitle;
	}
	public float getApplyrefundmoney() {
		return applyrefundmoney;
	}
	public void setApplyrefundmoney(float applyrefundmoney) {
		this.applyrefundmoney = applyrefundmoney;
	}
	public Integer getServiceid() {
		return serviceid;
	}
	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
}
