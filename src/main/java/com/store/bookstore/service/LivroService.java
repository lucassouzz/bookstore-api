package com.store.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.bookstore.domain.Livro;
import com.store.bookstore.repositories.LivroRepository;
import com.store.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

}
