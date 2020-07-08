package hzcc.web.action;


import hzcc.domain.Order;
import hzcc.domain.Qipaishi;
import hzcc.service.IOrderService;
import hzcc.service.impl.QipaishiServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xpath.internal.operations.Or;
public class OrderAction extends ActionSupport {
	private IOrderService orderService;
	private Order order=new Order();
	private String message;
	private List<Order> orders;
	private Long number;
	
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getNumber() {
		return number;
	}


	public void setNumber(Long number) {
		this.number = number;
	}


	public String save() {
		System.out.println("OrderAction中的save方法执行了......");
//		number=findOrderNum();
//		if(number+order.getNumber()>3) {
//			message="票数超出3，投票失败！";
//		}else {
			orderService.save(order);
			message="下单成功！";
//		}
		return SUCCESS;
	}
	public String findAll(){
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Order.class);
		System.out.println(order);
		if(order.getVipid()!=null) {
			dCriteria.add(Restrictions.eq("vipid", order.getVipid()));
		}
		orders=orderService.findAll(dCriteria);
		return "findAll";
	}

	public String findAllGroupBydepart(){
		System.out.println("------OrderAction中的findAllGroupBydepart方法执行了......");
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Order.class);
		List<Object[]> list=orderService.findOrdersNumGroupByDepart(dCriteria);

		orders=new ArrayList<Order>();	
		for(Object[] c:list) {
			Order order=new Order();
			order.setId((Long)c[0]);
			order.setVipid((Long)c[1]);
			order.setQipaishiid((Long)c[2]);
			order.setNumber((Integer)c[3]);
			order.setData((String)c[4]);
			order.setTime((String)c[5]);
			order.setCost((String)c[6]);
			
			orders.add(order);
		}	
		return "findAllSum";
	}
	public String findOrderNumByUserid() {
		System.out.println(order);

		number=findOrderNum();
		System.out.println(number);
		return "findNumByUserid";
	}
	
	public long findOrderNum() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Order.class);
		if(order.getVipid()!=null) {
			dCriteria.add(Restrictions.eq("vipid", order.getVipid()));
		}
		return orderService.findOrdersNum(dCriteria);
	}
	/**
	 * 跳转到场地修改页面
	 * @return
	 */
	public String editUI() {
		//根据id查找要编辑的客户信息
		//使用模型接收
		order= orderService.findOrderById(order.getId());
		return "editUI";
	}
	/**
	 * 删除
	 * @return
	 */
	public String removeOrder() {
		System.out.println("----removOrder---");
		System.out.println(order);
		System.out.println(order.getId());
		orderService.removeOrder(order.getId());	
		return "list";
	}
	/**
	 * /**
	 * 更新
	 * @return
	 */
	public String update() {
		orderService.update(order);
		System.out.print(order);
		return SUCCESS;
	}
}
