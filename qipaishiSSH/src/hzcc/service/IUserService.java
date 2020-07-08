package hzcc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.User;
import hzcc.domain.Depart;
import hzcc.web.commons.Page;

public interface IUserService {
	/**
	 * 
	 * 查询用户列表 				
	 * @param dCriteria		查询的条件
	 * @return
	 */
	public List<User> fAllUser(DetachedCriteria dCriteria);
	public Page findAllUser(DetachedCriteria dCriteria, Integer num);
	/**
	 * 保存用户
	 * @param user
	 */
	public void save(User user);
	/**
	 * 根据id删除用户
	 * @param userId
	 */
	public void removeUser(Long userId);
	
	/**
	 * 根据id查找用户
	 * @param userId
	 * @return
	 */
	public User findUserById(Long userId) ;
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void update(User user);
	public void updatepassword(Long id,String password);
}
