package feri.ita.plantdb.dao.impl.lifespan;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.lifespan.LifespanModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LifespanRepository implements IEntityRepository<LifespanModel> {
    private final EntityManager entityManager;

    public LifespanRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all LifespanModel entities from the database.
     *
     * @return a list of all LifespanModel entities
     */
    @Override
    public List<LifespanModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM LifespanModel c", LifespanModel.class).getResultList();
    }

    /**
     * Adds a new LifespanModel entity to the database.
     *
     * @param entity the LifespanModel entity to add
     * @return the added LifespanModel entity
     */
    @Override
    public LifespanModel addEntityToDatabase(LifespanModel entity) {
        entityManager.persist(entity);
        return entityManager.find(LifespanModel.class, entity.getLifespanId());
    }

    /**
     * Deletes a LifespanModel entity from the database.
     *
     * @param entity the LifespanModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(LifespanModel entity) {
        entityManager.remove(entity);
    }
}
