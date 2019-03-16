package com.accp.vo.cm;

import java.util.Date;

public class serviceVo {
	//服务id
	private Integer serviceid;
	//订单id
	private String orderid;
	//用户id
	private Integer userid;
	//买家
	private String username;
	//卖家
	private String shopname;
	//服务类别id
	private Integer stid;
	//服务类别名称
	private String stname;
	//服务标题
	private String servicetitle;
	//积分
	private Integer integral;
	//下单时间
	private Date ordertime;
	//订单状态
	private Integer orderstatus;
	//付款时间
	private Date paymenttime;
	//备注
	private String remarks;
	//价格
	private float totalprice;
	//服务图片
	private String servicecoverimg;
	//接单时间
	private Date receiptTime;
	//提供服务时间
	private Date provideServicesTime;
	//完成时间
	private Date completeTime;
	//总订单数
	private int dingdan;
	//总金币数
	private float jinbi;
	
	public int getDingdan() {
		return dingdan;
	}
	public void setDingdan(int dingdan) {
		this.dingdan = dingdan;
	}
	public float getJinbi() {
		return jinbi;
	}
	public void setJinbi(float jinbi) {
		this.jinbi = jinbi;
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
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getServicetitle() {
		return servicetitle;
	}
	public void setServicetitle(String servicetitle) {
		this.servicetitle = servicetitle;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
	public Date getPaymenttime() {
		return paymenttime;
	}
	public void setPaymenttime(Date paymenttime) {
		this.paymenttime = paymenttime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public String getServicecoverimg() {
		return servicecoverimg;
	}
	public void setServicecoverimg(String servicecoverimg) {
		this.servicecoverimg = servicecoverimg;
	}
	public Date getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	public Date getProvideServicesTime() {
		return provideServicesTime;
	}
	public void setProvideServicesTime(Date provideServicesTime) {
		this.provideServicesTime = provideServicesTime;
	}
	public Date getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	
}
