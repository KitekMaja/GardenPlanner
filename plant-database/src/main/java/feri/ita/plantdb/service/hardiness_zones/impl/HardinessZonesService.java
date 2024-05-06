package feri.ita.plantdb.service.hardiness_zones.impl;

import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.dto.hardiness_zones.HardinessZoneDTO;
import feri.ita.plantdb.service.IEntityService;

import java.util.List;

public class HardinessZonesService implements IEntityService<HardinessZoneDTO> {
    /**
     * @return
     */
    @Override
    public List<HardinessZoneDTO> getAll() {
        return null;
    }

    /**
     * @param entity the entity to add
     * @return
     */
    @Override
    public HardinessZoneDTO add(HardinessZoneDTO entity) {
        return null;
    }

    /**
     * @param name the name of the entity to delete
     */
    @Override
    public void deleteByName(String name) {

    }
}
