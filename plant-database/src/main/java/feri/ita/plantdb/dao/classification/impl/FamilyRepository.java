package feri.ita.plantdb.dao.classification.impl;

import feri.ita.plantdb.dao.classification.IFamilyRepository;
import feri.ita.plantdb.model.classification.FamilyModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FamilyRepository implements IFamilyRepository {
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
    public FamilyModel createFamily(FamilyModel family) {
        entityManager.persist(family);
        return entityManager.find(FamilyModel.class, family.getFamilyId());
    }

    /**
     * Updates a FamilyModel entity in the database based on the given ID.
     *
     * @param id     the ID of the FamilyModel entity to update
     * @param family the updated FamilyModel entity
     * @return the updated FamilyModel entity
     */
    @Override
    public FamilyModel updateFamily(Long id, FamilyModel family) {
        entityManager.createQuery("UPDATE FamilyModel f SET f.familyName = :familyName WHERE f.familyId = :familyId").setParameter("familyName", family.getFamilyName()).setParameter("familyId", id).executeUpdate();
        return entityManager.find(FamilyModel.class, id);
    }

    /**
     * Retrieves a FamilyModel entity from the database by its name.
     *
     * @param name the name of the FamilyModel entity to retrieve
     * @return the FamilyModel entity if found, or null if not found
     */
    @Override
    public FamilyModel getFamilyByName(String name) {
        try {
            return entityManager.createQuery("SELECT f FROM FamilyModel f WHERE f.familyName = :name", FamilyModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Deletes a FamilyModel entity from the database.
     *
     * @param family the FamilyModel entity to delete
     */
    @Override
    public void deleteFamily(FamilyModel family) {
        entityManager.remove(family);
    }

    /**
     * Retrieves a list of all FamilyModel entities from the database.
     *
     * @return a list of all FamilyModel entities
     */
    @Override
    public List<FamilyModel> getFamilies() {
        return entityManager.createQuery("SELECT f FROM FamilyModel f", FamilyModel.class).getResultList();

    }
}
