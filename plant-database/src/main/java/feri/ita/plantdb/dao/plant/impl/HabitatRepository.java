package feri.ita.plantdb.dao.plant.impl;

import feri.ita.plantdb.dao.plant.IHabitatRepository;
import feri.ita.plantdb.dto.plant.HabitatDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
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
