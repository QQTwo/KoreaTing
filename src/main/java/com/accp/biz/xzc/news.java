package com.accp.biz.xzc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.xzc.INewsDao;
import com.accp.vo.xzc.newsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class news {
	@Autowired
	private INewsDao news;
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int queryname(String userrealName){
		return news.queryname(userrealName);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public PageInfo<newsVo> querynewsall(Integer PageNum,Integer PageSize,Integer userid){
		PageHelper.startPage(PageNum, PageSize);
		return new PageInfo<newsVo>(news.querynewsall(userid));
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public boolean addNews(String[] ids,String content,Integer userid) {
		return news.addNews(ids, content,userid)>0;
	}
}
