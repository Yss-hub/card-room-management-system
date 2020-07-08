package hzcc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;

import hzcc.dao.IUserDao;
import hzcc.domain.User;

public class UserDaoImpl implements IUserDao{
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		User user = findById(userId);
        hibernateTemplate.delete(user);
	}

	@Override
	public User findById(Long userId) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(User.class, userId);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);
	}


	@Override
	public int findTotalRecords(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		 dCriteria.setProjection(Projections.count("id"));//把 select *变成了select count(*)
	        List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(dCriteria);
	        return list.isEmpty() ? 0 : list.get(0).intValue();
	    }



	@Override
	public List<User> fAll(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		return (List<User>) hibernateTemplate.findByCriteria(dCriteria);
	}


	@Override
	public List<User> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		 dCriteria.setProjection(null);
	        return (List<User>) hibernateTemplate.findByCriteria(dCriteria, firstResult, maxResult);
	    }

}
