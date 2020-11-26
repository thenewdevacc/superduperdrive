package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

@Service
public class FileService {

	@Autowired
	private FileMapper fileMapper;
	
	public List<File> getFiles(User user) {
		return fileMapper.getFiles(user.getUserid());
	}
	
	public void insert(File file) {
		fileMapper.insert(file);
	}
	
	public File getFile(Integer id) {
		return fileMapper.getFile(id);
	}
	
	public void delete(Integer id) {
		fileMapper.delete(id);
	}
	
}
