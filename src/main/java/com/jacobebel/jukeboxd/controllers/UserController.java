package com.jacobebel.jukeboxd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacobebel.jukeboxd.models.LoginUser;
import com.jacobebel.jukeboxd.models.User;
import com.jacobebel.jukeboxd.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String loginReg(Model model) {
		model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
		
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model) {
		userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		return "redirect:/albums";
	}
	
	@PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model) {
	     User user = userServ.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     }
	     session.setAttribute("userId", user.getId());
	     return "redirect:/albums";
	 }
	
	@PostMapping ("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
}