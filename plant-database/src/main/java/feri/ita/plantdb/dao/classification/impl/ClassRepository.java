package feri.ita.plantdb.dao.classification.impl;

import feri.ita.plantdb.dao.classification.IClassRepository;
import feri.ita.plantdb.model.classification.ClassModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClassRepository implements IClassRepository {

    private static final Logger log = LoggerFactory.getLogger(ClassRepository.class);
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
        try {
            return entityManager.createQuery("SELECT c FROM ClassModel c WHERE c.className = :name", ClassModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * @param classModel
     * @return
     */
    @Override
    public ClassModel addClass(ClassModel classModel) {
        entityManager.persist(classModel);
        return entityManager.find(ClassModel.class, classModel.getClassId());
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
        entityManager.createQuery("UPDATE ClassModel c SET c.className = :className WHERE c.classId = :classId").setParameter("className", classModel.getClassName()).setParameter("classId", id).executeUpdate();
        return entityManager.find(ClassModel.class, id);
    }

    /**
     * @param className
     */
    @Override
    public void deleteClass(String className) {
        entityManager.createQuery("DELETE FROM ClassModel c WHERE c.className =:className", ClassModel.class).setParameter("className", className);
    }
}