package hzcc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.Order;

public interface IOrderDao {
	/**
	 * 查询订单信息列表 				
	 * @param dCriteria		查询的条件
	 * @return
	 */
	public List<Order> findAll(DetachedCriteria dCriteria);
	/**
	 * 按条件查询总票数
	 * @param dCriteria	查询条件
	 * @return
	 */
	public long findOrdersNum(DetachedCriteria dCriteria);
	/**
	 * 分组查询订单信息
	 * @param dCriteria	查询条件
	 * @return
	 */
	public List<Object[]> findOrdersNumGroupByDepart(DetachedCriteria dCriteria);
	/**
	 * 保存订单信息
	 * @param Order
	 */
	public void save(Order order);
	public void delete(Long id);
	public Order findOrderById(Long id);
	public void update(Order id);

}
