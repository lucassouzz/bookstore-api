package com.store.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.store.bookstore.domain.Categoria;
import com.store.bookstore.repositories.CategoriaRepository;
import com.store.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! (Id: "+ id +", tipo: "+ Categoria.class.getName()+")"));
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
		

}
