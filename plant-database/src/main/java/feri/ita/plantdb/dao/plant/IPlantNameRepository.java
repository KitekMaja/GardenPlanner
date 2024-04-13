package feri.ita.plantdb.dao.plant;

import feri.ita.plantdb.dto.plant.PlantNameDTO;

import java.util.List;

public interface IPlantNameRepository {
    PlantNameDTO getPlantNameById(Long id);
    PlantNameDTO getPlantNameByName(String name);
    void addPlantName(PlantNameDTO plantName);
    List<PlantNameDTO> getAllPlantNames();
    PlantNameDTO updatePlantName(PlantNameDTO plantName);
    void deletePlantName(PlantNameDTO plantName);
}
