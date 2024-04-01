package feri.ita.plantdatabase.dao.plant.impl;

import feri.ita.plantdatabase.dao.plant.IHabitatRepository;
import feri.ita.plantdatabase.dto.plant.HabitatDTO;

import java.util.List;

public class HabitatRepository implements IHabitatRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public HabitatDTO getHabitatById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public HabitatDTO getHabitatByName(String name) {
        return null;
    }

    /**
     * @param habitat
     */
    @Override
    public void addHabitat(HabitatDTO habitat) {

    }

    /**
     * @return
     */
    @Override
    public List<HabitatDTO> getAllHabitats() {
        return null;
    }

    /**
     * @param habitat
     * @return
     */
    @Override
    public HabitatDTO updateHabitat(HabitatDTO habitat) {
        return null;
    }

    /**
     * @param habitat
     */
    @Override
    public void deleteHabitat(HabitatDTO habitat) {

    }
}
