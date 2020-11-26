package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public String getSignup(Model model) {
		model.addAttribute("newUser", new User());
		return "signup";
	}

	@PostMapping()
	public String postSignup(@ModelAttribute("firstname") String firstname, @ModelAttribute("lastname") String lastname,
			@ModelAttribute("username") String username, @ModelAttribute("password") String password, Model model) {
		User user = new User();
		String signupError = null;
		if (!userService.isUsernameAvailable(username)) {
			signupError = "The username already exists.";
		}

		if (signupError == null) {
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setUsername(username);
			user.setPassword(password);
			int rowsModified = userService.createUser(user);
			if (rowsModified < 0) {
				signupError = "There was an error signing you up. Please try again.";
			}
		}
		if (signupError == null) {
			model.addAttribute("signupSuccessful", true);
			return "signup";
		} else {
			model.addAttribute("signupError", signupError);
			return "signup";
		}
		
	}
}
