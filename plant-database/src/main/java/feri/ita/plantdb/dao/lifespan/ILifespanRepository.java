package feri.ita.plantdb.dao.lifespan;

import feri.ita.plantdb.dto.lifespan.LifespanDTO;

import java.util.List;

public interface ILifespanRepository {
    LifespanDTO getLifespanById(Long id);
    LifespanDTO getLifespanByName(String name);
    void addLifeSpan(LifespanDTO lifespanDTO);
    List<LifespanDTO> getLifespans();
    LifespanDTO updateLifespan(Long id);
    void deleteLifespan(Long id);
}
