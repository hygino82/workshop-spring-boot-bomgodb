package com.hygino.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hygino.workshopmongo.domain.User;
import com.hygino.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName() , objDto.getEmail());
	}
}
