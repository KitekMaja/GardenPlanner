package feri.ita.plantdb.service.time.impl;

import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.dto.time.SeasonDTO;
import feri.ita.plantdb.service.IEntityService;

import java.util.List;

public class SeasonsService implements IEntityService<SeasonDTO> {
    /**
     * @return
     */
    @Override
    public List<SeasonDTO> getAll() {
        return null;
    }

    /**
     * @param entity the entity to add
     * @return
     */
    @Override
    public SeasonDTO add(SeasonDTO entity) {
        return null;
    }

    /**
     * @param name the name of the entity to delete
     */
    @Override
    public void deleteByName(String name) {

    }
}
