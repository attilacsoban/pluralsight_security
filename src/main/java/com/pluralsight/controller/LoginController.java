package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	//controller 
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(){
		System.out.println("in the login() method");
		return "login";
	}
	
	//loginfailure esten hova iranyitson
	@RequestMapping(value="/loginFailed",method = RequestMethod.GET)
	public String loginFailed(Model model){
		System.out.println("login failed method");
		model.addAttribute("error","true");
		return "login"; //ezutan a c: prefix div megjelenik, az error attributot beallitjuk
	}
	
	//logout
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(){
		System.out.println("entered logout() method");
		
		return "logout";
	}
	
	//403 page
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public String error403(Model model){
		return "403";
	}
	
	
}
