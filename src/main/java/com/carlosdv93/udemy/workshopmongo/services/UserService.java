package com.carlosdv93.udemy.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdv93.udemy.workshopmongo.domain.User;
import com.carlosdv93.udemy.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		List<User> lista = repo.findAll();
		return lista;
	}
	
}
