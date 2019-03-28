package com.accp.biz.lzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.lzh.IStatisticsDao;
import com.accp.vo.lzh.StatisticsVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class StatisticsBiz {
	@Autowired
	private IStatisticsDao dao;
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void addStatistics() {
		dao.insertStatistics();
	}

	public PageInfo<StatisticsVo> findStatisticsVo(int year,int state,int pagenum,int month){
		PageHelper.startPage(pagenum, 20);
		return new PageInfo<StatisticsVo>(dao.findStatistics(year, state,month));
	}
}
