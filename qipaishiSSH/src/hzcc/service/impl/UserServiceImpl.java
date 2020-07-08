package hzcc.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hzcc.dao.IUserDao;
import hzcc.domain.User;
import hzcc.service.IUserService;
import hzcc.web.commons.Page;

@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class UserServiceImpl implements IUserService {
	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void removeUser(Long userId) {
		// TODO Auto-generated method stub
		userDao.delete(userId);
	}

	@Override
	public User findUserById(Long userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void updatepassword(Long id, String password) {
		// TODO Auto-generated method stub
		User user=userDao.findById(id);
		user.setPassword(password);
		userDao.update(user);
	}



	@Override
	public List<User> fAllUser(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		return userDao.fAll(dCriteria);
	}



	@Override
	public Page findAllUser(DetachedCriteria dCriteria, Integer num) {
		// TODO Auto-generated method stub
		//1.准备当前页信息
				int currentPageNum=1;
				if(num!=null) {
					currentPageNum=num;
				}
				//2.获得总记录条数
				int totalRecords=userDao.findTotalRecords(dCriteria);
				//3.创建一个page
				Page page=new Page(currentPageNum, totalRecords);
				//4.使用page对象中的数据，查询带有分页的结果集
				List<User> records=userDao.findAll(dCriteria, page.getStartIndex(), page.getPageSize());
				//5.把查询出来的结果封装到page对象中
				page.setRecords(records);
				//6.返回page对象
				return page;
	}

}
