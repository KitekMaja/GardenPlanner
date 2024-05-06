package feri.ita.plantdb.dao.impl.time;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.time.PlantTimeModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlantTimeRepository implements IEntityRepository<PlantTimeModel> {
    private final EntityManager entityManager;

    public PlantTimeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all PlantTimeModel entities from the database.
     *
     * @return a list of all PlantTimeModel entities
     */
    @Override
    public List<PlantTimeModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM PlantTimeModel c", PlantTimeModel.class).getResultList();
    }

    /**
     * Adds a new PlantTimeModel entity to the database.
     *
     * @param entity the PlantTimeModel entity to add
     * @return the added PlantTimeModel entity
     */
    @Override
    public PlantTimeModel addEntityToDatabase(PlantTimeModel entity) {
        entityManager.persist(entity);
        return entityManager.find(PlantTimeModel.class, entity.getPlantTimeId());
    }

    /**
     * Deletes a PlantTimeModel entity from the database.
     *
     * @param entity the PlantTimeModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(PlantTimeModel entity) {
        entityManager.remove(entity);
    }
}
