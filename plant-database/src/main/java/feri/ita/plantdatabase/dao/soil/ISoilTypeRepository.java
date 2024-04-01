package feri.ita.plantdatabase.dao.soil;

import feri.ita.plantdatabase.dto.soil.SoilDTO;

import java.util.List;

public interface ISoilTypeRepository {
    SoilDTO getSoilTypeById(Long id);
    SoilDTO getSoilTypeByName(String name);
    void addSoilType(SoilDTO soilTypeDTO);
    List<SoilDTO> getAllSoilTypes();
    SoilDTO updateSoilType(Long id);
    void deleteSoilType(Long id);
}
