package feri.ita.plantdb.dao.sunlight;

import feri.ita.plantdb.dto.sunlight.SunlightTypeDTO;

import java.util.List;

public interface ISunlightTypeRepository {
    SunlightTypeDTO getSunlightTypeById(Long id);
    SunlightTypeDTO getSunlightTypeByName(String name);
    void addSunlightType(SunlightTypeDTO sunlightTypeDTO);
    List<SunlightTypeDTO> getAllSunlightTypes();
    SunlightTypeDTO updateSunlightType(Long id);
    void deleteSunlightTypeById(Long id);
}
