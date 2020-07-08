package hzcc.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import hzcc.dao.IDepartDao;
import hzcc.domain.Depart;
/**
 * 部门的持久层实现类
 * @author likai
 *
 */
public class DepartDaoImpl implements IDepartDao{
private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List<Depart> findAll() {
		// TODO Auto-generated method stub
		return (List<Depart>) hibernateTemplate.loadAll(Depart.class);
	}

}
