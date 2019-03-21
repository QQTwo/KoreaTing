/**
 * 
 * @ClassName:ServiceCollectVo
 * @description:TODO
 * @author lenovo
 * @date 2019年3月14日
 * @version V1.0
 */
package com.accp.vo.cm;

import java.util.Date;

/**
* @author 作者
* @version 创建时间：2019年3月14日 下午3:29:07
* 类说明
*/
/**
 * 
 * @ClassName:ServiceCollectVo
 * @description:TODO
 * @author lenovo
 * @date 2019年3月14日
 * @version V1.0
 */
public class ServiceCollectVo {
	private int serviceID;
	private int stid;
	//服务类别名称
	private String stName;
	//服务名称
	private String serviceTitle;
	private String userName;
	private Date collectionTime;
	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCollectionTime() {
		return collectionTime;
	}
	public void setCollectionTime(Date collectionTime) {
		this.collectionTime = collectionTime;
	}
	public ServiceCollectVo() {
		super();
	}
	public ServiceCollectVo(int serviceID, int stid, String stName, String serviceTitle, String userName,
			Date collectionTime) {
		super();
		this.serviceID = serviceID;
		this.stid = stid;
		this.stName = stName;
		this.serviceTitle = serviceTitle;
		this.userName = userName;
		this.collectionTime = collectionTime;
	}
	
	
}
