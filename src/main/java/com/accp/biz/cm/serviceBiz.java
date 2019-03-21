package com.accp.biz.cm;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.dao.cm.serviceTypeIDao;
import com.accp.pojo.Servicelevel;
import com.accp.pojo.Servicetype;
import com.accp.vo.cm.auditVo;
import com.accp.vo.cm.levelVo;
import com.accp.vo.cm.reimburseVo;
import com.accp.vo.cm.serviceVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class serviceBiz {
	@Autowired
	private serviceTypeIDao isd;
	//查询所有服务类别名称
	public List<Servicetype> querystname(){
		return isd.querystname();
	}
	//删除服务类别
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int deletetype(int stid){
		return isd.deletetype(stid);
	}
	//根据编号查询服务类别
	public List<Servicetype> querytype(Integer stid){
		List<Servicetype> list=isd.querytype(stid);
		return list;
	}
	//加载一级服务下拉列表
	public List<Servicetype> selType(){
		List<Servicetype> list=isd.selType();
		return list;
	}
	public List<Servicetype> queryNtype(Integer stpid){
		List<Servicetype> list=isd.queryNtype(stpid);
		return list;
	}
	//服务级别查询
	public PageInfo<levelVo> querylevel(Integer stid,Integer PageNum,Integer PageSize){
		PageHelper.startPage(PageNum,PageSize);
		return new PageInfo<levelVo>(isd.querylevel(stid));
	}
	//查询要修改的服务对象
	public Servicetype querytypebyid(int stid){
		return isd.querytypebyid(stid);
	}
	//新增服务类别
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void addseltype(Servicetype seltype) {
		isd.addseltype(seltype);
	}
	
	//修改服务类别：【即修改名称，排序 和是否显示】
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void updateseltype(Servicetype seltype) {
		isd.updateseltype(seltype);
	}
	//删除服务类别【即修改状态为不显示，后台管理员能看到，用户看不到】
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void delseltype(Integer stid) {
		isd.delseltype(stid);
	}
	//新增服务级别
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void addsellevel(Servicelevel sellevel) {
		isd.addsellevel(sellevel);
	}
	//查询要修改的服务级别对象
	public Servicelevel loadsellevelByid(Integer serlevelid) {
		return isd.loadsellevelByid(serlevelid);
	}
	//修改服务级别
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void updatesellevel(Servicelevel sellevel) {
		isd.updatesellevel(sellevel);
	}
	//删除服务级别
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void delsellevel(Integer serlevelid) {
		isd.delsellevel(serlevelid);
	}
	//服务类型预约查询
	public PageInfo<serviceVo> queryallorder(String san,String datestart,String dateend,String stname,Integer status,Integer PageNum,Integer PageSize){
		PageHelper.startPage(PageNum, PageSize);
		return new PageInfo<serviceVo>(isd.queryallorder(san, datestart, dateend, stname, status));
	}
	public int countdingdan(String san,String datestart,String dateend,String stname,Integer status) {
		return isd.countdingdan(san, datestart, dateend, stname, status);
	}
	public float countjinbi(String san,String datestart,String dateend,String stname,Integer status) {
		return isd.countjinbi(san, datestart, dateend, stname, status);
	}
	//服务类型预约查看详情
	public serviceVo queryorderDetail(String orderid){
		return isd.queryorderDetail(orderid);
	}
	//服务审核
	public PageInfo<Servicetype> queryaudit(Integer PageNum,Integer PageSize){
		PageHelper.startPage(PageNum, PageSize);
		return new PageInfo<Servicetype>(isd.queryaudit());
	}
}
