package feri.ita.plantdatabase.dao.sunlight.impl;

import feri.ita.plantdatabase.dao.sunlight.ISunlightTypeRepository;
import feri.ita.plantdatabase.dto.sunlight.SunlightTypeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SunlightTypeRepository implements ISunlightTypeRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public SunlightTypeDTO getSunlightTypeById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public SunlightTypeDTO getSunlightTypeByName(String name) {
        return null;
    }

    /**
     * @param sunlightTypeDTO
     */
    @Override
    public void addSunlightType(SunlightTypeDTO sunlightTypeDTO) {

    }

    /**
     * @return
     */
    @Override
    public List<SunlightTypeDTO> getAllSunlightTypes() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SunlightTypeDTO updateSunlightType(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteSunlightTypeById(Long id) {

    }
}
