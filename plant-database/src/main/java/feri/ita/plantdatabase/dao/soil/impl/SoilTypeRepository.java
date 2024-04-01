package feri.ita.plantdatabase.dao.soil.impl;

import feri.ita.plantdatabase.dao.soil.ISoilTypeRepository;
import feri.ita.plantdatabase.dto.soil.SoilDTO;

import java.util.List;

public class SoilTypeRepository implements ISoilTypeRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public SoilDTO getSoilTypeById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public SoilDTO getSoilTypeByName(String name) {
        return null;
    }

    /**
     * @param soilTypeDTO
     */
    @Override
    public void addSoilType(SoilDTO soilTypeDTO) {

    }

    /**
     * @return
     */
    @Override
    public List<SoilDTO> getAllSoilTypes() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SoilDTO updateSoilType(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteSoilType(Long id) {

    }
}
