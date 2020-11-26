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

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/home")
public class NoteController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping("/note")
	public String postNote(Principal principal,@ModelAttribute("newnote") Note note,Model model) {
		if(note.getNoteid()==null) {
			System.out.println("------------------>"+note.getNotetitle());
			System.out.println("------------------>"+note.getNotedescription());
			System.out.println("------------------>"+note.getNoteid());
			note.setUserid(userService.getUser(principal.getName()).getUserid());
			System.out.println("------------------>"+note.getUserid());
			noteService.createNote(note);
			System.out.println("------------------>Successfull Note Added");
			model.addAttribute("success",true);
			model.addAttribute("message","New note added successfully!");
		} else {
			model.addAttribute("success",true);
			model.addAttribute("message","Note updated successfully!");
			noteService.updateNote(note);
		}
		return "result";
	}
	
	@GetMapping("/note/delete/{noteid}")
	public String deleteNote(@PathVariable Integer noteid,Model model) {
		noteService.deleteNote(noteid);
		model.addAttribute("success",true);
		model.addAttribute("message","Note deleted successfully!");
		return "result";
	}
	
}
