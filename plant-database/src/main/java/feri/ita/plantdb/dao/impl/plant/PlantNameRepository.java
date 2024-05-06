package feri.ita.plantdb.dao.impl.plant;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.plant.PlantNameModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlantNameRepository implements IEntityRepository<PlantNameModel> {

    private final EntityManager entityManager;

    public PlantNameRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all PlantNameModel entities from the database.
     *
     * @return a list of all PlantNameModel entities
     */
    @Override
    public List<PlantNameModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM PlantNameModel c", PlantNameModel.class).getResultList();
    }

    /**
     * Adds a new PlantNameModel entity to the database.
     *
     * @param entity the PlantNameModel entity to add
     * @return the added PlantNameModel entity
     */
    @Override
    public PlantNameModel addEntityToDatabase(PlantNameModel entity) {
        entityManager.persist(entity);
        return entityManager.find(PlantNameModel.class, entity.getPlantNameId());
    }

    /**
     * Deletes a PlantNameModel entity from the database.
     *
     * @param entity the PlantNameModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(PlantNameModel entity) {
        entityManager.remove(entity);
    }
}
