package feri.ita.plantdb.dao.time.impl;

import feri.ita.plantdb.dao.time.IPlantTimeRepository;
import feri.ita.plantdb.dto.time.PlantTimeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
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