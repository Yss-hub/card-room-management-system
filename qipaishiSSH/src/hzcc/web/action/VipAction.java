package hzcc.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import hzcc.domain.Depart;
import hzcc.domain.Vip;
import hzcc.service.IVipService;
import hzcc.web.commons.Page;

public class VipAction extends ActionSupport{
	//模型驱动使用的对象
			private Vip vip= new Vip();
			private IVipService vipService;
			
			private Page page;
			private Integer number;

			private List<Depart> departs;
			
			public void setVipService(IVipService vipService) {
				this.vipService = vipService;
			}
			
			/**
			 * 跳转到客户添加页面
			 * @return
			 */
			public String saveUI() {
				//1.查询所有部门
				departs= vipService.findAllDepart();
				return "saveUI";
			}
			/**
			 * 跳转到客户修改页面
			 * @return
			 */
			public String editUI() {
				//根据id查找要编辑的客户信息
				//第一种，自己定义一个变量接受查询的结果
				//Staff c= staffService.findCustomerById(customer.getCust_id());
				//第一种，直接使用模型接收
				vip= vipService.findVipById(vip.getId());
				departs= vipService.findAllDepart();
				return "editUI";
			}
			/**
			 * 删除客户
			 * @return
			 */
			public String removeVip() {
				System.out.println("----removeVip---");
				System.out.println(vip);
				System.out.println(vip.getId());
				vipService.removeVip(vip.getId());	
				return "list";
			}
			/**
			 * 查询客户列表
			 * @return
			 */
			public String findAllVip() {
				System.out.println("----findAllVip---");
				System.out.println(vip);
				System.out.println(number);
				//1.定义离线对象
				DetachedCriteria dCriteria=DetachedCriteria.forClass(Vip.class);
				//2.拼装查询条件
				//判断是否输入了员工姓名
				if(StringUtils.isNotBlank(vip.getName())) {
					//模糊查询客户名称
					dCriteria.add(Restrictions.like("name", "%"+vip.getName()+"%"));
				}		
				//判断是否输入了电话号码
			
				if(StringUtils.isNotBlank(vip.getPhonenumber())) {
					//模糊查询客户行业
					dCriteria.add(Restrictions.like("phonenumber", "%"+vip.getPhonenumber()+"%"));
				}
				//判断是否输入了客户部门
				if(StringUtils.isNotBlank(vip.getDepart())) {
					//精确查询客户级别
					dCriteria.add(Restrictions.eq("depart", vip.getDepart()));
				}
				//3.根据离线对象查询客户信息	
				page=vipService.findAllVip(dCriteria,number);
				departs= vipService.findAllDepart();
				return "findAll";
			}
			/**
			 * 保存客户
			 * @return
			 */
			public String save() {
				//创建一个工厂类

				System.out.println("VipAction中的save方法执行了......");
				vipService.save(vip);
				System.out.print(vip);
				return SUCCESS;
			}
			/**
			 * 更新客户
			 * @return
			 */
			public String update() {
				vipService.update(vip);
				System.out.print(vip);
				return SUCCESS;
			}

			public Vip getVip() {
				return vip;
			}

			public void setVip(Vip vip) {
				this.vip = vip;
			}

			public Page getPage() {
				return page;
			}

			public void setPage(Page page) {
				this.page = page;
			}

			public Integer getNumber() {
				return number;
			}

			public void setNumber(Integer number) {
				this.number = number;
			}

			public List<Depart> getDeparts() {
				return departs;
			}

			public void setDeparts(List<Depart> departs) {
				this.departs = departs;
			}

}
