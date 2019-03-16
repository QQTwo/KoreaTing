package com.accp.vo.lzh;

import java.util.Date;

/**
 * 
 * @author bige
 * @description 退款记录
 * @version v1.0
 * @date 2019年3月1日
 */
public class RefundVo {
	private int userID;
	private String userName;
	private String orderID;
	private float applyRefundMoney;
	private String refundReason;
	private Date applicationTime;
	private int refundstatus;
	private String businessRemarks;
	private Date auditTime;
	private float actualRefundMoney;
	private int adminStatus;
	private String adminRemarks;
	private String refundImg;
	private float totalPrice;
	private String recordDescribe;
	private int acquisitionMode;
	
	public String getRecordDescribe() {
		return recordDescribe;
	}
	public void setRecordDescribe(String recordDescribe) {
		this.recordDescribe = recordDescribe;
	}
	public int getAcquisitionMode() {
		return acquisitionMode;
	}
	public void setAcquisitionMode(int acquisitionMode) {
		this.acquisitionMode = acquisitionMode;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public float getApplyRefundMoney() {
		return applyRefundMoney;
	}
	public void setApplyRefundMoney(float applyRefundMoney) {
		this.applyRefundMoney = applyRefundMoney;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public Date getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}
	public int getRefundstatus() {
		return refundstatus;
	}
	public void setRefundstatus(int refundstatus) {
		this.refundstatus = refundstatus;
	}
	public String getBusinessRemarks() {
		return businessRemarks;
	}
	public void setBusinessRemarks(String businessRemarks) {
		this.businessRemarks = businessRemarks;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public float getActualRefundMoney() {
		return actualRefundMoney;
	}
	public void setActualRefundMoney(float actualRefundMoney) {
		this.actualRefundMoney = actualRefundMoney;
	}
	public int getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(int adminStatus) {
		this.adminStatus = adminStatus;
	}
	public String getAdminRemarks() {
		return adminRemarks;
	}
	public void setAdminRemarks(String adminRemarks) {
		this.adminRemarks = adminRemarks;
	}
	public String getRefundImg() {
		return refundImg;
	}
	public void setRefundImg(String refundImg) {
		this.refundImg = refundImg;
	}
	
	
}
