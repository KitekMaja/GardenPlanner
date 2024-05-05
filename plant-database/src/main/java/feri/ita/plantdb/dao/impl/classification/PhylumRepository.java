package feri.ita.plantdb.dao.impl.classification;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.classification.PhylumModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PhylumRepository implements IEntityRepository<PhylumModel> {
    private final EntityManager entityManager;

    public PhylumRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all PhylumModel entities from the database.
     *
     * @return a list of all PhylumModel entities
     */
    @Override
    public List<PhylumModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT p FROM PhylumModel p", PhylumModel.class).getResultList();
    }

    /**
     * Adds a new PhylumModel entity to the database.
     *
     * @param entity the PhylumModel entity to add
     * @return the added PhylumModel entity
     */
    @Override
    public PhylumModel addEntityToDatabase(PhylumModel entity) {
        entityManager.persist(entity);
        return entityManager.find(PhylumModel.class, entity.getPhylumId());
    }

    /**
     * Deletes a PhylumModel entity from the database.
     *
     * @param entity the PhylumModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(PhylumModel entity) {
        entityManager.remove(entity);
    }

    /**
     * Retrieves a PhylumModel entity from the database by its name.
     *
     * @param name the name of the PhylumModel entity to retrieve
     * @return the PhylumModel entity if found, or null if not found
     */
    public PhylumModel getPhylumByName(String name) {
        try {
            return entityManager.createQuery("SELECT p FROM PhylumModel p WHERE p.phylumName = :name", PhylumModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
