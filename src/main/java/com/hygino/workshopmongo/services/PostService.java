package com.hygino.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hygino.workshopmongo.domain.Post;
import com.hygino.workshopmongo.repository.PostRepository;
import com.hygino.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	// o spring procura o repositório do objeto com essa anotação
	// injeta automático a dependêcia
	private PostRepository repo;

	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}

}
