package feri.ita.plantdatabase.dao.lifespan.impl;

import feri.ita.plantdatabase.dao.lifespan.ILifespanRepository;
import feri.ita.plantdatabase.dto.lifespan.LifespanDTO;

import java.util.List;

public class LifespanRepository implements ILifespanRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public LifespanDTO getLifespanById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public LifespanDTO getLifespanByName(String name) {
        return null;
    }

    /**
     * @param lifespanDTO
     */
    @Override
    public void addHardinessZone(LifespanDTO lifespanDTO) {

    }

    /**
     * @return
     */
    @Override
    public List<LifespanDTO> getLifespans() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public LifespanDTO updateLifespan(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteLifespan(Long id) {

    }
}
