/**
 * 
 * @ClassName:serviceTypeIDao
 * @description:TODO
 * @author lenovo
 * @date 2019年2月20日
 * @version V1.0
 */
package com.accp.dao.cm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Servicelevel;
import com.accp.pojo.Servicetype;
import com.accp.vo.cm.auditVo;
import com.accp.vo.cm.levelVo;
import com.accp.vo.cm.reimburseVo;
import com.accp.vo.cm.serviceVo;




/**
* @author 作者
* @version 创建时间：2019年2月20日 上午9:53:39
* 类说明
*/
/**
 * 
 * @ClassName:serviceTypeIDao
 * @description:TODO
 * @author lenovo
 * @date 2019年2月20日
 * @version V1.0
 */
public interface serviceTypeIDao {
		//查询类别名称
		public List<Servicetype> querystname();
		//加载下拉列表
		public List<Servicetype> selType();
		//服务类别管理
		public List<Servicetype> querytype(@Param("stid") Integer stid);
		//展开二级服务类别管理
		public List<Servicetype> queryNtype(@Param("stpid") Integer stpid);
		//服务级别管理
		public List<levelVo> querylevel(@Param("stid") Integer stid);
		//删除服务类别
		public int deletetype(@Param("stid") int stid);
		//查询需要修改的服务类别
		public Servicetype querytypebyid(@Param("stid") int stid);
		//修改服务类别
		public void updatetype(@Param("seltype") Servicetype seltype);
		//新增服务类别
		public void addseltype(@Param("seltype") Servicetype seltype);
		//修改服务类别：【即修改名称，排序 和是否显示】
		public void updateseltype(@Param("seltype") Servicetype seltype);
		//删除服务类别【即修改状态为不显示，后台管理员能看到，用户看不到】
		public void delseltype(@Param("stid") Integer stid);
		//新增服务级别
		public void addsellevel(@Param("sellevel") Servicelevel sellevel);
		//查询要修改的服务级别对象
		public Servicelevel loadsellevelByid(@Param("serlevelid") Integer serlevelid);
		//修改服务级别
		public void updatesellevel(@Param("sellevel") Servicelevel sellevel);
		//删除服务级别
		public void delsellevel(@Param("serlevelid") Integer serlevelid);
		//服务类型预约查询
		public List<serviceVo> queryallorder(@Param("san") String san,@Param("datestart") String datestart,@Param("dateend") String dateend,@Param("stname") String stname,@Param("status") Integer status);
		//服务类型预约查看详情
		public serviceVo queryorderDetail(@Param("orderid") String orderid);
		//服务审核管理
		public List<Servicetype> querytyp();
		//服务审核
		public List<Servicetype> queryaudit();
		//服务预约部分总订单数
		public int countdingdan(@Param("san") String san,@Param("datestart") String datestart,@Param("dateend") String dateend,@Param("stname") String stname,@Param("status") Integer status);
		//服务类型预约总金币数
		public float countjinbi(@Param("san") String san,@Param("datestart") String datestart,@Param("dateend") String dateend,@Param("stname") String stname,@Param("status") Integer status);
}
