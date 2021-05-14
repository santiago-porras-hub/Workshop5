package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.repositories.CustomerRepository;
import edu.unbosque.JPATutorial.jpa.repositories.CustomerRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.CustomerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerService {

    CustomerRepository customerRepository;

    public List<CustomerPOJO> listCustomers(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager) {
            List<Customer> customers = customerRepository.findAll();

             entityManager.close();
        entityManagerFactory.close();

            List<AuthorPOJO> authorsPOJO = new ArrayList<>();
        for (
            Customer customer : customer) {
                authorsPOJO.add(new AuthorPOJO(
                       customer.getEmail(),customer.getFirst_name()+" "+customer.getLast_name(),customer.getGenre(),customer.getAge()
                ));

        }
    }
}
