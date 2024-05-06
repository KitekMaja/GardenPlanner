package feri.ita.plantdb.service.plant.impl;

import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.dto.plant.PlantDTO;
import feri.ita.plantdb.service.IEntityService;

import java.util.List;

public class PlantService implements IEntityService<PlantDTO> {
    /**
     * @return
     */
    @Override
    public List<PlantDTO> getAll() {
        return null;
    }

    /**
     * @param entity the entity to add
     * @return
     */
    @Override
    public PlantDTO add(PlantDTO entity) {
        return null;
    }

    /**
     * @param name the name of the entity to delete
     */
    @Override
    public void deleteByName(String name) {

    }
}
