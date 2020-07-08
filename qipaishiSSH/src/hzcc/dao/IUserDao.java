package hzcc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.User;

public interface IUserDao {
	public int findTotalRecords(DetachedCriteria dCriteria);
	/**
	 * 
	 * 查询用户列表 				
	 * @param dCriteria		查询的条件
	 * @return
	 */
	public List<User> fAll(DetachedCriteria dCriteria);
	public List<User> findAll(DetachedCriteria dCriteria, int firstResult, int maxResult);
	/**
	 * 保存用户
	 * @param user
	 */
	public void save(User user);
	/**
	 * 根据id删除用户
	 * @param userId
	 */
	public void delete(Long userId);
	
	/**
	 * 根据id查找用户
	 * @param userId
	 * @return
	 */
	public User findById(Long userId) ;
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void update(User user);
}
