package com.accp.action.xzc;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.xzc.news;
import com.accp.vo.xzc.newsVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/news")
public class newsAction {
	@Autowired
	private news ib;
	
	@GetMapping("getnewslist")
	@ResponseBody
	public PageInfo<newsVo> getinvitation(String userrealName,Integer PageNum,Integer PageSize) {
		Integer userid = null;
		if(userrealName==null||userrealName=="") {
		}else {
			userid = ib.queryname(userrealName);
		}
		if(PageNum==null) {
			PageNum=1;
		}
		if(PageSize==null) {
			PageSize=10;
		}
		PageInfo<newsVo> pageinfo=ib.querynewsall(PageNum, PageSize, userid);
		
		return pageinfo;
	}
	
	@PostMapping("/addNews")
	@ResponseBody
	public Map<String, String> addNews(String sid,String content,Integer userid) {
		String[] ids = sid.split(",");
		Map<String, String> message=new HashMap<String,String>();   
		try {   			
	          ib.addNews(ids, content,userid);
			message.put("code", "200");
			message.put("msg", "ok");
		} catch (Exception ex) {
			message.put("code", "500");
			message.put("msg", ex.getMessage());
		}
		return message;
	}

}
