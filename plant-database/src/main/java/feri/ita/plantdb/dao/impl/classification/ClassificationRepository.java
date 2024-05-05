package feri.ita.plantdb.dao.impl.classification;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.classification.ClassModel;
import feri.ita.plantdb.model.classification.ClassificationModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClassificationRepository implements IEntityRepository<ClassificationModel> {
    private final EntityManager entityManager;

    public ClassificationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all ClassificationModel entities from the database.
     *
     * @return a list of all ClassificationModel entities
     */
    @Override
    public List<ClassificationModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM ClassificationModel c", ClassificationModel.class).getResultList();
    }

    /**
     * Adds a new ClassificationModel entity to the database.
     *
     * @param entity the ClassificationModel entity to add
     * @return the added ClassificationModel entity
     */
    @Override
    public ClassificationModel addEntityToDatabase(ClassificationModel entity) {
        entityManager.persist(entity);
        return entityManager.find(ClassificationModel.class, entity.getClassificationId());
    }

    /**
     * Deletes a ClassificationModel entity from the database.
     *
     * @param entity the ClassificationModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(ClassificationModel entity) {
        entityManager.remove(entity);
    }

    /**
     * Retrieves a ClassificationModel entity from the database by its name.
     *
     * @param name the name of the ClassificationModel entity to retrieve
     * @return the ClassificationModel entity if found, or null if not found
     */
    public ClassificationModel getClassificationByName(String name) {
        try {
            return entityManager.createQuery("SELECT c FROM ClassificationModel c WHERE c.classificationName = :name", ClassificationModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Updates an existing classification entity with the provided ID using the data from the given entity.
     *
     * @param entity The updated classification entity containing the new data
     * @return The updated classification entity if it exists in the database, or {@code null} if no entity
     * with the specified ID is found
     */
    public ClassificationModel updateClassification(ClassificationModel entity) {
        ClassificationModel classificationModel = new ClassificationModel();
            classificationModel.setPhylum(entity.getPhylum());
            classificationModel.setGenus(entity.getGenus());
            classificationModel.setFamily(entity.getFamily());
            classificationModel.setOrder(entity.getOrder());
            classificationModel.setClazz(entity.getClazz());
            return entityManager.merge(classificationModel);
    }

    /**
     * Retrieves a list of {@link ClassificationModel} entities based on the provided attributes.
     *
     * @param genusName   The name of the genus. Pass {@code null} to include all entities without filtering by genus.
     * @param className   The name of the class. Pass {@code null} to include all entities without filtering by class.
     * @param familyName  The name of the family. Pass {@code null} to include all entities without filtering by family.
     * @param orderName   The name of the order. Pass {@code null} to include all entities without filtering by order.
     * @param phylumName  The name of the phylum. Pass {@code null} to include all entities without filtering by phylum.
     * @return A list of {@link ClassificationModel} entities matching the provided attributes.
     */
    public List<ClassificationModel> retrieveClassificationByTypes(String genusName, String className, String familyName, String orderName, String phylumName)
    {
        return entityManager.createQuery(
                        "SELECT c FROM ClassificationModel c " +
                                "WHERE (:genusName IS NULL OR c.genus = :genusName) " +
                                "AND (:className IS NULL OR c.clazz = :className) " +
                                "AND (:familyName IS NULL OR c.family = :familyName) " +
                                "AND (:orderName IS NULL OR c.order = :orderName) " +
                                "AND (:phylumName IS NULL OR c.phylum = :phylumName)", ClassificationModel.class)
                .setParameter("genusName", genusName)
                .setParameter("className", className)
                .setParameter("familyName", familyName)
                .setParameter("orderName", orderName)
                .setParameter("phylumName", phylumName)
                .getResultList();
    }
}
