package com.accp.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.accp.biz.lzh.ServicesBiz;
import com.accp.biz.lzh.StatisticsBiz;
import com.accp.dao.gsq.IUserDao;

/**
 * 
* @ClassName: QuartzRun 
* @Description: 每日6点重置所有用户的签到
* @author 筠颜
* @date 2019年3月18日 下午9:26:11 
*
 */
@Configuration
public class QuartzRun{
	@Autowired
	private  IUserDao dao;
	
	@Autowired
	private StatisticsBiz  biz;

	@Scheduled(cron = "0 0 6 * * ?")
	public void execute() throws JobExecutionException {
		System.err.println("每日6点重置签到");
		dao.updateUserSign(0,0,0);
	}
	
	 /** 
	  * @Name insert
	  * @description 每月1号添加报表记录
	  */
	@Scheduled(cron="0 0 1 1 * ?")
	public void insert() throws JobExecutionException{
		biz.addStatistics();
	}
	
	

}
