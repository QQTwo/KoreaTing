package com.accp.vo.cm;

import java.util.Date;

public class IntegralVo {
		private int irID;
		private String userName;
		private Date irDate;
		private String irDescribe;
		private int recordInAndOut;
		//获取方式，即获得积分规格条件
		private String integralName;
		//审核状态
		private int auditStatus;
		
		public int getAuditStatus() {
			return auditStatus;
		}
		public void setAuditStatus(int auditStatus) {
			this.auditStatus = auditStatus;
		}
		public String getIntegralName() {
			return integralName;
		}
		public void setIntegralName(String integralName) {
			this.integralName = integralName;
		}
		public int getIrID() {
			return irID;
		}
		public void setIrID(int irID) {
			this.irID = irID;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public Date getIrDate() {
			return irDate;
		}
		public void setIrDate(Date irDate) {
			this.irDate = irDate;
		}
		public String getIrDescribe() {
			return irDescribe;
		}
		public void setIrDescribe(String irDescribe) {
			this.irDescribe = irDescribe;
		}
		public int getRecordInAndOut() {
			return recordInAndOut;
		}
		public void setRecordInAndOut(int recordInAndOut) {
			this.recordInAndOut = recordInAndOut;
		}
}
