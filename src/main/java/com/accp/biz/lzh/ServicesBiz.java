package com.accp.biz.lzh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.lzh.IServicesDao;
import com.accp.vo.lzh.ServiceVo;
import com.accp.vo.lzh.AuditVo;
import com.accp.vo.lzh.ComplaintVo;
import com.accp.vo.lzh.RefundVo;
import com.accp.vo.lzh.ReimburseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class ServicesBiz {
	
	@Autowired
	private IServicesDao dao;
	/**
	 * 
	 * @Name findServiceVo
	 * @description 查询审核信息
	 * @return
	 */
	public List<ServiceVo> findServiceVo(Integer stid,Integer auditStatus,String serviceTitle,String releaseTimeP,String releaseTimeM){
		return dao.findAllServiceVo(stid, auditStatus, serviceTitle, releaseTimeP, releaseTimeM);
	}
	/**
	 * 
	 * @Name modifyServicesSta
	 * @description 修改服务
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int modifyServicesSta(int serviceid,int shenhe,String adminopinion,int tuijian,int yingye,int status) {
		return dao.updateadminstatus(serviceid, adminopinion, tuijian, shenhe, yingye,status);
	}
	
	/**
	 * 查询退款
	 */
	public List<ReimburseVo> findreimburse(String username,Integer refundid,String datestart,String dateend,Integer status){
		return dao.queryreimburse(username, refundid, datestart, dateend, status);
	}
	/**
	 * 退款记录
	 */
	public RefundVo findByid(String orderId) {
		return dao.queryRefundByID(orderId);
	}
	/**
	 * 查询服务审核byid
	 */
	public AuditVo findAuditVoBy(int serviceId) {
		return dao.querybyid(serviceId);
	}
	
	public List<ComplaintVo> findComplaintVo(String title){
		return dao.queryComlaintVo(title);
	}
	
	public void modifyComlaint(Integer cid) {
		 dao.modifyComlaint(cid);
	}
}
