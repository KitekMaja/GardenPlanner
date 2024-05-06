package feri.ita.plantdb.service.plant.impl;

import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.dto.plant.PlantNameDTO;
import feri.ita.plantdb.service.IEntityService;

import java.util.List;

public class PlantNameService implements IEntityService<PlantNameDTO> {
    /**
     * @return
     */
    @Override
    public List<PlantNameDTO> getAll() {
        return null;
    }

    /**
     * @param entity the entity to add
     * @return
     */
    @Override
    public PlantNameDTO add(PlantNameDTO entity) {
        return null;
    }

    /**
     * @param name the name of the entity to delete
     */
    @Override
    public void deleteByName(String name) {

    }
}
