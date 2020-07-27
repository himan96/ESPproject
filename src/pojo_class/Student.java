package pojo_class;

public class Student 
{
	private int sid;
	private String sname;
	private String city;
	private String mobnum;
	private String email;
	private String bdate;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobnum() {
		return mobnum;
	}
	public void setMobnum(String mobnum) {
		this.mobnum = mobnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", city=" + city + ", mobnum=" + mobnum + ", email=" + email
				+ ", bdate=" + bdate + "]";
	}
	public Student(int sid, String sname, String city, String mobnum, String email, String bdate) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.city = city;
		this.mobnum = mobnum;
		this.email = email;
		this.bdate = bdate;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
