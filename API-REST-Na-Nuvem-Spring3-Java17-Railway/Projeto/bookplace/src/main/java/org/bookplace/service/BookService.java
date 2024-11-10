package org.bookplace.service;

import java.util.List;

import org.bookplace.domain.model.Book;

public interface BookService {
    Book salvar(Book book);
    Book editar(Book book);
    Book buscar(Long id);
    List<Book> buscarTudo();
    void deletar(Long id);
}
