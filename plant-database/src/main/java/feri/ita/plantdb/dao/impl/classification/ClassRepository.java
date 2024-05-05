package feri.ita.plantdb.dao.impl.classification;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.classification.ClassModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClassRepository implements IEntityRepository<ClassModel> {
    private final EntityManager entityManager;

    public ClassRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Adds a new ClassModel entity to the database.
     *
     * @param classModel the ClassModel entity to add
     * @return the added ClassModel entity
     */
    @Override
    public ClassModel addEntityToDatabase(ClassModel classModel) {
        entityManager.persist(classModel);
        return entityManager.find(ClassModel.class, classModel.getClassId());
    }

    /**
     * Retrieves a list of all ClassModel entities from the database.
     *
     * @return a list of all ClassModel entities
     */
    @Override
    public List<ClassModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM ClassModel c", ClassModel.class).getResultList();
    }

    /**
     * Deletes a ClassModel entity from the database.
     *
     * @param classModel the ClassModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(ClassModel classModel) {
        entityManager.remove(classModel);
    }

    /**
     * Retrieves a ClassModel entity from the database by its name.
     *
     * @param name the name of the ClassModel entity to retrieve
     * @return the ClassModel entity if found, or null if not found
     */
    public ClassModel getClassByName(String name) {
        try {
            return entityManager.createQuery("SELECT c FROM ClassModel c WHERE c.className = :name", ClassModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}