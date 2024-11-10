package me.dio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.Book;
import me.dio.domain.repository.BookRepository;
import me.dio.service.BookService;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Book create(Book book) {
       return bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

}
