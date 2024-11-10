package org.bookplace.controller;

import java.net.URI;
import java.util.List;

import org.bookplace.domain.model.Book;
import org.bookplace.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book bookCreated = bookService.salvar(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(bookCreated.getId())
                        .toUri();

        book = bookService.salvar(book);
        return ResponseEntity.created(location).body(book);
    }
    
    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        book = bookService.editar(book);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> searchBook(@PathVariable Long id){
        Book book = bookService.buscar(id);
        return (book != null)   ? ResponseEntity.ok().body(book) 
                                : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Book>> searchAllBook(){
        var book = bookService.buscarTudo();
        return ResponseEntity.ok(book);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        Book book = bookService.buscar(id);
        if(book != null)
            bookService.deletar(id);
            
        return (book == null)   ? ResponseEntity.status(404).body("Não foi encontrado o dado com ID = " + id)
                                : ResponseEntity.status(200).body("O livro '" + book.getTitle() + "' foi deletado!");
    }

}
