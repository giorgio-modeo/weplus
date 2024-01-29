package com.prova.spring5.Repository;

import com.prova.spring5.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
