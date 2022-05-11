package com.web.store.music_store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.store.music_store.model.User;
import com.web.store.music_store.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User verify(String username, String password) {
		List<User> userList = ((List<User>)repo.findAll()).stream().filter(t->t.getUsername().equals(username))
				.filter(i->i.getPassword().equals(password)).collect(Collectors.toList());
		for(User user : userList) {
			return user;
		}
		return null;
	}

}
