package hzcc.domain;


public class Order {
	private Long id;
	private Long vipid;
	private Long qipaishiid;
	private Integer number;
	private String data;
	private String time;
	private String cost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVipid() {
		return vipid;
	}
	public void setVipid(Long vipid) {
		this.vipid = vipid;
	}
	public Long getQipaishiid() {
		return qipaishiid;
	}
	public void setQipaishiid(Long qipaishiid) {
		this.qipaishiid = qipaishiid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", vipid=" + vipid + ", qipaishiid=" + qipaishiid + ", number=" + number + ", data="
				+ data + ", time=" + time + ", cost=" + cost + "]";
	}
	
	
}
