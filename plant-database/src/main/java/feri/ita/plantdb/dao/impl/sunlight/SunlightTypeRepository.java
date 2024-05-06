package feri.ita.plantdb.dao.impl.sunlight;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.sunlight.SunlightTypesModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SunlightTypeRepository implements IEntityRepository<SunlightTypesModel> {
    private final EntityManager entityManager;

    public SunlightTypeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all SunlightTypesModel entities from the database.
     *
     * @return a list of all SunlightTypesModel entities
     */
    @Override
    public List<SunlightTypesModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT s FROM SunlightTypesModel s", SunlightTypesModel.class).getResultList();
    }

    /**
     * Adds a new SunlightTypesModel entity to the database.
     *
     * @param entity the SunlightTypesModel entity to add
     * @return the added SunlightTypesModel entity
     */
    @Override
    public SunlightTypesModel addEntityToDatabase(SunlightTypesModel entity) {
        entityManager.persist(entity);
        return entityManager.find(SunlightTypesModel.class, entity.getSunlightTypeId());
    }

    /**
     * Deletes a SunlightTypesModel entity from the database.
     *
     * @param entity the SunlightTypesModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(SunlightTypesModel entity) {
        entityManager.remove(entity);
    }
}
