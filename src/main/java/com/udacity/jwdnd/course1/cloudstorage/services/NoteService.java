package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

@Service
public class NoteService {

	@Autowired
	private NoteMapper noteMapper;
	
	public List<Note> getNotes(User loggedIn) {
		return noteMapper.getNotes(loggedIn.getUserid());
	}

	public void createNote(Note note) {
		noteMapper.insert(note);
	}

	public void updateNote(Note note) {
		noteMapper.update(note);
	}
	
	public void deleteNote(Integer id) {
		noteMapper.delete(id);
	}
}
