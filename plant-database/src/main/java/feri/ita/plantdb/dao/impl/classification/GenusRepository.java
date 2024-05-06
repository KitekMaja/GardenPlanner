package feri.ita.plantdb.dao.impl.classification;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.classification.GenusModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GenusRepository implements IEntityRepository<GenusModel> {

    private final EntityManager entityManager;

    public GenusRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all GenusModel entities from the database.
     *
     * @return a list of all GenusModel entities
     */
    @Override
    public List<GenusModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT g FROM GenusModel g", GenusModel.class).getResultList();

    }

    /**
     * Adds a new GenusModel entity to the database.
     *
     * @param genusModel the GenusModel entity to add
     * @return the added GenusModel entity
     */
    @Override
    public GenusModel addEntityToDatabase(GenusModel genusModel) {
        entityManager.persist(genusModel);
        return entityManager.find(GenusModel.class, genusModel.getGenusId());
    }

    /**
     * Deletes a GenusModel entity from the database.
     *
     * @param genusModel the GenusModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(GenusModel genusModel) {
        entityManager.remove(genusModel);
    }

    /**
     * Retrieves a GenusModel entity from the database by its name.
     *
     * @param name the name of the GenusModel entity to retrieve
     * @return the GenusModel entity if found, or null if not found
     */
    public GenusModel getGenusByName(String name) {
        try {
            return entityManager.createQuery("SELECT g FROM GenusModel g WHERE g.genusName = :name", GenusModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
