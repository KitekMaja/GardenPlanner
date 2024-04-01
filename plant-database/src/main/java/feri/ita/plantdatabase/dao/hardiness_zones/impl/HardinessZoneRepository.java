package feri.ita.plantdatabase.dao.hardiness_zones.impl;

import feri.ita.plantdatabase.dao.hardiness_zones.IHardinessZoneRepository;
import feri.ita.plantdatabase.dto.hardiness_zones.HardinessZoneDTO;

import java.util.List;

public class HardinessZoneRepository implements IHardinessZoneRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public HardinessZoneDTO getHardinessZoneById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public HardinessZoneDTO getHardinessZoneByName(String name) {
        return null;
    }

    /**
     * @param hardinessZoneDTO
     */
    @Override
    public void addHardinessZone(HardinessZoneDTO hardinessZoneDTO) {

    }

    /**
     * @return
     */
    @Override
    public List<HardinessZoneDTO> getHardinessZones() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public HardinessZoneDTO updateHardinessZone(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteHardinessZone(Long id) {

    }
}
