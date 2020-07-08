package hzcc.service.impl;

import java.util.List;

import hzcc.dao.IDepartDao;
import hzcc.domain.Depart;
import hzcc.service.IDepartService;
import org.hibernate.criterion.DetachedCriteria;
public class DepartServiceImpl implements IDepartService{
	private IDepartDao departDao;
	@Override
	public List<Depart> findAllDepart() {
		// TODO Auto-generated method stub
		return departDao.findAll();
	}

}
