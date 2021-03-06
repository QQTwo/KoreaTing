package com.accp.action.gsq;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.gsq.OrderBiz;
import com.accp.biz.gsq.UserBiz;
import com.accp.pojo.User;
import com.accp.util.file.Upload;
import com.accp.pojo.Evaluationservice;
import com.accp.vo.gsq.Orders;
import com.accp.vo.gsq.Refund;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/gsq")
public class OrderAction {
	@Autowired
	private OrderBiz orderBiz;
	@Autowired
	private UserBiz userBiz;

	/**
	 * 确认支付订单
	 * 
	 * @param orderid
	 *            订单编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/order/pay/ok")
	public String payOk(@RequestParam(required = true) String orderid, HttpSession session) {
		// 用户扣款，更新订单状态，付款时间
		// 交易额，金币记录，站内信商家
		Integer userId = ((User) session.getAttribute("USER")).getUserid();
		Orders order = orderBiz.queryOrderById(orderid);
		Orders updateOrder = new Orders();
		updateOrder.setOrderid(orderid);
		updateOrder.setOrderstatus(2);
		updateOrder.setPaymenttime(new Date());
		orderBiz.payOrder(order.getSmallplan(), userId, updateOrder);
		return "redirect:/c/gsq/order/query/list";
	}

	/**
	 * 取消订单
	 * 
	 * @param page
	 *            页数
	 * @param orderid
	 *            模糊订单号
	 * @param updateid
	 *            订单编号
	 * @return
	 */
	@RequestMapping("/order/cancel")
	public String cancel(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "") String orderid, @RequestParam(required = true) String updateid) {
		Orders order = new Orders();
		order.setOrderid(updateid);
		order.setOrderstatus(6);
		orderBiz.cancelOrder(order);
		return "redirect:/c/gsq/order/query/list?page=" + page + "&orderid=" + orderid;
	}

	/**
	 * 确认完成
	 * 
	 * @param page
	 *            页数
	 * @param orderid
	 *            模糊订单号
	 * @param updateid
	 *            订单编号
	 * @return
	 */
	@RequestMapping("/order/ok")
	public String ok(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "") String orderid,
			@RequestParam(required = true) String updateid) {
		// 商家入款，更新订单状态，完成时间
		// 金币记录，站内信商家
		Orders order = orderBiz.queryOrderById(updateid);
		Orders updateOrder = new Orders();
		updateOrder.setOrderid(updateid);
		updateOrder.setOrderstatus(5);
		updateOrder.setCompletetime(new Date());
		updateOrder.setCommentstatus(1);
		updateOrder.setRefundstatus(0);
		orderBiz.ok(order.getSmallplan(), order.getService().getUser().getUserid(), updateOrder);
		return "redirect:/c/gsq/order/query/list?page=" + page + "&orderid=" + orderid;
	}

	/**
	 * 确认评价
	 * 
	 * @param evaluate
	 *            评价
	 * @param orderid
	 *            订单编号
	 * @return
	 */
	@RequestMapping("/order/evaluate/ok")
	public String evaluateOk(Evaluationservice evaluate, String orderid, HttpSession session) {
		// 新增评价信息，修改订单评价状态
		// 站内信
		Integer userId = ((User) session.getAttribute("USER")).getUserid();
		Orders order = orderBiz.queryOrderById(orderid);
		evaluate.setServiceid(order.getService().getServiceid());
		evaluate.setUserid(userId);
		evaluate.setServiceappraisedate(new Date());
		Orders updateOrder = new Orders();
		updateOrder.setOrderid(orderid);
		updateOrder.setCommentstatus(2);
		orderBiz.evaluateOk(evaluate, updateOrder);
		return "redirect:/ylh/c/EvaluationService";
	}

	/**
	 * 确认申请退款
	 * 
	 * @param refund
	 *            退款
	 * @param file
	 *            文件
	 * @param model
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/order/refund/ok")
	public String refundOk(Refund refund, MultipartFile file, Model model, HttpSession session)
			throws IllegalStateException, IOException {
		// 新增退款信息，修改订单退款状态
		// 站内信
		Integer userId = ((User) session.getAttribute("USER")).getUserid();
		refund.setPoint(1);
		refund.setUserid(userId);
		refund.setApplicationtime(new Date());
		if (file != null && !file.isEmpty()) {
			String fileName = Upload.uploadFile(file);
			refund.setRefundimg(fileName);
		}
		refund.setAuditstatus(1);
		Orders order = new Orders();
		order.setOrderid(refund.getOrderid());
		order.setRefundstatus(1);
		orderBiz.refundok(refund, order);
		return "redirect:/c/gsq/refund/detail?orderid=" + refund.getOrderid();
	}

	/**
	 * 以下方法仅查询或跳转页面
	 */

	/**
	 * 查询订单列表
	 * 
	 * @param page
	 *            页数
	 * @param orderid
	 *            模糊订单号
	 * @param status
	 *            订单类型
	 * @param model
	 * @return
	 */
	@RequestMapping("/order/query/list")
	public String queryOrderList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "") String orderid, @RequestParam(defaultValue = "") Integer status,
			@RequestParam(required = false) Integer commentstatus, Model model, HttpSession session) {
		Integer userId = ((User) session.getAttribute("USER")).getUserid();
		Orders order = new Orders();
		order.setUserid(userId);
		order.setOrderid(orderid);
		order.setOrderstatus(status);
		order.setCommentstatus(commentstatus);
		PageInfo<Orders> pageInfo = orderBiz.queryOrderList(order, page, 10);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("orderInfo", orderBiz.queryOrderInfo(userId));
		return "grzx-order";
	}

	/**
	 * 查询订单详情
	 * 
	 * @param orderid
	 *            订单编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/order/query/detail")
	public String queryOrderDetail(@RequestParam(required = true) String orderid, Model model) {
		model.addAttribute("order", orderBiz.queryOrderById(orderid));
		return "grzx-order-detail";
	}

	/**
	 * 支付订单
	 * 
	 * @param orderid
	 *            订单编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/order/pay")
	public String pay(@RequestParam(required = true) String orderid, Model model, HttpSession session) {
		Integer userId = ((User) session.getAttribute("USER")).getUserid();
		model.addAttribute("user", userBiz.queryUserById(userId));
		model.addAttribute("order", orderBiz.queryOrderById(orderid));
		return "grzx-order-pay";
	}

	/**
	 * 评价订单
	 * 
	 * @param orderid
	 *            订单编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/order/evaluate")
	public String evaluate(@RequestParam(required = true) String orderid, Model model) {
		model.addAttribute("order", orderBiz.queryOrderById(orderid));
		return "grzx-order-evaluate";
	}

	/**
	 * 申请退款
	 * 
	 * @param orderid
	 *            订单号
	 * @param model
	 * @return
	 */
	@RequestMapping("/order/refund")
	public String refund(@RequestParam(required = true) String orderid, Model model) {
		model.addAttribute("order", orderBiz.queryOrderById(orderid));
		return "grzx-order-refund";
	}
}