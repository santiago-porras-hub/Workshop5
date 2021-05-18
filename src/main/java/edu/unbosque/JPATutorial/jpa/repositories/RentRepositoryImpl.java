package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class RentRepositoryImpl implements RentRepository {
    private EntityManager entityManager;

    public RentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Rent> findById(Integer id) {
        Rent rent = entityManager.find(Rent.class, id);
        return rent != null ? Optional.of(rent) : Optional.empty();

    }

    @Override
    public Optional<Rent> findByNameNamedQuery(String renting_date) {
        Rent rent = entityManager.createNamedQuery("Rent.findByDate", Rent.class)
                .setParameter("renting_date", renting_date)
                .getSingleResult();
        return rent != null ? Optional.of(rent) : Optional.empty();
    }


    @Override
    public List<Rent> findAll() {
        return entityManager.createQuery("from Rent ").getResultList();
    }

    @Override
    public Optional<Rent> save(Rent rent) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rent);
            entityManager.getTransaction().commit();
            return Optional.of(rent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        Rent rent = entityManager.find(Rent.class, id);
        if (rent != null) {
            try {

                Edition edition = rent.getEdition();
                edition.deleteRent(rent);

                entityManager.getTransaction().begin();

                entityManager.remove(rent);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
