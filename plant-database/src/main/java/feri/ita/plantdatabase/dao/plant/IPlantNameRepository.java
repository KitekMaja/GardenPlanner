package feri.ita.plantdatabase.dao.plant;

import feri.ita.plantdatabase.dto.plant.PlantNameDTO;

import java.util.List;

public interface IPlantNameRepository {
    PlantNameDTO getPlantNameById(Long id);
    PlantNameDTO getPlantNameByName(String name);
    void addPlantName(PlantNameDTO plantName);
    List<PlantNameDTO> getAllPlantNames();
    PlantNameDTO updatePlantName(PlantNameDTO plantName);
    void deletePlantName(PlantNameDTO plantName);
}
