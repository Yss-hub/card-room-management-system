package hzcc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class Vip implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Integer sex;
	private String phonenumber;
	private String cardnumber;
	private String cardpassword;
	private String enrolldate;
	private String depart;

	//变换男女
		public String getSexstr(){
			if(sex==0)
				return "女";
			else
				return "男";
		}
		//转化日期
	//	public String getEnrollDateStr(){
	//		if(enrolldate>0){
	//			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
	//			return dateFormat.format(new Date(enrolldate));
	//		}
	//		return "";
	//	}
	
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getCardpassword() {
		return cardpassword;
	}

	public void setCardpassword(String cardpassword) {
		this.cardpassword = cardpassword;
	}

	public String getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(String enrolldate) {
		this.enrolldate = enrolldate;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	@Override
	public String toString() {
		return "Vip [id=" + id + ", name=" + name + ", sex=" + sex + ", phonenumber=" + phonenumber + ", cardnumber="
				+ cardnumber+ ", cardpassword=" + cardpassword + ", enrolldate=" + enrolldate + ", depart=" + depart + "]";
	}
	
	
}


