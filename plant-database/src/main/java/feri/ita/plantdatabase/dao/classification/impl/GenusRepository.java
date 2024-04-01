package feri.ita.plantdatabase.dao.classification.impl;

import feri.ita.plantdatabase.dao.classification.IGenusRepository;
import feri.ita.plantdatabase.dto.classification.GenusDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GenusRepository implements IGenusRepository {
    /**
     * @return
     */
    @Override
    public List<GenusDTO> getAllGenus() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public GenusDTO getGenusById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public GenusDTO getGenusByName(String name) {
        return null;
    }

    /**
     * @param genusDTO
     */
    @Override
    public void addGenus(GenusDTO genusDTO) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public GenusDTO updateGenus(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteGenus(Long id) {

    }
}
