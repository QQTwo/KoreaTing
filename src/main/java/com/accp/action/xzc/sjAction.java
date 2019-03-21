package com.accp.action.xzc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.xzc.sjBiz;
import com.accp.pojo.Appraisalapply;
import com.accp.pojo.User;
import com.accp.vo.xzc.appVo;
import com.accp.vo.xzc.postVo;
import com.accp.vo.xzc.userVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/sj")
public class sjAction {
	@Autowired
	private sjBiz sj;
	
	@RequestMapping(value="/users/{num}/{size}/{auditstatus}/{merchanttype}/{username}",method=RequestMethod.GET)
	public PageInfo<userVo> getuser(@PathVariable Integer num,@PathVariable Integer size,@PathVariable Integer auditstatus,@PathVariable Integer merchanttype,@PathVariable String username) {
		System.out.println("=========");
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if(auditstatus==null ||auditstatus==0) {
			auditstatus=0;
		}
		if(merchanttype==null ||merchanttype==0) {
			merchanttype=0;
		}
		if(username==null||username.equals("@*")) {
			username=null;
		}
		System.out.println(auditstatus);
		System.out.println(merchanttype);
		System.out.println(username);
		PageInfo<userVo> pageinfo=sj.queryAllUser(num, size, auditstatus, merchanttype, username);
		return pageinfo;
	}
	@RequestMapping(value="/users/{userid}",method=RequestMethod.GET)
	public userVo getuser(@PathVariable int userid) {
		return sj.queryAllUser(userid);
	}
	
	@RequestMapping(value="/jd/{num}/{size}/{auditstatus}",method=RequestMethod.GET)
	public PageInfo<appVo> ajaxAla(@PathVariable Integer num,@PathVariable Integer size ,@PathVariable Integer auditstatus) {
		
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if(auditstatus==null ||auditstatus==0) {
			auditstatus=0;
		}
		PageHelper.startPage(num, size);
		return new PageInfo<appVo>(sj.queryAllAppraisalApply( auditstatus));
	}
	@RequestMapping(value="/jd/{userid}",method=RequestMethod.GET)
	public int updatash(@PathVariable Integer userid) {
		sj.updata(userid);
		return 1;
	}
	@RequestMapping(value="/jdc/{userid}",method=RequestMethod.GET)
	public appVo queryAppraisalApply(@PathVariable Integer userid) {
		return sj.queryAppraisalApply(userid);
	}
	
}
