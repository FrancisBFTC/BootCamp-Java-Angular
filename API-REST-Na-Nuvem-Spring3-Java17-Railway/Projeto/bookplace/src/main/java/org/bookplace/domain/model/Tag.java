package org.bookplace.domain.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity(name = "tb_tag")
public class Tag extends BookType{

    @ManyToMany(mappedBy = "tags")
    Set<Book> books;
}
