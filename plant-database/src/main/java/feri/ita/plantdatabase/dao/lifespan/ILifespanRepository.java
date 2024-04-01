package feri.ita.plantdatabase.dao.lifespan;

import feri.ita.plantdatabase.dto.hardiness_zones.HardinessZoneDTO;
import feri.ita.plantdatabase.dto.lifespan.LifespanDTO;

import java.util.List;

public interface ILifespanRepository {
    LifespanDTO getLifespanById(Long id);
    LifespanDTO getLifespanByName(String name);
    void addHardinessZone(LifespanDTO lifespanDTO);
    List<LifespanDTO> getLifespans();
    LifespanDTO updateLifespan(Long id);
    void deleteLifespan(Long id);
}
