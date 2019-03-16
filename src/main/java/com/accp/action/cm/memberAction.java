/**
 * 
 * @ClassName:memberAction
 * @description:TODO
 * @author lenovo
 * @date 2019年3月12日
 * @version V1.0
 */
package com.accp.action.cm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.cm.AreaBiz;
import com.accp.biz.cm.memberBiz;
import com.accp.pojo.Sharea;
import com.accp.vo.cm.ForwardVo;
import com.accp.vo.cm.HuiyuanVo;
import com.accp.vo.cm.IntegralVo;
import com.accp.vo.cm.PutforwardrecordVo;
import com.accp.vo.cm.RecordVo;
import com.accp.vo.cm.ServiceCollectVo;
import com.accp.vo.cm.VipVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* @author 作者
* @version 创建时间：2019年3月12日 下午6:46:59
* 类说明
*/
/**
 * 
 * @ClassName:memberAction
 * @description:TODO
 * @author lenovo
 * @date 2019年3月12日
 * @version V1.0
 */
//会员管理
@RestController
@RequestMapping("/c/cmmember")
public class memberAction {
	@Autowired
	private memberBiz biz;
	@Autowired
	private AreaBiz abiz;
	//查询所有会员即会员审核
	@RequestMapping(value="/users/{num}/{size}/{userNickName}",method=RequestMethod.GET)
	public PageInfo<HuiyuanVo> getUserList(@PathVariable Integer num,@PathVariable Integer size, @PathVariable String userNickName) {
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=13;
		}
		if (userNickName.equals("0")) {
			userNickName = null;
		}
		return biz.findUserListByPage(num, size, userNickName);
	}
	//统计总金币数和积分数
	@RequestMapping(value="/users/sum/{userNickName}",method=RequestMethod.GET)
	public Map<String,Object> summmoney(@PathVariable String userNickName) {
		Map<String, Object> message = new HashMap<String, Object>();
		if (userNickName.equals("0")) {
			userNickName = null;
		}
		float jinbi=biz.summmoney(userNickName);
		float jifen=biz.sumjifen(userNickName);
		message.put("jinbi", jinbi);
		message.put("jifen", jifen);
		return message;
	}
	//根据编号找到会员对象
	@RequestMapping(value="/users/user/{userID}",method=RequestMethod.GET)
	public VipVo queryVipById(@PathVariable int userID) {
		return biz.queryVipById(userID);
	}
	//修改
	@PutMapping("updateuser")
	public Map<String, String> updateUserinfo(@RequestBody VipVo vo) {
		Map<String, String> message = new HashMap<String, String>();
		biz.updatememberInfo(vo);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	//服务收藏
	@GetMapping("serviceCollect")
	public PageInfo<ServiceCollectVo> serviceCollect(String userName,String serviceTitle,String stname,Integer num, Integer size){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=13;
		}
		if(userName=="") {
			userName=null;
		}
		if(serviceTitle=="") {
			serviceTitle=null;
		}
		PageHelper.startPage(num, size);
		return biz.serviceCollect(userName,serviceTitle,stname,num,size);
	}
	//提现申请
	@GetMapping("querytixian")
	public PageInfo<PutforwardrecordVo> querytixian(String userName,Integer num, Integer size){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if(userName=="") {
			userName=null;
		}
		PageHelper.startPage(num, size);
		return biz.findtixian(userName, num, size);
	}
	//找到提现对象
	@GetMapping("loadforward")
	public ForwardVo queryForward(int userID,String Time) {
		return biz.queryForward(userID,Time);
	}
	//提现审核
	@PutMapping("updateForward")
	public Map<String, String> updateForward(@RequestBody ForwardVo vo) {
		Map<String, String> message = new HashMap<String, String>();
		biz.updateForward(vo);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	//地区联动
	@GetMapping("queryArea")
	public Map<String, Object> queryArea(Integer id,String param){
		Map<String, Object> message = new HashMap<String, Object>();
		List<Sharea> sheng=new ArrayList<Sharea>();
		List<Sharea> area=new ArrayList<Sharea>();
		if(param=="shengid") {
			sheng=abiz.queryAllArea(id);
		}
		else if(param=="areaid") {
			area=abiz.queryById(id);
		}
		message.put("shengid", sheng);
		message.put("areaid", area);
		return message;
	}
	//积分记录
	@GetMapping("queryIntegral")
	public PageInfo<IntegralVo> queryIntegral(Integer num, Integer size,String userName) {
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		PageHelper.startPage(num, size);
		return biz.queryIntegral(num, size, userName);
	}
	//充值记录
	@GetMapping("queryRecharge")
	public PageInfo<RecordVo> queryRecharge(Integer num, Integer size,String userName,Integer acquisitionMode){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		PageHelper.startPage(num, size);
		return biz.queryRecharge(num, size, userName, acquisitionMode);
	}
}
