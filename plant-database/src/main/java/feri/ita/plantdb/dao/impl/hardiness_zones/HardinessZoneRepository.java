package feri.ita.plantdb.dao.impl.hardiness_zones;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.hardiness_zones.HardinessZoneModel;
import jakarta.persistence.EntityManager;
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
        return null;
    }

    /**
     * Adds a new HardinessZoneModel entity to the database.
     *
     * @param entity the HardinessZoneModel entity to add
     * @return the added HardinessZoneModel entity
     */
    @Override
    public HardinessZoneModel addEntityToDatabase(HardinessZoneModel entity) {
        return null;
    }

    /**
     * Deletes a HardinessZoneModel entity from the database.
     *
     * @param entity the HardinessZoneModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(HardinessZoneModel entity) {

    }
}
