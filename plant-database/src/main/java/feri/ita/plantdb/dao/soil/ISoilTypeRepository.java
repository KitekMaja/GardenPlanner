package feri.ita.plantdb.dao.soil;

import feri.ita.plantdb.dto.soil.SoilDTO;

import java.util.List;

public interface ISoilTypeRepository {
    SoilDTO getSoilTypeById(Long id);
    SoilDTO getSoilTypeByName(String name);
    void addSoilType(SoilDTO soilTypeDTO);
    List<SoilDTO> getAllSoilTypes();
    SoilDTO updateSoilType(Long id);
    void deleteSoilType(Long id);
}
