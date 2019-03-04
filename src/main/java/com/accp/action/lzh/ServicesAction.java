package com.accp.action.lzh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.lzh.ServicesBiz;
import com.accp.vo.lzh.AuditVo;
import com.accp.vo.lzh.ComplaintVo;
import com.accp.vo.lzh.RefundVo;
import com.accp.vo.lzh.ReimburseVo;
import com.accp.vo.lzh.ServiceVo;

@RestController
@RequestMapping("/c/lzh/service")
public class ServicesAction {
	
	@Autowired
	private ServicesBiz biz;
	
	/**
	 * 
	 * @Name findServicesVo
	 * @description 查看审核vo
	 * @return
	 */
	@PostMapping("/servicesInfo")
	public List<ServiceVo> findServicesVo(@RequestBody ServiceVo vo){
		return biz.findServiceVo(vo.getStid(), vo.getAuditStatus(),vo.getServiceTitle(),vo.getReleaseTimeP(),vo.getReleaseTimePM());
	}
	
	/**
	 * 
	 * @Name modifyServicesStatus
	 * @description 修改服务审核
	 */
	@GetMapping("/modifyServicesInfo/{tuijian}/{shenhe}/{yingye}/{adminopinion}/{serviceid}/{status}")
	public String modifyServicesStatus(@PathVariable int tuijian,@PathVariable int shenhe,@PathVariable int yingye,@PathVariable String adminopinion,@PathVariable int serviceid,@PathVariable int status) {
		biz.modifyServicesSta(serviceid, shenhe, adminopinion, tuijian, yingye,status);
		return "ok";
	}
	
	/**
	 * 查询退款
	 */
	@PostMapping("/reimburseInfo")
	public List<ReimburseVo> findreimburse(@RequestBody ReimburseVo vo){
		return biz.findreimburse(vo.getUsername(),vo.getRefundid(),vo.getDateStart(),vo.getDateEnd(),vo.getRefundstatus());
	}
	
	/**
	 * 退款记录
	 */
	@GetMapping("/findFunByOrderId/{orderId}")
	public RefundVo findByfunOrderId(@PathVariable String orderId) {
		return biz.findByid(orderId);
	}
	
	/**
	 * 服务审核byid
	 */
	@GetMapping("/findAuitVoByid/{serviceId}")
	public AuditVo findAuitVoByid(@PathVariable Integer serviceId) {
		return biz.findAuditVoBy(serviceId);
	}
	
	@GetMapping("/findComplaintVo/{title}")
	public List<ComplaintVo> findComplaintVo(@PathVariable String title){
		if(title.equals("title")) 
			return biz.findComplaintVo(null);
		else
			return biz.findComplaintVo(title);
	}
	
	@PutMapping("/modifyComlain/{cid}")
	public String modifyComlain(@PathVariable Integer cid) {
		biz.modifyComlaint(cid);
		return "ok";
	}
}
