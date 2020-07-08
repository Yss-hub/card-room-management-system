package hzcc.domain;

public class User {
	/**
	 * 
	 */
	
	private Long id;
	private Integer type;
	/**
	 * 99:超级管理员 50：管理员 1：用户
	 */
	private String name;
	private Integer sex;
	/**
	 * 0:女生 1：男生
	 */
	private String tel;
	private String username;
	private String password;
	
	public String getTypeStr() {
		String message = "类型：";
		try {
			switch (type) {
				case 1:
					message += "普通用户";
					break;
				case 50:
					message += "管理员";
					break;
				case 99:
					message += "超级管理员";
					break;
				default:
					message += "错误类型";
					break;
			}
		}catch (Exception e){
			message="";
		}
		return message;
	}

	public void setTypeStr(String message) {
		try {
			switch (message) {
				case "类型：普通用户":
					type=1;
					break;
				case "类型：管理员":
					type=50;
					break;
				case "类型：超级管理员":
					type=99;
					break;
				default:
					type=0;
					break;
			}
		}catch (Exception e){
			type=0;
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Ad [id=" + id + ", type=" + type + ", name=" + name + ", sex=" + sex + ", tel=" + tel + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}
