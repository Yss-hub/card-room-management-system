package hzcc.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hzcc.dao.IOrderDao;
import hzcc.domain.Order;
import hzcc.service.IOrderService;
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class OrderServiceImpl implements IOrderService{
	private IOrderDao orderDao;

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public List<Order> findAll(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		return orderDao.findAll(dCriteria);
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public long findOrdersNum(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		return orderDao.findOrdersNum(dCriteria);
	}

	@Override
	public List<Object[]> findOrdersNumGroupByDepart(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		return orderDao.findOrdersNumGroupByDepart(dCriteria);
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void removeOrder(Long long1) {
		// TODO Auto-generated method stub
		orderDao.delete(long1);
		
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public Order findOrderById(Long id) {
		// TODO Auto-generated method stub
		return orderDao.findOrderById(id);
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		orderDao.update(order);
	}
	
}
