package hzcc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import org.omg.CORBA.SystemException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import hzcc.domain.Vip;
import hzcc.dao.IVipDao;

public class VipDaoImpl implements IVipDao{
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void save(Vip vip) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(vip);
	}

	@Override
	public int findTotalRecords(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		dCriteria.setProjection(Projections.count("id"));//把 select *变成了select count(*)
		List<Long> list= (List<Long>) hibernateTemplate.findByCriteria(dCriteria);
		return list.isEmpty()?0:list.get(0).intValue();
	}

	@Override
	public List<Vip> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		dCriteria.setProjection(null);
		return (List<Vip>) hibernateTemplate.findByCriteria(dCriteria,firstResult,maxResult);
	}

	@Override
	public void delete(Long vipId) {
		// TODO Auto-generated method stub
		Vip vip=findById(vipId);
		System.out.println(vip);
		hibernateTemplate.delete(vip);

	}

	@Override
	public Vip findById(Long vipId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Vip.class,vipId);
	}

	@Override
	public void update(Vip vip) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(vip);
	}

}
