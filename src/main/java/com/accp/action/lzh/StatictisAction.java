package com.accp.action.lzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.lzh.StatisticsBiz;
import com.accp.vo.lzh.StatisticsVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/c/lzh/statistics")
public class StatictisAction {
	
	@Autowired
	private StatisticsBiz  biz;
	
	@GetMapping("/StatisticsInfo/{year}/{state}/{pagenum}")
	public PageInfo<StatisticsVo> findStatisticsVo(@PathVariable int year,@PathVariable int state,@PathVariable int pagenum){
		return biz.findStatisticsVo(year, state, pagenum);
	}
}
