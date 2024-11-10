package org.bookplace.service.impl;

import java.util.List;

import org.bookplace.domain.model.Book;
import org.bookplace.domain.model.Tag;
import org.bookplace.domain.repository.BookRepository;
import org.bookplace.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
	private BookRepository repository;

	@Override
    public Book salvar(Book book) {
		int i = 0;
		for(Tag tag : book.getTags()){
			Book hashTag = repository.findByTagsName(tag.getName());
			if(hashTag != null)
				if(hashTag.getTags() != null)
					book.getTags().get(i).setId(hashTag.getTags().get(i++).getId());
		}

		Book category = repository.findByCategoryName(book.getCategory().getName());
		if(category != null)
			if(category.getCategory() != null)
				book.getCategory().setId(category.getCategory().getId());

		return repository.save(book);
	}
	
	@Override
	public Book editar(Book book) {
		return this.salvar(book);
	}

	@Override
	public Book buscar(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Book> buscarTudo() {
		return repository.findAll();
	}

	@Override
    public void deletar(Long id){
        repository.deleteById(id);
    }
    
}
