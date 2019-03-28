package com.accp.dao.lzh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Statistics;
import com.accp.vo.lzh.StatisticsVo;

public interface IStatisticsDao {
	
	/**
	 * 定时添加数据 
	 */
	public void insertStatistics();
	
	public List<StatisticsVo> findStatistics(@Param("year") int year,@Param("state")int state,@Param("month") int month);
}
