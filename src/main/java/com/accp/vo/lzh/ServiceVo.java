package com.accp.vo.lzh;
/**
 * 
 * @author bige
 * @description 服务vo
 * @version v1.0
 * @date 2019年2月20日
 */

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceVo {
	private Integer serviceID; //服务id
	private Integer stid;//服务类型id
	private String stName;//服务类型名称
	private Integer userID;//用户id
	private String userName;//用户名称
	private String serviceTitle;//服务标题
	private Integer auditStatus;//审核状态
	private String shopName;//店铺名称
	private Integer shelfState;//营业状态
	private Integer orderByNum;//排序（0 1 2）
	private Integer recommendBool;//不为空就推荐
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date releaseTime;//发布时间
	private String releaseTimeP;//开始时间
	private String releaseTimePM;//结束时间
	
	
	public String getReleaseTimeP() {
		return releaseTimeP;
	}
	public void setReleaseTimeP(String releaseTimeP) {
		this.releaseTimeP = releaseTimeP;
	}
	public String getReleaseTimePM() {
		return releaseTimePM;
	}
	public void setReleaseTimePM(String releaseTimePM) {
		this.releaseTimePM = releaseTimePM;
	}
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public Integer getShelfState() {
		return shelfState;
	}
	public void setShelfState(Integer shelfState) {
		this.shelfState = shelfState;
	}
	
	public Integer getOrderByNum() {
		return orderByNum;
	}
	public void setOrderByNum(Integer orderByNum) {
		this.orderByNum = orderByNum;
	}
	public Integer getRecommendBool() {
		return recommendBool;
	}
	public void setRecommendBool(Integer recommendBool) {
		this.recommendBool = recommendBool;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	
}
