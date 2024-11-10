package me.dio.controller;

import java.net.URI;
import java.util.List;

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

import me.dio.domain.model.Book;
import me.dio.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        /*
        Book bookCreated = bookService.salvar(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(bookCreated.getId())
                        .toUri();
        */
        book = bookService.salvar(book);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> searchBook(@PathVariable Long id){
        Book book = bookService.buscar(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Book>> searchAllBook(){
        var book = bookService.buscarTudo();
        return ResponseEntity.ok(book);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deletar(id);
            return "O id " + id + " foi deletado com sucesso!";
    }

}
