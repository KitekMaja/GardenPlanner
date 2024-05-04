package feri.ita.plantdb.dao.hardiness_zones;

import feri.ita.plantdb.dto.hardiness_zones.HardinessZoneDTO;

import java.util.List;

public interface IHardinessZoneRepository {
    HardinessZoneDTO getHardinessZoneById(Long id);

    HardinessZoneDTO getHardinessZoneByName(String name);

    void addHardinessZone(HardinessZoneDTO hardinessZoneDTO);

    List<HardinessZoneDTO> getHardinessZones();

    HardinessZoneDTO updateHardinessZone(Long id);

    void deleteHardinessZone(Long id);
}