package feri.ita.plantdb.dao.impl.plant;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.plant.PlantModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlantRepository implements IEntityRepository<PlantModel> {
    private final EntityManager entityManager;

    public PlantRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of all PlantModel entities from the database.
     *
     * @return a list of all PlantModel entities
     */
    @Override
    public List<PlantModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT c FROM PlantModel c", PlantModel.class).getResultList();
    }

    /**
     * Adds a new PlantModel entity to the database.
     *
     * @param entity the PlantModel entity to add
     * @return the added PlantModel entity
     */
    @Override
    public PlantModel addEntityToDatabase(PlantModel entity) {
        entityManager.persist(entity);
        return entityManager.find(PlantModel.class, entity.getPlantId());
    }

    /**
     * Deletes a PlantModel entity from the database.
     *
     * @param entity the PlantModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(PlantModel entity) {
        entityManager.remove(entity);
    }

    /**
     * Retrieves a PlantModel entity from the database by its name.
     *
     * @param name the name of the PlantModel entity to retrieve
     * @return the PlantModel entity if found, or null if not found
     */
    public PlantModel getPlantByName(String name) {
        try {
            return entityManager.createQuery("SELECT p FROM PlantModel p WHERE :name MEMBER OF p.plantNames", PlantModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Updates an existing classification entity with the provided ID using the data from the given entity.
     *
     * @param entity The updated classification entity containing the new data
     * @return The updated classification entity if it exists in the database, or {@code null} if no entity
     * with the specified ID is found
     */
    public PlantModel updatePlant(PlantModel entity) {
        PlantModel plantModel = new PlantModel();
        plantModel.setBotanicalName(entity.getBotanicalName());
        plantModel.setPoisonous(entity.getPoisonous());
        plantModel.setDescription(entity.getDescription());
        plantModel.setMinPlantTemperature(entity.getMinPlantTemperature());
        plantModel.setMaxPlantTemperature(entity.getMaxPlantTemperature());
        plantModel.setInterestingFact(entity.getInterestingFact());
        plantModel.setSymbolism(entity.getSymbolism());
        plantModel.setPlantHeight(entity.getPlantHeight());
        plantModel.setSpread(entity.getSpread());
        plantModel.setFlowerSize(entity.getFlowerSize());
        plantModel.setWaterInfo(entity.getWaterInfo());
        plantModel.setFertilizerInfo(entity.getFertilizerInfo());
        plantModel.setPruning(entity.getPruning());
        plantModel.setPotting(entity.getPotting());
        plantModel.setCareDifficulty(entity.getCareDifficulty());
        plantModel.setScientificClassification(entity.getScientificClassification());
        plantModel.setPlantNames(entity.getPlantNames());
        plantModel.setPlantHardinessZones(entity.getPlantHardinessZones());
        plantModel.setPlantHabitats(entity.getPlantHabitats());
        plantModel.setPlantLifespans(entity.getPlantLifespans());
        plantModel.setPlantPropagationTechniques(entity.getPlantPropagationTechniques());
        plantModel.setPlantSoilTypes(entity.getPlantSoilTypes());
        plantModel.setPlantSunlightConditions(entity.getPlantSunlightConditions());
        plantModel.setPlantSeasons(entity.getPlantSeasons());
        plantModel.setPlantParts(entity.getPlantParts());
        return entityManager.merge(plantModel);
    }
}
