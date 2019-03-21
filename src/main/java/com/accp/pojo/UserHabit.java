package com.accp.pojo;

import com.accp.util.DateTime;

public class UserHabit {
	private Integer id;//主键
	private Integer userid;//用户ID
	private Integer stid;//一级服务
	private Integer stPid;//二级服务
	private Integer sPrice;//服务价格
	private DateTime clickDate;//访问时间
	
	
	public Integer getsPrice() {
		return sPrice;
	}
	public void setsPrice(Integer sPrice) {
		this.sPrice = sPrice;
	}
	public Integer getStPid() {
		return stPid;
	}
	public void setStPid(Integer stPid) {
		this.stPid = stPid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public DateTime getClickDate() {
		return clickDate;
	}
	public void setClickDate(DateTime clickDate) {
		this.clickDate = clickDate;
	}
	
	
	public UserHabit(Integer userid, Integer stid, Integer stPid, Integer sPrice) {
		super();
		this.userid = userid;
		this.stid = stid;
		this.stPid = stPid;
		this.sPrice = sPrice;
	}
	public UserHabit() {
		super();
	}
	
}
