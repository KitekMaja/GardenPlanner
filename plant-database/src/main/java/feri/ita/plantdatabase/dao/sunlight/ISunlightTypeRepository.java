package feri.ita.plantdatabase.dao.sunlight;

import feri.ita.plantdatabase.dto.sunlight.SunlightTypeDTO;

import java.util.List;

public interface ISunlightTypeRepository {
    SunlightTypeDTO getSunlightTypeById(Long id);
    SunlightTypeDTO getSunlightTypeByName(String name);
    void addSunlightType(SunlightTypeDTO sunlightTypeDTO);
    List<SunlightTypeDTO> getAllSunlightTypes();
    SunlightTypeDTO updateSunlightType(Long id);
    void deleteSunlightTypeById(Long id);
}
