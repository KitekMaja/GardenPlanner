package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.dto.classification.FamilyDTO;

import java.util.List;

public interface IFamilyRepository {
    FamilyDTO getFamilyById(Long id);

    void createFamily(FamilyDTO family);

    FamilyDTO updateFamily(Long id);

    FamilyDTO getFamilyByName(String name);

    void deleteFamily(Long id);

    List<FamilyDTO> getFamilies();
}
