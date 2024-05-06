package feri.ita.plantdb.dao.impl.classification;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.classification.FamilyModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FamilyRepository implements IEntityRepository<FamilyModel> {
    private final EntityManager entityManager;

    public FamilyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Adds a new FamilyModel entity to the database.
     *
     * @param family the FamilyModel entity to add
     * @return the added FamilyModel entity
     */
    @Override
    public FamilyModel addEntityToDatabase(FamilyModel family) {
        entityManager.persist(family);
        return entityManager.find(FamilyModel.class, family.getFamilyId());
    }

    /**
     * Deletes a FamilyModel entity from the database.
     *
     * @param family the FamilyModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(FamilyModel family) {
        entityManager.remove(family);
    }

    /**
     * Retrieves a list of all FamilyModel entities from the database.
     *
     * @return a list of all FamilyModel entities
     */
    @Override
    public List<FamilyModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT f FROM FamilyModel f", FamilyModel.class).getResultList();

    }

    /**
     * Retrieves a FamilyModel entity from the database by its name.
     *
     * @param name the name of the FamilyModel entity to retrieve
     * @return the FamilyModel entity if found, or null if not found
     */

    public FamilyModel getFamilyByName(String name) {
        try {
            return entityManager.createQuery("SELECT f FROM FamilyModel f WHERE f.familyName = :name", FamilyModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}