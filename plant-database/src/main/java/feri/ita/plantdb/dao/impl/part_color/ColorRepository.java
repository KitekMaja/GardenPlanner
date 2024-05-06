package feri.ita.plantdb.dao.impl.part_color;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.part_color.ColorModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ColorRepository implements IEntityRepository<ColorModel> {
    private final EntityManager entityManager;

    public ColorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all ColorModel entities from the database.
     *
     * @return a list of all ColorModel entities
     */
    @Override
    public List<ColorModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM ColorModel c", ColorModel.class).getResultList();
    }

    /**
     * Adds a new ColorModel entity to the database.
     *
     * @param entity the ColorModel entity to add
     * @return the added ColorModel entity
     */
    @Override
    public ColorModel addEntityToDatabase(ColorModel entity) {
        entityManager.persist(entity);
        return entityManager.find(ColorModel.class, entity.getColorId());
    }

    /**
     * Deletes a ColorModel entity from the database.
     *
     * @param entity the ColorModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(ColorModel entity) {
        entityManager.remove(entity);
    }
}
