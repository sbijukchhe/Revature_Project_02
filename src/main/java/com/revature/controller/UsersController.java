package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.entity.Users;
import com.revature.service.UsersService;
import com.revature.service.UsersServiceImpl;

//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
@Controller
@RequestMapping("/")
public class UsersController {

	@Autowired
	UsersServiceImpl usersServiceImpl;
	
	@GetMapping("/")
	public String list() {
		System.out.println("index");
		return "index";
	}
	
	@GetMapping("/userslist")
	public ModelAndView listUsers(Model model) {
		List<Users> userslist = usersServiceImpl.getUsers();
		System.out.println("List of Users is ");
		userslist.forEach(System.out::println);
		return new ModelAndView ("userslist", "ulist", userslist);// userslist.jsp, reference, object
	}
	
	/*
	@GetMapping("/showForm")
	public ModelAndView showUsersForm(Model model) {
		Users users = new Users();
		users.setUserId(10);
		users.setFirstName("Surendra");
		users.setLastName("Bijukchhe");
		users.setUserName("sb");
		ModelAndView m1 = new ModelAndView("usersForm");
		m1.addObject("users", users);
		return m1;
	}
	*/
	
	@RequestMapping (value = "/save", method = RequestMethod.POST)
	public String save (@Valid @ModelAttribute("users") Users users, BindingResult theBindResult) {
		System.out.println("value of hasErrors:" + theBindResult.hasErrors());
		
		if (theBindResult.hasErrors()) {
			System.out.println("errors");
			return "usersForm";
		}else
			System.out.println(users.getUserId()+" "+users.getFirstName()+" "+users.getLastName()+" " +users.getUserName()+ " "+ users.getPost().getPostId());
			usersServiceImpl.createUsers(users);
			return "usersConfirmation";
	}
	
	@InitBinder
	public void initBinder (WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
}
