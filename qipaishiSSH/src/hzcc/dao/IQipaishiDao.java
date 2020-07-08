package hzcc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.Depart;
import hzcc.domain.Qipaishi;

public interface IQipaishiDao {
	/**
	 * 查询棋牌室列表
	 * @return
	 */
	List<Qipaishi> findAll();
	/**
	 * 
	 * 查询部门列表 				
	 * @param dCriteria		查询的条件
	 * @return
	 */
	public List<Qipaishi> findAll(DetachedCriteria dCriteria);
	/**
	 * 保存棋牌室
	 * @param customer
	 */
	public void save(Qipaishi qipaishi);
	/**
	 * 根据id删除棋牌室
	 * @param qipaishiId
	 */
	public void delete(Long qipaishiId);
	
	/**
	 * 根据id查找员工
	 * @param qipaishiId
	 * @return
	 */
	public Qipaishi findById(Long qipaishiId) ;
	
	/**
	 * 更新棋牌室
	 * @param qipaishi
	 */
	public void update(Qipaishi qipaishi);
}
