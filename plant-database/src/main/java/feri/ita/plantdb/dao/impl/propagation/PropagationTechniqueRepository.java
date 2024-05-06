package feri.ita.plantdb.dao.impl.propagation;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.propagation.PropagationTechniqueModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PropagationTechniqueRepository implements IEntityRepository<PropagationTechniqueModel> {
    private final EntityManager entityManager;

    public PropagationTechniqueRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all PropagationTechniqueModel entities from the database.
     *
     * @return a list of all PropagationTechniqueModel entities
     */
    @Override
    public List<PropagationTechniqueModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM PropagationTechniqueModel c", PropagationTechniqueModel.class).getResultList();
    }

    /**
     * Adds a new PropagationTechniqueModel entity to the database.
     *
     * @param entity the PropagationTechniqueModel entity to add
     * @return the added PropagationTechniqueModel entity
     */
    @Override
    public PropagationTechniqueModel addEntityToDatabase(PropagationTechniqueModel entity) {
        entityManager.persist(entity);
        return entityManager.find(PropagationTechniqueModel.class, entity.getPropagationTechniqueId());
    }

    /**
     * Deletes a PropagationTechniqueModel entity from the database.
     *
     * @param entity the PropagationTechniqueModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(PropagationTechniqueModel entity) {
        entityManager.remove(entity);
    }
}
