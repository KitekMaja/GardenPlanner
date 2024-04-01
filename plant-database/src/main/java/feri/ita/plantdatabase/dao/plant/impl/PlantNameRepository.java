package feri.ita.plantdatabase.dao.plant.impl;

import feri.ita.plantdatabase.dao.plant.IPlantNameRepository;
import feri.ita.plantdatabase.dto.plant.PlantNameDTO;

import java.util.List;

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
