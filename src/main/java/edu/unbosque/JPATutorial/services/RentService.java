package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.*;
import edu.unbosque.JPATutorial.jpa.repositories.*;
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

    EditionRepository editionRepository;
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
                    rent.getRentingDate()
            ));
        }
        return rentsPOJO;
    }
    public void saveRent(Integer id, String rentingDate) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        rentRepository = new RentRepositoryImpl(entityManager);
        EditionRepository editionRepository= new EditionRepositoryImpl(entityManager);
        Optional<Edition> edition = editionRepository.findById(id);
        edition.ifPresent(a -> {
            a.addRent(new Rent(rentingDate));
            editionRepository.save(a);

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
