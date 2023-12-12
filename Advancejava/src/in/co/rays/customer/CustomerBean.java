package in.co.rays.customer;

import java.util.Date;

public class CustomerBean {
	int id;
	String name;
	String loin_id;
	Date dob;
	String password;
	int pyment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoin_id() {
		return loin_id;
	}
	public void setLoin_id(String loin_id) {
		this.loin_id = loin_id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPyment() {
		return pyment;
	}
	public void setPyment(int pyment) {
		this.pyment = pyment;
	}
	

}
