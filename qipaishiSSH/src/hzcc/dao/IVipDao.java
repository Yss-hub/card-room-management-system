package hzcc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.Vip;

/**
 * vip的持久层接口
 * @author likai
 *
 */
public interface IVipDao {
	/**
	 * 保存客户
	 * @param customer
	 */
	public void save(Vip vip);
	
	/**
	 * 查询总记录条数
	 * @param dCriteria	查询条件
	 * @return
	 */
	public int findTotalRecords(DetachedCriteria dCriteria);
	
	/**
	 * 
	 * 查询员工列表 				
	 * @param dCriteria		查询的条件
	 * @param firstResult	查询的开始记录索引
	 * @param maxResult		每次查询记录的条数
	 * @return
	 */
	public List<Vip> findAll(DetachedCriteria dCriteria,int firstResult,int maxResult);
	
	/**
	 * 根据id删除员工
	 * @param vipId
	 */
	public void delete(Long vipId);
	
	/**
	 * 根据id查找员工
	 * @param staffId
	 * @return
	 */
	public Vip findById(Long vipId) ;
	
	/**
	 * 更新员工
	 * @param vip
	 */
	public void update(Vip vip);
}

