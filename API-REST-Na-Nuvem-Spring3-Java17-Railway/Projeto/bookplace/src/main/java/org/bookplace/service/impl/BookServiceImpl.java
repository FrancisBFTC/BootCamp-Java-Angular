package org.bookplace.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bookplace.domain.model.Book;
import org.bookplace.domain.model.Tag;
import org.bookplace.domain.model.Category;
import org.bookplace.domain.repository.BookRepository;
import org.bookplace.domain.repository.CategoryRepository;
import org.bookplace.domain.repository.TagRepository;
import org.bookplace.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
	private BookRepository repository;
	@Autowired
    private TagRepository tagRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
    public Book salvar(Book book) {
        // Associa as tags e categoria ao livro
        book.setTags(this.getRelatedTags(book));
		book.setCategory(this.getRelatedCategory(book));				
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
    
	public Set<Tag> getRelatedTags(Book book){
		Set<Tag> tagsAssociated = new HashSet<>();
        for (Tag nameTag : book.getTags()) {
            Tag tag = tagRepository.findByName(nameTag.getName())
                    .orElseGet(() -> {
                        Tag newTag = new Tag();
                        newTag.setName(nameTag.getName());
                        return tagRepository.save(newTag);
                    });
            tagsAssociated.add(tag);
        }
		return tagsAssociated;
	}

	public Category getRelatedCategory(Book book){
		String nameCategory = book.getCategory().getName();
		Category category = categoryRepository.findByName(nameCategory)
							.orElseGet(() -> {
								Category newCategory = new Category();
								newCategory.setName(nameCategory);
								return categoryRepository.save(newCategory);
							});
		return category;
	}
}
