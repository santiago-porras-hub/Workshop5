package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;

import java.util.List;
import java.util.Optional;

public interface EditionRepository {

    Optional<Edition> findById(Integer id);

    List<Edition> findAll();

    Optional<Edition> save(Edition edition);

    void deleteById(Integer id);

    void updateById(Integer id,String description, String releaseYear);
}
