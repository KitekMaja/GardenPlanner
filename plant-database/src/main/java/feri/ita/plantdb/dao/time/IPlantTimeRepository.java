package feri.ita.plantdb.dao.time;

import feri.ita.plantdb.dto.time.PlantTimeDTO;

import java.util.List;

public interface IPlantTimeRepository {
    PlantTimeDTO getPlantTimeById(Long id);
    PlantTimeDTO getPlantTimeByName(String name);
    void addPlantTime(PlantTimeDTO plantTime);
    List<PlantTimeDTO> getAllPlantTimes();
    PlantTimeDTO updatePlantTime(PlantTimeDTO plantTime);
    void deletePlantTime(Long id);
}
