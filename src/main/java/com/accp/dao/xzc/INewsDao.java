package com.accp.dao.xzc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.User;
import com.accp.vo.xzc.newsVo;

public interface INewsDao {
	//查询id
		public int queryname(@Param("userrealName") String userrealName);
	//查询信件
	public List<newsVo> querynewsall(@Param("userid") Integer userid);
	//站内信管理
			/**
			 * 批量新增站内信
			 * @param ids
			 * @return
			 */
			public int addNews(@Param("ids")String[] ids,@Param("content")String content,@Param("userid")Integer userid);
			
			/**
			 * 获得用户信息
			 * @param userName
			 * @return
			 */
			public List<User> queryAllUserLike(@Param("userName")String userName);
}
