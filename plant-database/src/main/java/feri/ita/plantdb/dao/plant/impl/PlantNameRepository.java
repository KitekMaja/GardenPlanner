package feri.ita.plantdb.dao.plant.impl;

import feri.ita.plantdb.dao.plant.IPlantNameRepository;
import feri.ita.plantdb.dto.plant.PlantNameDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlantNameRepository implements IPlantNameRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public PlantNameDTO getPlantNameById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public PlantNameDTO getPlantNameByName(String name) {
        return null;
    }

    /**
     * @param plantName
     */
    @Override
    public void addPlantName(PlantNameDTO plantName) {

    }

    /**
     * @return
     */
    @Override
    public List<PlantNameDTO> getAllPlantNames() {
        return null;
    }

    /**
     * @param plantName
     * @return
     */
    @Override
    public PlantNameDTO updatePlantName(PlantNameDTO plantName) {
        return null;
    }

    /**
     * @param plantName
     */
    @Override
    public void deletePlantName(PlantNameDTO plantName) {

    }
}
