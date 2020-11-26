package com.udacity.jwdnd.course1.cloudstorage.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.KeyService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/home")
public class CredentialController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private KeyService keyService;
	
	@Autowired
	private EncryptionService encryptionService;
	
	@PostMapping("/credential")
	public String postCredential(Principal principal,@ModelAttribute("newcredential") Credential credential,Model model) {
		credential.setKey(keyService.getKey());
		credential.setPassword(encryptionService.encryptValue(credential.getPassword(), credential.getKey()));
		System.out.println("------------------>"+credential.getCredentialid());
		credential.setUserid(userService.getUser(principal.getName()).getUserid());
		System.out.println("------------------>"+credential.getUserid());
		if(credential.getCredentialid()==null) {
			credentialService.createCredential(credential);
			model.addAttribute("success",true);
			model.addAttribute("message","New Credential added successfully!");
			System.out.println("------------------>Successfull Credential Added");
		} else {
			credentialService.update(credential);
			model.addAttribute("success",true);
			model.addAttribute("message","Credential updated successfully!");
		}
		return "result";
	}
	
	@GetMapping("/credential/delete/{credentialid}")
	public String deleteCredential(@PathVariable Integer credentialid,Model model) {
		credentialService.delete(credentialid);
		model.addAttribute("success",true);
		model.addAttribute("message","Credential deleted successfully!");
		return "result";
	}
}
