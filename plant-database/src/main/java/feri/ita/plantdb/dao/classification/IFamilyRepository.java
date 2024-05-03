package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.dto.classification.FamilyDTO;
import feri.ita.plantdb.model.classification.FamilyModel;

import java.util.List;

public interface IFamilyRepository {
    FamilyDTO getFamilyById(Long id);

    void createFamily(FamilyDTO family);

    FamilyDTO updateFamily(Long id);

    FamilyModel getFamilyByName(String name);

    void deleteFamily(Long id);

    List<FamilyDTO> getFamilies();
}
