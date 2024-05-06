package feri.ita.plantdb.dao.impl.soil;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.soil.SoilTypeModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SoilTypeRepository implements IEntityRepository<SoilTypeModel> {
    private final EntityManager entityManager;

    public SoilTypeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all SoilTypeModel entities from the database.
     *
     * @return a list of all SoilTypeModel entities
     */
    @Override
    public List<SoilTypeModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT s FROM SoilTypeModel s", SoilTypeModel.class).getResultList();
    }

    /**
     * Adds a new SoilTypeModel entity to the database.
     *
     * @param entity the SoilTypeModel entity to add
     * @return the added SoilTypeModel entity
     */
    @Override
    public SoilTypeModel addEntityToDatabase(SoilTypeModel entity) {
        entityManager.persist(entity);
        return entityManager.find(SoilTypeModel.class, entity.getSoilTypeId());
    }

    /**
     * Deletes a SoilTypeModel entity from the database.
     *
     * @param entity the SoilTypeModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(SoilTypeModel entity) {
        entityManager.remove(entity);
    }
}
