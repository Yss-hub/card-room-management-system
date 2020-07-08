package hzcc.dao.impl;

import java.util.List;

import javax.persistence.Id;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;

import hzcc.dao.IOrderDao;
import hzcc.domain.Order;

public class OrderDaoImpl implements IOrderDao {
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Order> findAll(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		dCriteria.setProjection(null);
		return (List<Order>) hibernateTemplate.findByCriteria(dCriteria);
	}

	@Override
	public long findOrdersNum(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		dCriteria.setProjection(Projections.sum("number"));//把 select *变成了select sum(number)
		List<Long> list= (List<Long>) hibernateTemplate.findByCriteria(dCriteria);
		if(list.isEmpty()||list.get(0)==null) {
			return 0;
		}
		else {
			return list.isEmpty()?0:list.get(0).longValue();
		}
	}

	@Override
	public List<Object[]> findOrdersNumGroupByDepart(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(order);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Order order=findOrderById(id);
		hibernateTemplate.delete(order);
	}

	@Override
	public Order findOrderById(Long id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Order.class,id);
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(order);
	}



	
}
