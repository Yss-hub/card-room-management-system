package hzcc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import hzcc.dao.IQipaishiDao;
import hzcc.domain.Depart;
import hzcc.domain.Qipaishi;

public class QipaishiDaoImpl implements IQipaishiDao{
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public List<Qipaishi> findAll() {
		// TODO Auto-generated method stub
		return (List<Qipaishi>) hibernateTemplate.loadAll(Qipaishi.class);
		
	}
	@Override
	public List<Qipaishi> findAll(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		return (List<Qipaishi>) hibernateTemplate.findByCriteria(dCriteria);
	}

	@Override
	public void save(Qipaishi qipaishi) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(qipaishi);
	}

	@Override
	public void delete(Long qipaishiId) {
		// TODO Auto-generated method stub
		Qipaishi qipaishi=findById(qipaishiId);
		System.out.println(qipaishi);
		hibernateTemplate.delete(qipaishi);
	}

	@Override
	public Qipaishi findById(Long qipaishiId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Qipaishi.class, qipaishiId);
	}

	@Override
	public void update(Qipaishi qipaishi) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(qipaishi);
	}

}
