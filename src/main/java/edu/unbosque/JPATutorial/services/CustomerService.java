package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepositoryImpl;
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

    //Gender ---> GENRE
    public List<CustomerPOJO> listCustomers() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);
            List<Customer> customers = customerRepository.findAll();

             entityManager.close();
        entityManagerFactory.close();

            List<CustomerPOJO> customerPOJO = new ArrayList<>();
        for(
            Customer customer :customers)

            {
                customerPOJO.add(new CustomerPOJO(
                        customer.getEmail(), customer.getFirst_name() + " " + customer.getLast_name(),
                        customer.getGenre(),
                        customer.getAge()
                ));
            }
        return customerPOJO;

        }

        public Customer saveCustomer(String email, String first, String last, String genre, Integer age){

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            customerRepository = new CustomerRepositoryImpl(entityManager);

            Customer customer = new Customer(email,first,last,genre,age);
            Customer persistedCustomer = customerRepository.save(customer).get();

            entityManager.close();

            return persistedCustomer;
        }
    }