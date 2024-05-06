package feri.ita.plantdb.dao.impl.time;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.time.SeasonModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SeasonRepository implements IEntityRepository<SeasonModel> {
    private final EntityManager entityManager;

    public SeasonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all SeasonModel entities from the database.
     *
     * @return a list of all SeasonModel entities
     */
    @Override
    public List<SeasonModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT s FROM SeasonModel s", SeasonModel.class).getResultList();

    }

    /**
     * Adds a new SeasonModel entity to the database.
     *
     * @param entity the SeasonModel entity to add
     * @return the added SeasonModel entity
     */
    @Override
    public SeasonModel addEntityToDatabase(SeasonModel entity) {
        entityManager.persist(entity);
        return entityManager.find(SeasonModel.class, entity.getSeasonId());

    }

    /**
     * Deletes a SeasonModel entity from the database.
     *
     * @param entity the SeasonModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(SeasonModel entity) {
        entityManager.remove(entity);
    }
}
