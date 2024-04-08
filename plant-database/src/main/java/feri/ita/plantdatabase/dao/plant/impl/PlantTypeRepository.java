package feri.ita.plantdatabase.dao.plant.impl;

import feri.ita.plantdatabase.dao.plant.IPlantTypeRepository;
import feri.ita.plantdatabase.dto.plant.PlantTypeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlantTypeRepository implements IPlantTypeRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public PlantTypeDTO getPlantTypeById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public PlantTypeDTO getPlantTypeByName(String name) {
        return null;
    }

    /**
     * @param plantType
     */
    @Override
    public void addPlantType(PlantTypeDTO plantType) {

    }

    /**
     * @return
     */
    @Override
    public List<PlantTypeDTO> getPlantTypes() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PlantTypeDTO updatePlantType(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deletePlantType(Long id) {

    }
}
