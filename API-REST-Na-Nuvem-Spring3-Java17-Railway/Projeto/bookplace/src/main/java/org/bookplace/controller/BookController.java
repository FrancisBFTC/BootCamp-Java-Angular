package org.bookplace.controller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

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
        if(book != null)
            return ResponseEntity.ok().body(book); 
        else
            throw new NoSuchElementException(ResponseEntity.notFound().build() + ". Nao foi encontrado o dado com ID = " + id);

    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Book>> searchAllBook(){
        var book = bookService.buscarTudo();
        return ResponseEntity.ok(book);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        Book book = bookService.buscar(id);
        if(book == null){
            throw new NoSuchElementException("Nao foi encontrado o dado com ID = " + id);
        }else{
            bookService.deletar(id);
            return ResponseEntity.status(200).body("O livro '" + book.getTitle() + "' foi deletado!");
        }
    }

}
