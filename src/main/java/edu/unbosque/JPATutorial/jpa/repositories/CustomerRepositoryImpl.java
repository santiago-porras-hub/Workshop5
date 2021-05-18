package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {
    private EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Optional<Customer> findByEmail(String email) {
        Customer customer = entityManager.find(Customer.class, email);
        return customer != null ? Optional.of(customer) : Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }

    @Override
    public Optional<Customer> save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return Optional.of(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteByEmail(String email) {
        Customer customer = entityManager.find(Customer.class, email);
        if (customer != null) {
            try {

                entityManager.getTransaction().begin();

                customer.getRents().forEach(rent -> {
                    entityManager.remove(rent);
                });

                entityManager.remove(customer);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateByEmail(String email, String first_name, String last_name, String genre, Integer age) {

        Customer customer = entityManager.find(Customer.class, email);
        if (customer != null) {
            try {
                entityManager.getTransaction().begin();
                customer.setFirst_name(first_name);
                customer.setLast_name(last_name);
                customer.setGenre(genre);
                customer.setAge(age);

                entityManager.merge(customer);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}



