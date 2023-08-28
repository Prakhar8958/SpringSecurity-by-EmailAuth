package com.example.securityWeb.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
private String name;
private String mobileNo;
private String password;	
private String email;
private String role;

private boolean enable;
private String verificationCode;
/**
 * @return the enable
 */
public boolean isEnable() {
	return enable;
}
/**
 * @param enable the enable to set
 */
public void setEnable(boolean enable) {
	this.enable = enable;
}
/**
 * @return the verificationCode
 */
public String getVerificationCode() {
	return verificationCode;
}
/**
 * @param verificationCode the verificationCode to set
 */
public void setVerificationCode(String verificationCode) {
	this.verificationCode = verificationCode;
}


/**
 * @return the role
 */
public String getRole() {
	return role;
}
/**
 * @param role the role to set
 */
public void setRole(String role) {
	this.role = role;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", password=" + password + ", email="
			+ email + "]";
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}	



}
