package com.accp.biz.xzc;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.xzc.ISjDao;
import com.accp.pojo.Appraisalapply;
import com.accp.pojo.User;
import com.accp.vo.xzc.appVo;
import com.accp.vo.xzc.userVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)

public class sjBiz {
	@Autowired
	private ISjDao sj;
	
	public PageInfo<userVo> queryAllUser(Integer PageNum,Integer PageSize,int auditstatus,int merchanttype,String username){
		PageHelper.startPage(PageNum, PageSize);
		return new PageInfo<userVo>(sj.queryAllUser(auditstatus,merchanttype,username));
	}
	public userVo queryAllUser(int userid){
		return sj.queryUser(userid);
	}
	public List<appVo> queryAllAppraisalApply(int auditstatus){
		return sj.queryAllAppraisalApply( auditstatus);
	}
	public appVo queryAppraisalApply(int userid){
		return sj.queryAppraisalApply(userid);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void updata(int userid){
		sj.updatash(userid);
	}
}
