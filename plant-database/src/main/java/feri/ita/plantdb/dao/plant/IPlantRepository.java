package feri.ita.plantdb.dao.plant;

import feri.ita.plantdb.dto.classification.ClassificationDTO;
import feri.ita.plantdb.dto.plant.PlantDTO;

import java.util.List;

public interface IPlantRepository {
    PlantDTO getPlantById(Long id);
    PlantDTO getPlantByName(String name);
    void addPlant(PlantDTO plant);
    List<PlantDTO> getPlants();
    PlantDTO updatePlant(PlantDTO plant);
    void deletePlant(PlantDTO plant);
    PlantDTO getBasicPlantInfo(Long id);
    PlantDTO getAllPlantDetails(Long id);
    List<PlantDTO> getPlantsByType(String type);
    List<PlantDTO> getPlantsByDifficulty(String difficulty);
    List<PlantDTO> getPlantsBySunlightCondition(String sunlightCondition);
    List<PlantDTO> getPlantsByHabitat(String habitat);
    List<PlantDTO> getPlantsByClassification(ClassificationDTO classification);
    List<PlantDTO> getPlantsByClass(String clazz);
    List<PlantDTO> getPlantsByGenus(String genus);
    List<PlantDTO> getPlantsByFamily(String family);
    List<PlantDTO> getPlantsByOrder(String order);
    List<PlantDTO> getPlantsByPhylum(String phylum);
}