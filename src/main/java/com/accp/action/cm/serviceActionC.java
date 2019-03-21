package com.accp.action.cm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.cm.serviceBiz;
import com.accp.pojo.Servicelevel;
import com.accp.pojo.Servicetype;
import com.accp.vo.cm.levelVo;
import com.accp.vo.cm.serviceVo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;


@RequestMapping("c/cmservice")
@RestController
public class serviceActionC {
	@Autowired
	private serviceBiz sb;
	
	@GetMapping("querytype")
	public List<Servicetype> querytype(Integer stid) {
		return sb.querytype(stid);
	}
	@GetMapping("queryNtype")
	public List<Servicetype> queryNtype(Integer stpid) {
		System.out.println("排序编号："+stpid);
		return sb.queryNtype(stpid);
	}
	@GetMapping("selType")
	public List<Servicetype> selType() {
		return sb.selType();
	}
	//新增服务类别
	@PostMapping("saveseltype")
	public Map<String,Object> saveseltype(@RequestBody Servicetype seltype){
		Map<String, Object> message = new HashMap<String, Object>();
		sb.addseltype(seltype);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	//服务级别查询
	@GetMapping("querylevel")
	public PageInfo<levelVo> querylevel(Integer stid,Integer PageNum,Integer PageSize,Model model) {
		if(PageNum==null) {
			PageNum=1;
		}
		if(PageSize==null) {
			PageSize=100;
		}
		PageInfo<levelVo> pageinfo=sb.querylevel(stid,PageNum, PageSize);
		model.addAttribute("PAGE_INFO",pageinfo);
		return pageinfo;
	}
	@GetMapping("querytypebyid")
	public Servicetype querytypebyid(int stid,Model model) {
		Servicetype st=sb.querytypebyid(stid);
		model.addAttribute("ST", st);
		return st;
	}
	//修改服务类别：【即修改名称，排序 和是否显示】
	@PutMapping("updateseltype")
	public Map<String,String> updateseltype(@RequestBody Servicetype seltype){
		Map<String, String> message = new HashMap<String, String>();
		sb.updateseltype(seltype);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	//删除服务类别【即修改状态为不显示，后台管理员能看到，用户看不到】
	@DeleteMapping("delseltype")
	public Map<String,String> delseltype(Integer stid){
		Map<String, String> message = new HashMap<String, String>();
		sb.delseltype(stid);
		message.put("code","200");
		message.put("msg", "ok");
		return message;
	}
	//新增服务级别
	@PostMapping("addsellevel")
	public Map<String,String> addsellevel(@RequestBody Servicelevel sellevel){
		Map<String,String> message=new HashMap<String,String>();
		sb.addsellevel(sellevel);
		message.put("code","200");
		message.put("msg", "ok");
		return message;
	}
	//查询要修改的服务级别对象
	@GetMapping("loadsellevelByid")
	public Servicelevel loadsellevelByid(Integer serlevelid) {
		return sb.loadsellevelByid(serlevelid);
	}
	//修改服务级别
	@PutMapping("updatesellevel")
	public Map<String,String> updatesellevel(@RequestBody Servicelevel sellevel){
		Map<String,String> message=new HashMap<String,String>();
		sb.updatesellevel(sellevel);
		message.put("code","200");
		message.put("msg", "ok");
		return message;
	}
	//删除服务级别
	@DeleteMapping("delsellevel")
	public Map<String,String> delsellevel(Integer serlevelid){
		Map<String,String> message=new HashMap<String,String>();
		sb.delsellevel(serlevelid);
		message.put("code","200");
		message.put("msg", "ok");
		return message;
	}
	//服务类型预约查询
	@GetMapping("queryallorder")
	public PageInfo<serviceVo> queryallorder(String san,String datestart,String dateend,String stname,Integer status,Integer PageNum,Integer PageSize){
		if(PageNum==null) {
			PageNum=1;
		}
		if(PageSize==null) {
			PageSize=10;
		}
		if(san=="") {
			san=null;
		}
		System.out.println("数据："+san+"\t"+datestart+"\t"+dateend+"\t"+stname+"\t"+status+"\t"+PageNum+"\t"+PageSize);
		PageInfo<serviceVo> pageinfo=sb.queryallorder(san, datestart, dateend, stname, status, PageNum, PageSize);
		System.out.println(JSON.toJSONString(pageinfo));
		return pageinfo;
	}
	//服务类型预约查看详情
	@GetMapping("queryorderDetail")
	public serviceVo queryorderDetail(String orderid){
		return sb.queryorderDetail(orderid);
	}
	//服务审核
	@GetMapping("queryaudit")
	public PageInfo<Servicetype> queryaudit(Integer PageNum,Integer PageSize){
		if(PageNum==null) {
			PageNum=1;
		}
		if(PageSize==null) {
			PageSize=10;
		}
		PageInfo<Servicetype> pageinfo=sb.queryaudit(PageNum, PageSize);
		return pageinfo;
	}
	@GetMapping("countMoney")
	public Map<String,Object> countMoney(String san,String datestart,String dateend,String stname,Integer status){
		Map<String,Object> message=new HashMap<String,Object>();
		if(san=="") {
			san=null;
		}
		int dingdan=sb.countdingdan(san, datestart, dateend, stname, status);
		float jinbi=sb.countjinbi(san, datestart, dateend, stname, status);
		message.put("dingdan",dingdan);
		message.put("jinbi", jinbi);
		return message;
	}
}
