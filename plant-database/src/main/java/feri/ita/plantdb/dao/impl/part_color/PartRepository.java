package feri.ita.plantdb.dao.impl.part_color;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.part_color.PartModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PartRepository implements IEntityRepository<PartModel> {
    private final EntityManager entityManager;

    public PartRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all PartModel entities from the database.
     *
     * @return a list of all PartModel entities
     */
    @Override
    public List<PartModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM PartModel c", PartModel.class).getResultList();
    }

    /**
     * Adds a new PartModel entity to the database.
     *
     * @param entity the PartModel entity to add
     * @return the added PartModel entity
     */
    @Override
    public PartModel addEntityToDatabase(PartModel entity) {
        entityManager.persist(entity);
        return entityManager.find(PartModel.class, entity.getPartId());
    }

    /**
     * Deletes a PartModel entity from the database.
     *
     * @param entity the PartModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(PartModel entity) {
        entityManager.remove(entity);
    }
}
