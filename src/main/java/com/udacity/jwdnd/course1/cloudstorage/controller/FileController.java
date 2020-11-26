package com.udacity.jwdnd.course1.cloudstorage.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/home")
public class FileController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private FileService fileService;
	
	@PostMapping("/file")
	public String postFile(@RequestParam("fileUpload") MultipartFile fileUpload,Principal principal,Model model) throws IOException {
		if(fileUpload.isEmpty()) {
			model.addAttribute("success",false);
			model.addAttribute("message","No file selected to upload!");
			return "result";
		}
		List<File> files = fileService.getFiles(userService.getUser(principal.getName()));
		for(File tempFile:files) {
			if(tempFile.getFilename().equals(fileUpload.getOriginalFilename())) {
				model.addAttribute("success",false);
				model.addAttribute("message","File with same name already exists!");
				return "result";
			}
		}
		File file = new File();
		file.setFiledata(fileUpload.getBytes());
		file.setUserid(userService.getUser(principal.getName()).getUserid());
		file.setFilesize(fileUpload.getSize());
		file.setFilename(fileUpload.getOriginalFilename());
		file.setContenttype(fileUpload.getContentType());
		fileService.insert(file);
		model.addAttribute("success",true);
		model.addAttribute("message","New File added successfully!");
		return "result";
	}
	
	@GetMapping("/file/{fileId}")
	public ResponseEntity getFile(@PathVariable Integer fileId) {
		File file = fileService.getFile(fileId);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file.getFiledata());
	}
	
	@GetMapping("/file/delete/{fileId}")
	public String deleteFile(@PathVariable Integer fileId,Model model) {
		fileService.delete(fileId);
		model.addAttribute("success",true);
		model.addAttribute("message","File deleted successfully!");
		return "result";
	}
}
