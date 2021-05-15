package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findByEmail(String email);

    List<Customer> findAll();

    Optional<Customer> save(Customer customer);

    void deleteByEmail(String email);
}
