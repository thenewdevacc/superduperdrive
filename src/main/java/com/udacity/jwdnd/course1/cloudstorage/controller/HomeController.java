package com.udacity.jwdnd.course1.cloudstorage.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private EncryptionService encryptionService;
	
	@GetMapping("/")
	public String getDefaultHome() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String getHome(Principal principal,Model model) {
		System.out.println("---------------> Get Mapping Home");
		User loggedIn = userService.getUser(principal.getName());
		model.addAttribute("newnote", new Note());
		model.addAttribute("notes",noteService.getNotes(loggedIn));
		model.addAttribute("newcredential", new Credential());
		model.addAttribute("credentials",credentialService.getCredentials(loggedIn));
		model.addAttribute("files",fileService.getFiles(loggedIn));
		model.addAttribute("encryptionService",encryptionService);
		System.out.println("--------------->"+loggedIn.getUsername());
		for(Note note : noteService.getNotes(loggedIn)) {
			System.out.print("Title: "+note.getNotetitle()+" Description: "+note.getNotedescription()+" \n");
		}
		return "home";
	}
	
}
