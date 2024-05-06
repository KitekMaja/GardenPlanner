package feri.ita.plantdb.dao.impl.plant;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.plant.PlantTypeModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlantTypeRepository implements IEntityRepository<PlantTypeModel> {
    private final EntityManager entityManager;

    public PlantTypeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all PlantTypeModel entities from the database.
     *
     * @return a list of all PlantTypeModel entities
     */
    @Override
    public List<PlantTypeModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT p FROM PlantTypeModel p", PlantTypeModel.class).getResultList();
    }

    /**
     * Adds a new PlantTypeModel entity to the database.
     *
     * @param entity the PlantTypeModel entity to add
     * @return the added PlantTypeModel entity
     */
    @Override
    public PlantTypeModel addEntityToDatabase(PlantTypeModel entity) {
        entityManager.persist(entity);
        return entityManager.find(PlantTypeModel.class, entity.getPlantTypeId());
    }

    /**
     * Deletes a PlantTypeModel entity from the database.
     *
     * @param entity the PlantTypeModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(PlantTypeModel entity) {
        entityManager.remove(entity);
    }
}
