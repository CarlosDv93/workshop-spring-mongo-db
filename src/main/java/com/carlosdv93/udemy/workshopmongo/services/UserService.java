package com.carlosdv93.udemy.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdv93.udemy.workshopmongo.domain.User;
import com.carlosdv93.udemy.workshopmongo.dto.UserDTO;
import com.carlosdv93.udemy.workshopmongo.repository.UserRepository;
import com.carlosdv93.udemy.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		List<User> lista = repo.findAll();
		return lista;
	}
	
	public User findById(String id) {
		User user = repo.findOne(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objecto Não encontrado!");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDto(UserDTO user) {
		return new User(user.getId(), user.getName(), user.getEmail());
	}
}
