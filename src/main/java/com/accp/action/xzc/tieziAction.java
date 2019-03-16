package com.accp.action.xzc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.xzc.tieziBiz;
import com.accp.pojo.Forummanagement;
import com.accp.vo.xzc.postVo;
import com.accp.vo.xzc.postglVo;
import com.accp.vo.xzc.posttsVo;
import com.accp.vo.xzc.recordVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/tz")
public class tieziAction {
	@Autowired
	private tieziBiz ib;
	
	@GetMapping("getlist")
	@ResponseBody
	public PageInfo<postVo> getinvitation(String title,String fmname,Integer PageNum,Integer PageSize) {
		if(title==null||title=="") {
			title=null;
		}
		if(fmname==null||fmname=="") {
			fmname=null;
		}else if(fmname.equals("所有的")) {
			fmname=null;
		}
		if(PageNum==null) {
			PageNum=1;
		}
		if(PageSize==null) {
			PageSize=10;
		}
		System.out.println(fmname);
		System.out.println(title);
		PageInfo<postVo> pageinfo=ib.queryallpost(PageNum, PageSize,title,fmname);
		return pageinfo;
	}
	@GetMapping("getnamelist")
	@ResponseBody
	public List<Forummanagement> getinvitation() {
		List<Forummanagement> listinfo=ib.queryfmname();
		System.out.println(listinfo);
		return listinfo;
	}
	@GetMapping("delete")
	@ResponseBody
	public int deletetz(int postid) {
		int a = ib.deletechoose(postid);
		return a;
	}

	@GetMapping("getgllist")
	@ResponseBody
	public PageInfo<postglVo> gettzgl(Integer PageNum,Integer PageSize) {
		if(PageNum==null) {
			PageNum=1;
		}
		if(PageSize==null) {
			PageSize=10;
		}
		PageInfo<postglVo> pageinfo=ib.queryglpost(PageNum, PageSize);
		return pageinfo;
	}
	@GetMapping("gettslist")
	@ResponseBody
	public PageInfo<posttsVo> gettzgl(String title, Integer PageNum,Integer PageSize) {
		if(PageNum==null) {
			PageNum=1;
		}
		if(PageSize==null) {
			PageSize=10;
		}
		if(title==null||title=="") {
			title=null;
		}
		PageInfo<posttsVo> pageinfo=ib.querytspost(PageNum, PageSize,title);
		return pageinfo;
	}
	
	@RequestMapping(value="getGoldList/{p}/{s}/{userName}",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<recordVo> getGoldList(@PathVariable Integer p,@PathVariable Integer s,@PathVariable String userName) {
		if(p==null) {
			p=1;
		}
		if(s==null) {
			s=10;
		}
		if("@*".equals(userName)||userName=="") {
			userName=null;
		}
		PageInfo<recordVo> pageInfo = ib.queryAll(p, s, userName);
		return pageInfo;
	}
}
