package org.bookplace.domain.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_category")
public class Category extends BookType {
    
    @OneToMany(mappedBy = "category")
    Set<Book> book;
}
