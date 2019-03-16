package com.accp.vo.cm;

import java.util.Date;

public class postVo {
	private Integer postid;
	private Integer fmid;
	private String fmname;
	private String title;
	private Date releasetime;
	private Integer auditstatus;
	private String adminopinion;
	private Integer recommend;
	private String content;
	private Integer operatingState;
	
	public String getAdminopinion() {
		return adminopinion;
	}
	public void setAdminopinion(String adminopinion) {
		this.adminopinion = adminopinion;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getOperatingState() {
		return operatingState;
	}
	public void setOperatingState(Integer operatingState) {
		this.operatingState = operatingState;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	public Integer getFmid() {
		return fmid;
	}
	public void setFmid(Integer fmid) {
		this.fmid = fmid;
	}
	public String getFmname() {
		return fmname;
	}
	public void setFmname(String fmname) {
		this.fmname = fmname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}
	public Integer getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(Integer auditstatus) {
		this.auditstatus = auditstatus;
	}
	
}
