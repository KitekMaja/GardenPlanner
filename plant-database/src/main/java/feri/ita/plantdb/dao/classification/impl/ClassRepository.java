package feri.ita.plantdb.dao.classification.impl;

import feri.ita.plantdb.dao.classification.IClassRepository;
import feri.ita.plantdb.model.classification.ClassModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClassRepository implements IClassRepository {

    private final EntityManager entityManager;

    public ClassRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a ClassModel entity from the database by its name.
     *
     * @param name the name of the ClassModel entity to retrieve
     * @return the ClassModel entity if found, or null if not found
     */
    @Override
    public ClassModel getClassByName(String name) {
        try {
            return entityManager.createQuery("SELECT c FROM ClassModel c WHERE c.className = :name", ClassModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Adds a new ClassModel entity to the database.
     *
     * @param classModel the ClassModel entity to add
     * @return the added ClassModel entity
     */
    @Override
    public ClassModel addClass(ClassModel classModel) {
        entityManager.persist(classModel);
        return entityManager.find(ClassModel.class, classModel.getClassId());
    }

    /**
     * Retrieves a list of all ClassModel entities from the database.
     *
     * @return a list of all ClassModel entities
     */
    @Override
    public List<ClassModel> getClasses() {
        return entityManager.createQuery("SELECT c FROM ClassModel c", ClassModel.class).getResultList();
    }

    /**
     * Updates a ClassModel entity in the database based on the given ID.
     *
     * @param id         the ID of the ClassModel entity to update
     * @param classModel the updated ClassModel entity
     * @return the updated ClassModel entity
     */
    @Override
    public ClassModel updateClass(Long id, ClassModel classModel) {
        entityManager.createQuery("UPDATE ClassModel c SET c.className = :className WHERE c.classId = :classId").setParameter("className", classModel.getClassName()).setParameter("classId", id).executeUpdate();
        return entityManager.find(ClassModel.class, id);
    }

    /**
     * Deletes a ClassModel entity from the database.
     *
     * @param classModel the ClassModel entity to delete
     */
    @Override
    public void deleteClass(ClassModel classModel) {
        entityManager.remove(classModel);
    }
}