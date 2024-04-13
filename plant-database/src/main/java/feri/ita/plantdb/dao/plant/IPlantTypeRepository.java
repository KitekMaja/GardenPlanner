package feri.ita.plantdb.dao.plant;

import feri.ita.plantdb.dto.plant.PlantTypeDTO;

import java.util.List;

public interface IPlantTypeRepository {
    PlantTypeDTO getPlantTypeById(Long id);
    PlantTypeDTO getPlantTypeByName(String name);
    void addPlantType(PlantTypeDTO plantType);
    List<PlantTypeDTO> getPlantTypes();
    PlantTypeDTO updatePlantType(Long id);
    void deletePlantType(Long id);
}
