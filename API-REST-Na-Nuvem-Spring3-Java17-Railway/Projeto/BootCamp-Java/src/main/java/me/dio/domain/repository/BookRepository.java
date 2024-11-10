package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.domain.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
