/**
 * 
 * @ClassName:IUserDao
 * @description:TODO
 * @author lenovo
 * @date 2019年3月11日
 * @version V1.0
 */
package com.accp.dao.cm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.vo.cm.HuiyuanVo;
import com.accp.vo.cm.IntegralVo;
import com.accp.vo.cm.PutforwardrecordVo;
import com.accp.vo.cm.RecordVo;
import com.accp.vo.cm.ServiceCollectVo;
import com.accp.vo.cm.VipVo;
import com.accp.vo.cm.ForwardVo;

/**
* @author 作者
* @version 创建时间：2019年3月11日 下午3:06:29
* 类说明
*/
/**
 * 
 * @ClassName:IUserDao
 * @description:TODO
 * @author lenovo
 * @date 2019年3月11日
 * @version V1.0
 */
public interface IUserDaoCm {
	//会员管理--会员审核（
	public List<HuiyuanVo> queryUser(@Param("userName")String userNickName);
	//统计金币数和积分数
	public float summmoney(@Param("userName")String userNickName);
	public float sumjifen(@Param("userName")String userNickName);
	//根据编号找到会员对象
	public VipVo qeuryByUserId(@Param("userid") int userID);
	//会员审核编辑    
	public void updatememberInfo(@Param("vo") VipVo vo);
	//服务收藏
	public List<ServiceCollectVo> serviceCollect(@Param("userName") String userName,@Param("serviceTitle") String serviceTitle, @Param("stname") String stname);
	//提现申请
	public List<PutforwardrecordVo> querytixian(@Param("userName") String userName,@Param("auditStatus") Integer auditStatus);
	public ForwardVo queryForward(@Param("userID")int userID,@Param("Time")String Time);
	//修改，新增提现信息
	public void updateForward(@Param("vo")ForwardVo vo);
	//积分记录
	public List<IntegralVo> queryIntegral(@Param("userName") String userName);
	//充值记录
	public List<RecordVo> queryRecharge(@Param("userName") String userName,@Param("acquisitionMode") Integer acquisitionMode,@Param("auditStatus") Integer auditStatus);
}
