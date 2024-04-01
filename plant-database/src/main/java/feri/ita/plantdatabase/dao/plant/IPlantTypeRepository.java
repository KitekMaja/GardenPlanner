package feri.ita.plantdatabase.dao.plant;

import feri.ita.plantdatabase.dto.plant.PlantTypeDTO;

import java.util.List;

public interface IPlantTypeRepository {
    PlantTypeDTO getPlantTypeById(Long id);
    PlantTypeDTO getPlantTypeByName(String name);
    void addPlantType(PlantTypeDTO plantType);
    List<PlantTypeDTO> getPlantTypes();
    PlantTypeDTO updatePlantType(Long id);
    void deletePlantType(Long id);
}
