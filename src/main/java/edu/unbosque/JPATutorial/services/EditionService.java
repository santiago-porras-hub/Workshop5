package edu.unbosque.JPATutorial.services;


import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.repositories.*;

import edu.unbosque.JPATutorial.servlets.pojos.EditionPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Stateless
public class EditionService {

    EditionRepository editionRepository;
    BookRepository bookRepository;

    public List<EditionPOJO> listEditions() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        List<Edition> editions = editionRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<EditionPOJO> editionsPOJO = new ArrayList<>();
        for (Edition edition : editions) {
            editionsPOJO.add(new EditionPOJO(

                    edition.getEditionId(),
                    edition.getDescription(),
                    edition.getReleaseYear()

            ));
        }

        return editionsPOJO;

    }

    public void saveEdition(String description, String releaseYear, Integer bookId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);


        Optional<Book> book = bookRepository.findById(bookId);
        book.ifPresent(a -> {
            a.addEdition(new Edition(description, releaseYear));
            bookRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    public void deleteEdition(Integer editionId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.deleteById(editionId);

        entityManager.close();
        entityManagerFactory.close();

    }

    public Edition saveFirstEdition(String description, String releaseYear) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);

        Edition edition = new Edition(description, releaseYear);
        Edition persistedEdition = editionRepository.save(edition).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedEdition;

    }
}
