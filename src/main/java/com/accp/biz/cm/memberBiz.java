/**
 * 
 * @ClassName:memberBiz
 * @description:TODO
 * @author lenovo
 * @date 2019年3月11日
 * @version V1.0
 */
package com.accp.biz.cm;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.cm.IUserDaoCm;
import com.accp.vo.cm.HuiyuanVo;
import com.accp.vo.cm.IntegralVo;
import com.accp.vo.cm.ServiceCollectVo;
import com.accp.vo.cm.VipVo;
import com.accp.vo.cm.ForwardVo;
import com.accp.vo.cm.PutforwardrecordVo;
import com.accp.vo.cm.RecordVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* @author 作者
* @version 创建时间：2019年3月11日 下午3:38:54
* 类说明
*/
/**
 * 
 * @ClassName:memberBiz
 * @description:TODO
 * @author lenovo
 * @date 2019年3月11日
 * @version V1.0
 */
@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class memberBiz {
	@Autowired
	private IUserDaoCm dao;
	//根据用户昵称查询
	public PageInfo<HuiyuanVo> findUserListByPage(Integer pageNum, Integer pageSize,String userNickName) {
		PageHelper.startPage(pageNum, pageSize);
			return new PageInfo<HuiyuanVo>(dao.queryUser(userNickName));
	}
	//查询总金币数和积分数
	public float summmoney(String userNickName) {
		return dao.summmoney(userNickName);
	}
	public float sumjifen( String userNickName) {
		return dao.sumjifen(userNickName);
	}
	//根据编号找到会员对象
	public VipVo queryVipById(int userID) {
		return dao.qeuryByUserId(userID);
	}
	//修改
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void updatememberInfo(VipVo vo) {
		dao.updatememberInfo(vo);
	}
	//服务收藏
	public PageInfo<ServiceCollectVo> serviceCollect(String userName,String serviceTitle,String stname,Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<ServiceCollectVo>(dao.serviceCollect(userName,serviceTitle,stname));
	}
	//提现申请
	public PageInfo<PutforwardrecordVo> findtixian(String userName,Integer auditStatus,Integer num,Integer size){
		PageHelper.startPage(num,size);
		return new PageInfo<PutforwardrecordVo>(dao.querytixian(userName,auditStatus));
	}
	public ForwardVo queryForward(int userID,String Time) {
		return dao.queryForward(userID,Time);
	}
	//审核提现，新增提现信息
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void updateForward(ForwardVo vo) {
		dao.updateForward(vo);
	}
	//积分记录
	public PageInfo<IntegralVo> queryIntegral(Integer pageNum, Integer pageSize,String userName) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<IntegralVo>(dao.queryIntegral(userName));
	}
	//充值记录
	public PageInfo<RecordVo> queryRecharge(Integer pageNum, Integer pageSize,String userName,Integer acquisitionMode,Integer auditStatus){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<RecordVo>(dao.queryRecharge(userName,acquisitionMode,auditStatus));
	}
}
