package me.dio.service;

import java.util.List;

import me.dio.domain.model.Book;

public interface BookService {
    Book findById(Long id);
    Book create(Book book);
    List<Book> findAll();
    void deleteById(Long id);
}
