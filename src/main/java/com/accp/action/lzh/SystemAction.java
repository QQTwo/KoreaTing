package com.accp.action.lzh;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.lzh.SystemBiz;
import com.accp.pojo.System;

@RestController
@RequestMapping("/c/lzh/system")
public class SystemAction {
	
	@Resource
	private SystemBiz biz;
	
	@GetMapping("/systemInfo")
	public List<System> findAllSystem(){
		return biz.findAllSystem();
	}
}
