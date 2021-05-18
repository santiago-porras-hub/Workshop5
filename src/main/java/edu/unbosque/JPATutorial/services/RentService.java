package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.entities.Rent;
import edu.unbosque.JPATutorial.jpa.repositories.*;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.RentPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class RentService {

    CustomerRepository customerRepository;
    RentRepository rentRepository;

    public List<RentPOJO> listRents() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        List<Rent> rents = rentRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<RentPOJO> rentsPOJO = new ArrayList<>();
        for (Rent rent : rents) {
            rentsPOJO.add(new RentPOJO(
                    rent.getRentId(),
                    rent.getCustomer().getEmail(),
                    rent.getRentingDate()
            ));
        }
        return rentsPOJO;
    }
    public void saveRent(String email, String rentingDate) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        rentRepository = new RentRepositoryImpl(entityManager);
        customerRepository = new CustomerRepositoryImpl(entityManager);
        Optional<Customer> customer = customerRepository.findByEmail(email);
        customer.ifPresent(a -> {
            a.addRent(new Rent(rentingDate));
            customerRepository.save(a);
            
        });
        entityManager.close();
        entityManagerFactory.close();
        return;

    }

    public void deleteRent(Integer rentId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        rentRepository.deleteById(rentId);
        entityManager.close();
        entityManagerFactory.close();

    }

}
