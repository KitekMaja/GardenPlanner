package feri.ita.plantdb.dao.classification.impl;

import feri.ita.plantdb.dao.classification.IFamilyRepository;
import feri.ita.plantdb.dto.classification.FamilyDTO;
import feri.ita.plantdb.model.classification.FamilyModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FamilyRepository implements IFamilyRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public FamilyDTO getFamilyById(Long id) {
        return null;
    }

    /**
     * @param family
     */
    @Override
    public void createFamily(FamilyDTO family) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public FamilyDTO updateFamily(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public FamilyModel getFamilyByName(String name) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteFamily(Long id) {

    }

    /**
     * @return
     */
    @Override
    public List<FamilyDTO> getFamilies() {
        return null;
    }
}
