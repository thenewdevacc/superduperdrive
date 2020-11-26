package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	private static final String PATH = "/error";

	 @RequestMapping(value = PATH)
	 public String error(Model model) {
		return "redirect:/home";
	 }

	 @Override
	 public String getErrorPath() {
	  return PATH;
	 }
}
