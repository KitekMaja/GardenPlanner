package feri.ita.plantdb.dao.hardiness_zones.impl;

import feri.ita.plantdb.dao.hardiness_zones.IHardinessZoneRepository;
import feri.ita.plantdb.dto.hardiness_zones.HardinessZoneDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
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
