package com.store.bookstore.service;

import java.util.List;
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
	
	@Autowired
	CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll(Integer id_cat){
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}
	

}
