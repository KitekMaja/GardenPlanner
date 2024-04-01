package feri.ita.plantdatabase.dao.classification.impl;

import feri.ita.plantdatabase.dao.classification.IPhylumRepository;
import feri.ita.plantdatabase.dto.classification.PhylumDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PhylumRepository implements IPhylumRepository {
    /**
     * @return
     */
    @Override
    public List<PhylumDTO> getPhylums() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PhylumDTO getPhylumById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public PhylumDTO getPhylumByName(String name) {
        return null;
    }

    /**
     * @param phylum
     */
    @Override
    public void addPhylum(PhylumDTO phylum) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public PhylumDTO updatePhylum(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deletePhylum(Long id) {

    }
}
