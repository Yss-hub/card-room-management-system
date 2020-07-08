package hzcc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import hzcc.domain.Qipaishi;
import hzcc.domain.Vip;
import hzcc.web.commons.Page;

public interface IQipaishiService {
	/**
	 * 查询所有棋牌室列表
	 * @return
	 */
	List<Qipaishi> findAllQipaishi(DetachedCriteria dCriteria);
	Page findAllVip(DetachedCriteria dCriteria,Integer num);
	/**
	 * 保存棋牌室
	 * @param Qipaishi
	 */
	void save(Qipaishi qipaishi);
	/**
	 * 根据id删除棋牌室
	 * @param long1
	 */
	void removeQipaishi(Long long1);
	/**
	 * 根据id查询客户信息
	 * @param vipId
	 * @return
	 */
	Qipaishi findQipaishiById(Long qipaishiId);
	/**
	 * 更新客户
	 * @param vip
	 */
	void update(Qipaishi qipaishi);
}
