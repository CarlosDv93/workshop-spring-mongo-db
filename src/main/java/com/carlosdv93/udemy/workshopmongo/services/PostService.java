package com.carlosdv93.udemy.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdv93.udemy.workshopmongo.domain.Post;
import com.carlosdv93.udemy.workshopmongo.repository.PostRepository;
import com.carlosdv93.udemy.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Post post = repo.findOne(id);
		if(post == null) {
			throw new ObjectNotFoundException("Objecto Não encontrado!");
		}
		return post;
	}

}
