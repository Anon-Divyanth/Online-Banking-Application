package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable{
	private Long acc_num,phn,amount,customeramount;
	private String username,password,address;
	private int pin;
	public Long getCustomeramount() {
		return customeramount;
	}
	public void setCustomeramount(Long customeramount) {
		this.customeramount = customeramount;
	}
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(Long acc_num) {
		this.acc_num = acc_num; 
	}
	public Long getPhn() {
		return phn;
	}
	public void setPhn(Long phn) {
		this.phn = phn;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
