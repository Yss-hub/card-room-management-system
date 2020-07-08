package hzcc.web.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import hzcc.domain.User;
import hzcc.service.IUserService;
import hzcc.web.commons.GlobalUtils;
import hzcc.web.commons.Page;

public class SystemAction extends ActionSupport implements SessionAware{
	private IUserService userService;
	private User user=new User();
	private String message="正在登录";
	private Map<String, Object> session;
    private Integer number;
    private List<User> users;
    private Long id;
    private String password;
    private String oldpassword;
    private String errormessage;
    private Page page;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String login() {
		System.out.println("-----login------");
		//1.定义离线对象
		DetachedCriteria dCriteria=DetachedCriteria.forClass(User.class);
		//2.拼装查询条件
		//判断是否输入了用户账户
		if(StringUtils.isNotBlank(user.getUsername())) {
			//查询用户账户
			dCriteria.add(Restrictions.eq("username",user.getUsername()));
		}	
		if(StringUtils.isNotBlank(user.getPassword())) {
			//查询用户账户
			dCriteria.add(Restrictions.eq("password",user.getPassword()));
		}
		//3.根据离线对象查询员工信息	
		List<User> users=userService.fAllUser(dCriteria);
		if(users.size()==1) {
			System.out.println("-----login---SUCCESS---");
			session.put("user", users.get(0));
			return SUCCESS;
		}else {
			message="登录失败，请重试";
			System.out.println("-----login---FAIL---");
			return LOGIN;
		}
	}
	
    public String updatePassword() {
        System.out.println("-----updatepassword-----");
        user = (User) session.get("user");
        if(!user.getPassword().equals(oldpassword)) {
            errormessage="原密码输入错误，请重新尝试！";
            return ERROR;
        }
        user.setPassword(password);
        userService.update(user);
        session.put("user", user);
        return "finish";
    }

	
    public String saveUI() {
        return "saveUI";
    }
	
    public String saveUI1() {
        return "saveUI1";
    }
    public String editUI() {
        return "editUI";
    }

    public String editinfoUI() {
        return "editinfoUI";
    }
    public String editUser() {
        user = userService.findUserById(user.getId());
        return "editUser";
    }

	public String logout() {
		session.clear();
		return LOGIN;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

	public String removeUser() {
        System.out.println("----removeUser---");
        System.out.println(user);
        System.out.println(user.getUsername());
        userService.removeUser(user.getId());
        return "list";
    }

    /**
     * 查询场地列表
     *
     * @return
     */
    public String findAllUser() {
        System.out.println("----findAllUser---");
        System.out.println(user);
        System.out.println(number);
        //1.定义离线对象
        DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
        //2.拼装查询条件
        //判断是否输入了会员名
        if (StringUtils.isNotBlank(user.getName())) {
            //模糊查询会员名
            dCriteria.add(Restrictions.like("name", "%" + user.getName() + "%"));
        }
        //判断是否输入了等级
        if (StringUtils.isNotBlank(user.getTypeStr())) {
            dCriteria.add(Restrictions.eq("type", user.getType()));
        }

        //3.根据离线对象查询客户信息
        page = userService.findAllUser(dCriteria, number);
        return "findAll";
    }

    /**
     * 保存用户
     *
     * @return
     */
    public String save() {
        System.out.println("userAction中的save方法执行了......");
        userService.save(user);
        System.out.print(user);
        return "finish";
    }

    public String update() {
        System.out.println("userAction中的update方法执行了......");
        userService.update(user);
        return "finish";
    }

    public String updateinfo() {
        System.out.println("userAction中的updateinfo方法执行了......");
        userService.update(user);
        session.put("user", user);
        return "finish";
    }

	
}
