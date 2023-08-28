package com.example.securityWeb.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityWeb.demo.Entity.User;
import com.example.securityWeb.demo.Repository.UserRepo;
import com.example.securityWeb.demo.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/user/home")
	public String home() {
		return "home";
	}
	/*
	@GetMapping("/user/profile")
	public String profile(Principal p,Model m)
	{
		String email=p.getName();
		User user=userRepo.findByEmail(email);
		m.addAttribute("user", user);
		return "profile";
	}
	*/
	@ModelAttribute
	public void CommonUser(Principal p,Model m) 
	{
		if(p!=null) 
		{
			String email=p.getName();
			User user=userRepo.findByEmail(email);
			m.addAttribute("user", user);
			
		}
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user,HttpSession session,Model m,HttpServletRequest request)
	{
		//System.out.println(user);
		
		String url=request.getRequestURL().toString();
		url=url.replace(request.getServletPath(), "");
		
		User u=userservice.saveUser(user,url);
		
		
		if(u!=null)
		{
			session.setAttribute("msg", "Register Successfully");
		}
		else {
			session.setAttribute("msg", "Something went wrong");
		}
		
		return "redirect:/register";
	}
	
	@GetMapping("/verify")
	public String verifyAccount(@Param("code") String code,Model m)
	{
		boolean f=userservice.verifyAccount(code);
		if(f) {
			m.addAttribute("msg", "Successfully your account is verified");
		}
		else {
			m.addAttribute("msg", "may be your verification code is incorrect or user already verified");
		}
		
		return "message";
	}
	
}
