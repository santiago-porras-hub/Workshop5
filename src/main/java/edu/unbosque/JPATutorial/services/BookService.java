package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepository;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.BookRepository;
import edu.unbosque.JPATutorial.jpa.repositories.BookRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class BookService {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public List<BookPOJO> listBooks() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        List<Book> books = bookRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<BookPOJO> booksPOJO = new ArrayList<>();
        for (Book book : books) {
            booksPOJO.add(new BookPOJO(
                    book.getBookId(),
                    book.getTitle(),
                    book.getIsbn(),
                    book.getAuthor().getAuthorId(),
                    book.getGenre()

            ));
        }
        return booksPOJO;
    }


    public void saveBook(String title, String isbn, String genre, Integer authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        Optional<Author> author = authorRepository.findById(authorId);
        author.ifPresent(a -> {
            a.addBook(new Book(title, isbn, genre));
            authorRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    public void deleteBook(Integer bookId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        bookRepository.deleteById(bookId);

        entityManager.close();
        entityManagerFactory.close();

    }

    public void modifyBook(Integer id, String title, String isbn, String genre){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        bookRepository.updateById(id,title,isbn,genre);

        entityManager.close();
        entityManagerFactory.close();

    }

}

