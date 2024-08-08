package feri.ita.plantdb.dao.impl.hardiness_zones;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.classification.ClassificationModel;
import feri.ita.plantdb.model.hardiness_zones.HardinessZoneModel;
import feri.ita.plantdb.model.plant.PlantModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HardinessZoneRepository implements IEntityRepository<HardinessZoneModel> {
    private final EntityManager entityManager;

    public HardinessZoneRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /**
     * Retrieves a list of all HardinessZoneModel entities from the database.
     *
     * @return a list of all HardinessZoneModel entities
     */
    @Override
    public List<HardinessZoneModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT h FROM HardinessZoneModel h", HardinessZoneModel.class).getResultList();

    }

    /**
     * Adds a new HardinessZoneModel entity to the database.
     *
     * @param entity the HardinessZoneModel entity to add
     * @return the added HardinessZoneModel entity
     */
    @Override
    public HardinessZoneModel addEntityToDatabase(HardinessZoneModel entity) {
        entityManager.persist(entity);
        return entityManager.find(HardinessZoneModel.class, entity.getHardinessZoneId());
    }

    /**
     * Deletes a HardinessZoneModel entity from the database.
     *
     * @param entity the HardinessZoneModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(HardinessZoneModel entity) {
        entityManager.remove(entity);
    }

    /**
     * Retrieves a HardinessZoneModel entity from the database by its name.
     *
     * @param name the name of the HardinessZoneModel entity to retrieve
     * @return the HardinessZoneModel entity if found, or null if not found
     */
    public HardinessZoneModel getHardinessZoneByName(String name) {
        try {
            return entityManager.createQuery("SELECT h FROM HardinessZoneModel h WHERE h.hardinessZoneName = :name", HardinessZoneModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Updates an existing zone entity with the provided ID using the data from the given entity.
     *
     * @param entity The updated zone entity containing the new data
     * @return The updated zone if it exists in the database, or {@code null} if no entity
     * with the specified ID is found
     */
    public HardinessZoneModel updateHardinessZone(HardinessZoneModel entity) {
        HardinessZoneModel zoneModel = new HardinessZoneModel();
        zoneModel.setHardinessZoneName(entity.getHardinessZoneName());
        zoneModel.setMinTemperature(entity.getMinTemperature());
        zoneModel.setMaxTemperature(entity.getMaxTemperature());
        zoneModel.setPlants(entity.getPlants());
        return entityManager.merge(zoneModel);
    }
}
