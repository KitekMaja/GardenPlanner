package feri.ita.plantdb.dao.impl.plant;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.plant.HabitatModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HabitatRepository implements IEntityRepository<HabitatModel> {
    private final EntityManager entityManager;

    public HabitatRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all HabitatModel entities from the database.
     *
     * @return a list of all HabitatModel entities
     */
    @Override
    public List<HabitatModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT h FROM HabitatModel h", HabitatModel.class).getResultList();
    }

    /**
     * Adds a new HabitatModel entity to the database.
     *
     * @param entity the HabitatModel entity to add
     * @return the added HabitatModel entity
     */
    @Override
    public HabitatModel addEntityToDatabase(HabitatModel entity) {
        entityManager.persist(entity);
        return entityManager.find(HabitatModel.class, entity.getHabitatId());
    }

    /**
     * Deletes a HabitatModel entity from the database.
     *
     * @param entity the HabitatModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(HabitatModel entity) {
        entityManager.remove(entity);
    }
}
