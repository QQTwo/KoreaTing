package com.accp.vo.cm;

import java.util.Date;

public class RecordVo {

	private int userID;
	private int recordID;
	private String userName;
	//充值方式
	private int acquisitionMode;
	private Date recordDate;
	private String recordDescribe;
	private float recordInAndOut;
	private int auditStatus;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAcquisitionMode() {
		return acquisitionMode;
	}
	public void setAcquisitionMode(int acquisitionMode) {
		this.acquisitionMode = acquisitionMode;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecordDescribe() {
		return recordDescribe;
	}
	public void setRecordDescribe(String recordDescribe) {
		this.recordDescribe = recordDescribe;
	}
	public float getRecordInAndOut() {
		return recordInAndOut;
	}
	public void setRecordInAndOut(float recordInAndOut) {
		this.recordInAndOut = recordInAndOut;
	}
	public int getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
}
