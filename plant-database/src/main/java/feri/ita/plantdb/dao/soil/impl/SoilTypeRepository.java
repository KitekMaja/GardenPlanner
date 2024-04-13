package feri.ita.plantdb.dao.soil.impl;

import feri.ita.plantdb.dao.soil.ISoilTypeRepository;
import feri.ita.plantdb.dto.soil.SoilDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
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
