package com.carlosdv93.udemy.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.carlosdv93.udemy.workshopmongo.domain.Post;
import com.carlosdv93.udemy.workshopmongo.domain.User;
import com.carlosdv93.udemy.workshopmongo.dto.AuthorDTO;
import com.carlosdv93.udemy.workshopmongo.repository.PostRepository;
import com.carlosdv93.udemy.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.save(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/08/2018"), "Partiu Viagem", "Bora viajar pra São Paulo", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/08/2018"), "Bom dia", "Acordei Feliz", new AuthorDTO(maria));
		
		postRepository.save(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
