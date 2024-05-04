package feri.ita.plantdb.dao.classification.impl;

import feri.ita.plantdb.dao.classification.IPhylumRepository;
import feri.ita.plantdb.dto.classification.PhylumDTO;
import feri.ita.plantdb.model.classification.PhylumModel;
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
    public PhylumModel getPhylumByName(String name) {
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