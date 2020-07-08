package hzcc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.Order;


public interface IOrderService {
	/**
	 * 查询订单信息列表 				
	 * @param dCriteria		查询的条件
	 * @return
	 */
	public List<Order> findAll(DetachedCriteria dCriteria);
	/**
	 * 按条件查询总订单
	 * @param dCriteria	查询条件
	 * @return
	 */
	public long findOrdersNum(DetachedCriteria dCriteria);
	/**
	 * 分组查询部门总票数
	 * @param dCriteria	查询条件
	 * @return
	 */
	public List<Object[]> findOrdersNumGroupByDepart(DetachedCriteria dCriteria);
	/**
	 * 保存投票信息
	 * @param depart
	 */
	public void save(Order order);
	
	
	void removeOrder(Long long1);
	/**
	 * 根据id查询订单
	 * @param departId
	 * @return
	 */
	Order findOrderById(Long id);
	void update(Order order);
	
}
