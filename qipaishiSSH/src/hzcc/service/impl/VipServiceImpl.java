package hzcc.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hzcc.dao.IDepartDao;
import hzcc.dao.IVipDao;
import hzcc.domain.Depart;
import hzcc.domain.Vip;
import hzcc.service.IVipService;
import hzcc.web.commons.Page;
/**
 * vip的业务层实现类
 * @author likai
 *
 */
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class VipServiceImpl implements IVipService{
	private IVipDao vipDao;
	private IDepartDao departDao;

	public void setVipDao(IVipDao vipDao) {
		this.vipDao = vipDao;
	}
	
	public void setDepartDao(IDepartDao departDao) {
		this.departDao = departDao;
	}

	@Override
	public Page findAllVip(DetachedCriteria dCriteria, Integer num) {
		
		//1.准备当前页信息
		int currentPageNum=1;
		if(num!=null) {
			currentPageNum=num;
		}
		//2.获得总记录条数
		int totalRecords=vipDao.findTotalRecords(dCriteria);
		//3.创建一个page
		Page page=new Page(currentPageNum, totalRecords);
		//4.使用page对象中的数据，查询带有分页的结果集
		List<Vip> records=vipDao.findAll(dCriteria, page.getStartIndex(), page.getPageSize());
		//5.把查询出来的结果封装到page对象中
		page.setRecords(records);
		//6.返回page对象
		return page;

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void save(Vip vip) {
		// TODO Auto-generated method stub
		vipDao.save(vip);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void removeVip(Long id) {
		// TODO Auto-generated method stub
		vipDao.delete(id);
	}

	@Override
	public Vip findVipById(Long vipId) {
		// TODO Auto-generated method stub
		return vipDao.findById(vipId);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void update(Vip vip) {
		// TODO Auto-generated method stub
		vipDao.update(vip);

	}
	//部门的查找

	@Override
	public List<Depart> findAllDepart() {
		// TODO Auto-generated method stub
		return departDao.findAll();
	}

}

