package com.store.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.bookstore.domain.Categoria;
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

	public Livro update(Integer id, Livro obj) {
		Livro newObj = this.findById(id);
		this.updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria categoria = categoriaService.findById(id_cat);
		obj.setCategoria(categoria);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Livro livro = this.findById(id);
		repository.delete(livro);
		return;
	}
	

}
