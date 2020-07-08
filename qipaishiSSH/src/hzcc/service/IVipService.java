package hzcc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.Depart;
import hzcc.domain.Vip;
import hzcc.web.commons.Page;

public interface IVipService {
	/**
	 * 查询客户列表
	 * @param dCriteria	查询的条件
	 * @param num		当前页
	 * @return			封装好的分页信息
	 */
	Page findAllVip(DetachedCriteria dCriteria,Integer num);
	/**
	 * 保存客户
	 * @param Vip
	 */
	void save(Vip vip);
	/**
	 * 根据id删除客户
	 * @param long1
	 */
	void removeVip(Long long1);
	/**
	 * 根据id查询客户信息
	 * @param vipId
	 * @return
	 */
	Vip findVipById(Long vipId);
	/**
	 * 更新客户
	 * @param vip
	 */
	void update(Vip vip);
	/**
	 * 查询所有部门
	 * @return
	 */
	List<Depart> findAllDepart();
}