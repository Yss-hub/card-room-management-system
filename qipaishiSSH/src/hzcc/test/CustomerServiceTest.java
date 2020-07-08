package hzcc.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hzcc.domain.Vip;
import hzcc.service.IVipService;
import hzcc.web.commons.Page;

/**
 * 测试vip的业务层方法
 * @author likai
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class) //Junit4的写法
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})

public class Customer1ServiceTest {
	@Autowired
	private IVipService ss;
	@Test
	public void testFindAll() {

		DetachedCriteria dCriteria=DetachedCriteria.forClass(Vip.class);
		dCriteria.add(Restrictions.like("depart", "%贵宾卡%"));
		Page page=ss.findAllVip(dCriteria,1);
		for(Vip c:(List<Vip>)page.getRecords()) {
			System.out.println(c);
		}	
	}
	@Test
	public void testSave() {

		Vip vip=new Vip();
		vip.setName("账销案");
		ss.save(vip);
		
	}
	@Test
	public void testdel() {
		ss.removeVip(1054L);
		
	}

}
