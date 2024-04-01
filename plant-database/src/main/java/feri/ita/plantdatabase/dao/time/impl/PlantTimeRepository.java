package feri.ita.plantdatabase.dao.time.impl;

import feri.ita.plantdatabase.dao.time.IPlantTimeRepository;
import feri.ita.plantdatabase.dto.time.PlantTimeDTO;

import java.util.List;

public class PlantTimeRepository implements IPlantTimeRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public PlantTimeDTO getPlantTimeById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public PlantTimeDTO getPlantTimeByName(String name) {
        return null;
    }

    /**
     * @param plantTime
     */
    @Override
    public void addPlantTime(PlantTimeDTO plantTime) {

    }

    /**
     * @return
     */
    @Override
    public List<PlantTimeDTO> getAllPlantTimes() {
        return null;
    }

    /**
     * @param plantTime
     * @return
     */
    @Override
    public PlantTimeDTO updatePlantTime(PlantTimeDTO plantTime) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deletePlantTime(Long id) {

    }
}
