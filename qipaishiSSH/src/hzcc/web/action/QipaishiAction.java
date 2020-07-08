package hzcc.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import hzcc.domain.Qipaishi;
import hzcc.service.IDepartService;
import hzcc.service.IQipaishiService;

public class QipaishiAction extends ActionSupport{
	private IQipaishiService qipaishiService;
	private Qipaishi qipaishi=new Qipaishi();
	private List<Qipaishi> qipaishis;
	
	public void setQipaishiService(IQipaishiService qipaishiService) {
		this.qipaishiService = qipaishiService;
	}
	public Qipaishi getQipaishi() {
		return qipaishi;
	}
	public void setQipaishi(Qipaishi qipaishi) {
		this.qipaishi = qipaishi;
	}
	public List<Qipaishi> getQipaishis() {
		return qipaishis;
	}
	public void setQipaishis(List<Qipaishi> qipaishis) {
		this.qipaishis = qipaishis;
	}
	/**
	 * 跳转到部门添加页面
	 * @return
	 */
	public String saveUI() {
		return "saveUI";
	}
	/**
	 * 跳转到部门修改页面
	 * @return
	 */
	public String editUI() {
		//根据id查找要编辑的客户信息
		//使用模型接收
		qipaishi= qipaishiService.findQipaishiById(qipaishi.getId());
		return "editUI";
	}
	/**
	 * 删除部门
	 * @return
	 */
	public String removeQipaishi() {
		System.out.println("----removeDepart---");
		System.out.println(qipaishi);
		System.out.println(qipaishi.getId());
		qipaishiService.removeQipaishi(qipaishi.getId());
		return "list";
	}
	/**
	 * 查询部门列表
	 * @return
	 */
	public String findAllQipaishi() {
		System.out.println("----findAllQipaishi---");
		System.out.println(qipaishi);
		//1.定义离线对象
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Qipaishi.class);
		//2.拼装查询条件
		//判断是否输入了棋牌室名称
		if(StringUtils.isNotBlank(qipaishi.getQipaishiname())) {
			//模糊查询客户名称
			dCriteria.add(Restrictions.like("qipaishiname", "%"+qipaishi.getQipaishiname()+"%"));
		}		
		//3.根据离线对象查询部门信息	
		qipaishis=qipaishiService.findAllQipaishi(dCriteria);
		return "findAll";
	}


	/**
	 * 保存棋牌室
	 * @return
	 */
	public String save() {

		System.out.println("qipaishiAction中的save方法执行了......");
		qipaishiService.save(qipaishi);
		System.out.print(qipaishi);
		return SUCCESS;
	}
	/**
	 * 更新棋牌室
	 * @return
	 */
	public String update() {
		qipaishiService.update(qipaishi);
		System.out.print(qipaishi);
		return SUCCESS;
	}
}
