package com.example.securityWeb.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securityWeb.demo.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	public User findByEmail(String email);
	public User findByVerificationCode(String code);
}
