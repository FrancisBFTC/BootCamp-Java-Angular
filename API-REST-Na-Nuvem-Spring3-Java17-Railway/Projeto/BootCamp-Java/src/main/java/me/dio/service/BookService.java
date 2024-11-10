package me.dio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.domain.model.Book;
import me.dio.domain.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;

    public Book salvar(Book book) {
		return repository.save(book);
	}

	public Book buscar(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Book> buscarTudo() {
		return repository.findAll();
	}

    public void deletar(Long id){
        repository.deleteById(id);
    }
    
}
