package com.example.securityWeb.demo.Service;

import com.example.securityWeb.demo.Entity.User;

public interface UserServiceImp {

	public User saveUser(User user,String url);
	public void removeSessionMessage();
	
	public void sendEmail(User user,String path);
	public boolean verifyAccount(String verificationCode);
}
