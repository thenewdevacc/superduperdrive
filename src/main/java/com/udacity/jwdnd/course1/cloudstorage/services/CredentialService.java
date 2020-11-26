package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

@Service
public class CredentialService {

	@Autowired
	private CredentialMapper credentialMapper;

	public List<Credential> getCredentials(User loggedIn) {
		return credentialMapper.getCredentials(loggedIn.getUserid());
	}
	
	public void createCredential(Credential credential) {
		credentialMapper.insert(credential);
	}
	
	public void delete(Integer id) {
		credentialMapper.delete(id);
	}
	
	public void update(Credential credential) {
		credentialMapper.update(credential);
	}
}
