package hzcc.dao;

import java.util.List;

import hzcc.domain.Depart;



public interface IDepartDao {
	/**
	 * 查询部门列表
	 * @return
	 */
	List<Depart> findAll();
}
