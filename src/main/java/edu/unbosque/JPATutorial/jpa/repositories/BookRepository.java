package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    // REVISAR
    Optional<Book> findById(Integer id);

    Optional<Book> findByTitle(String title);

    Optional<Book> findByNameNamedQuery(String title);

    List<Book> findAll();

    Optional<Book> save(Book book);

    void deleteById(Integer id);

    void updateById(Integer id,String title, String isbn, String genre);
}
