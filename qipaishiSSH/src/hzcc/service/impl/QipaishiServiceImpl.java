package hzcc.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hzcc.dao.IQipaishiDao;
import hzcc.domain.Qipaishi;
import hzcc.service.IQipaishiService;
import hzcc.web.commons.Page;

@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class QipaishiServiceImpl implements IQipaishiService{
		private IQipaishiDao qipaishiDao;
		
		public void setQipaishiDao(IQipaishiDao qipaishiDao) {
			this.qipaishiDao = qipaishiDao;
		}
		@Override
		public List<Qipaishi> findAllQipaishi(DetachedCriteria dCriteria) {
			// TODO Auto-generated method stub
			return qipaishiDao.findAll(dCriteria);
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
		public Page findAllVip(DetachedCriteria dCriteria, Integer num) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
		public void save(Qipaishi qipaishi) {
			// TODO Auto-generated method stub
			qipaishiDao.save(qipaishi);
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
		public void removeQipaishi(Long long1) {
			// TODO Auto-generated method stub
			qipaishiDao.delete(long1);
		}

		@Override
		public Qipaishi findQipaishiById(Long qipaishiId) {
			// TODO Auto-generated method stub
			return qipaishiDao.findById(qipaishiId);
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
		public void update(Qipaishi qipaishi) {
			// TODO Auto-generated method stub
			qipaishiDao.update(qipaishi);
			
		}
}
