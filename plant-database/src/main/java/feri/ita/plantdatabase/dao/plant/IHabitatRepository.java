package feri.ita.plantdatabase.dao.plant;

import feri.ita.plantdatabase.dto.plant.HabitatDTO;

import java.util.List;

public interface IHabitatRepository {
    HabitatDTO getHabitatById(Long id);
    HabitatDTO getHabitatByName(String name);
    void addHabitat(HabitatDTO habitat);
    List<HabitatDTO> getAllHabitats();
    HabitatDTO updateHabitat(HabitatDTO habitat);
    void deleteHabitat(HabitatDTO habitat);
}
