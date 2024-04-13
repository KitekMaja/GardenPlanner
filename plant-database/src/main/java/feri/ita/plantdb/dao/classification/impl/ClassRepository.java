package feri.ita.plantdb.dao.classification.impl;

import feri.ita.plantdb.dao.classification.IClassRepository;
import feri.ita.plantdb.model.classification.ClassModel;
import jakarta.persistence.EntityManager;
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
     * @param name
     * @return
     */
    @Override
    public ClassModel getClassByName(String name) {
        return null;
    }

    /**
     * @param classModel
     * @return
     */
    @Override
    public ClassModel addClass(ClassModel classModel) {

        return classModel;
    }

    /**
     * @return List<ClassModel> of all classes
     */
    @Override
    public List<ClassModel> getClasses() {
        return entityManager.createQuery("SELECT c FROM ClassModel c", ClassModel.class).getResultList();
    }

    /**
     * @param id
     * @param classModel
     * @return
     */
    @Override
    public ClassModel updateClass(Long id, ClassModel classModel) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteClass(String id) {
    }
}