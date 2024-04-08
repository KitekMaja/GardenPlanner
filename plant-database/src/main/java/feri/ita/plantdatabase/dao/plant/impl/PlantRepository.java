package feri.ita.plantdatabase.dao.plant.impl;

import feri.ita.plantdatabase.dao.plant.IPlantRepository;
import feri.ita.plantdatabase.dto.classification.ClassificationDTO;
import feri.ita.plantdatabase.dto.plant.PlantDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlantRepository implements IPlantRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public PlantDTO getPlantById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public PlantDTO getPlantByName(String name) {
        return null;
    }

    /**
     * @param plant
     */
    @Override
    public void addPlant(PlantDTO plant) {

    }

    /**
     * @return
     */
    @Override
    public List<PlantDTO> getPlants() {
        return null;
    }

    /**
     * @param plant
     * @return
     */
    @Override
    public PlantDTO updatePlant(PlantDTO plant) {
        return null;
    }

    /**
     * @param plant
     */
    @Override
    public void deletePlant(PlantDTO plant) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public PlantDTO getBasicPlantInfo(Long id) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PlantDTO getAllPlantDetails(Long id) {
        return null;
    }

    /**
     * @param type
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByType(String type) {
        return null;
    }

    /**
     * @param difficulty
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByDifficulty(String difficulty) {
        return null;
    }

    /**
     * @param sunlightCondition
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsBySunlightCondition(String sunlightCondition) {
        return null;
    }

    /**
     * @param habitat
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByHabitat(String habitat) {
        return null;
    }

    /**
     * @param classification
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByClassification(ClassificationDTO classification) {
        return null;
    }

    /**
     * @param clazz
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByClass(String clazz) {
        return null;
    }

    /**
     * @param genus
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByGenus(String genus) {
        return null;
    }

    /**
     * @param family
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByFamily(String family) {
        return null;
    }

    /**
     * @param order
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByOrder(String order) {
        return null;
    }

    /**
     * @param phylum
     * @return
     */
    @Override
    public List<PlantDTO> getPlantsByPhylum(String phylum) {
        return null;
    }
}
