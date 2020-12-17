package com.hygino.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hygino.workshopmongo.domain.User;
import com.hygino.workshopmongo.repository.UserRepository;
import com.hygino.workshopmongo.services.exception.ObjectNotFoundException;

@Service 
public class UserService {
	
	@Autowired
	//o spring procura o repositório do objeto com essa anotação
	//injeta automático a dependêcia
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User  findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
