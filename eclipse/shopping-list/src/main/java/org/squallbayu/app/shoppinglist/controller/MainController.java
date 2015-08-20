package org.squallbayu.app.shoppinglist.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.squallbayu.app.shoppinglist.model.User;
import org.squallbayu.app.shoppinglist.model.UserLogin;
import org.squallbayu.app.shoppinglist.service.ItemService;
import org.squallbayu.app.shoppinglist.service.UserService;

@Controller
//@SessionAttributes("user")
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
		
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) { 	
		User user = new User();		
		model.addAttribute("user", user);		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "signup";
		} else if(userService.findByUserName(user.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			userService.save(user);
			model.addAttribute("message", "Saved user details");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {			
		UserLogin userLogin = new UserLogin();		
		model.addAttribute("userLogin", userLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("userLogin") UserLogin userLogin, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		} else {
			boolean found = userService.findByLogin(userLogin.getUserName(), userLogin.getPassword());
			if (found) {				
				return "success";
			} else {				
				return "failure";
			}
		}	
	}

}
