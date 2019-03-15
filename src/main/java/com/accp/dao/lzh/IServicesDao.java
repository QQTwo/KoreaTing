package com.accp.dao.lzh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.vo.lzh.ServiceVo;
import com.accp.pojo.Servicetype;
import com.accp.vo.lzh.AuditVo;
import com.accp.vo.lzh.ComplaintVo;
import com.accp.vo.lzh.RefundVo;
import com.accp.vo.lzh.ReimburseVo;


public interface IServicesDao {
	/**
	 * 
	 * @Name findAllServiceVo
	 * @description 查询服务vo 用户服务审核信息表
	 * @return
	 */
	public List<ServiceVo> findAllServiceVo(@Param("stid") Integer stid,@Param("auditStatus") Integer auditStatus,@Param("serviceTitle") String serviceTitle,@Param("releaseTimeP") String releaseTimeP,@Param("releaseTimeM") String releaseTimeM);
	
	/**
	 * 
	 * @Name updateadminstatus
	 * @description 修改服务多项状态
	 * @return
	 */
	public int updateadminstatus(@Param("serviceid")int serviceid,@Param("adminopinion")String adminopinion,@Param("tuijian")int tuijian,@Param("shenhe")int shenhe,@Param("yingye")int yingye,@Param("status")int status);
	
	/**
	 * 退款管理
	 */
	public List<ReimburseVo> queryreimburse(@Param("username")String username,@Param("refundid")Integer refundid,@Param("datestart")String datestart,@Param("dateend")String dateend,@Param("status")Integer status);
	/**
	 * 
	 * @Name queryRefundByID
	 * @description 退款记录
	 * @param orderID
	 * @return
	 */
	public RefundVo queryRefundByID(@Param("orderID")String orderID);
	
	/**
	 * 查询服务审核
	 */
	public AuditVo querybyid(@Param("serviceid")Integer serviceid);
	
	/**
	 * 
	 * @Name queryComlaintVo
	 * @description 服务投诉
	 * @param titile
	 * @return
	 */
	public List<ComplaintVo> queryComlaintVo(@Param("title") String title);
	 
	/**
	 * 删除
	 */
	public void modifyComlaint(@Param("cid")Integer cid);
	
	/**
	 * 
	 * @Name selectPrimary
	 * @description 服务一级菜单
	 */
	public List<Servicetype> selectPrimaryServiceType();
	
	public List<Servicetype> selectSecondServiceType(@Param("stid")String stid);
	
	public boolean updateRefund(@Param("vo")RefundVo vo,@Param("money")float money,@Param("shopID")int shopID);
	
	public int queryShopUserID(@Param("orderID")String orderID);
}
