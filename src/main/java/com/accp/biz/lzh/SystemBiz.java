package com.accp.biz.lzh;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.lzh.IsystemDao;
import com.accp.pojo.System;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.SUPPORTS,readOnly=true)
public class SystemBiz {
	
	@Resource
	private IsystemDao dao;
	
	public List<System>  findAllSystem(){
		return dao.selectAll();
	}
}
