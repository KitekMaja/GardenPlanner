package feri.ita.plantdb.service.classification.impl;

import feri.ita.plantdb.dao.classification.IFamilyRepository;
import feri.ita.plantdb.dto.classification.FamilyDTO;
import feri.ita.plantdb.model.classification.FamilyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class FamilyService {
    private static final Logger LOG = LoggerFactory.getLogger(FamilyService.class);
    private final IFamilyRepository familyRepository;

    public FamilyService(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }


    private FamilyDTO convertToDTO(FamilyModel familyModel) {
        FamilyDTO familyDTO = new FamilyDTO();
        familyDTO.setFamilyName(familyModel.getFamilyName());
        return familyDTO;
    }

    private FamilyModel convertDTOToModel(FamilyDTO FamilyDTO) {
        FamilyModel familyModel = new FamilyModel();
        Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        familyModel.setFamilyId(uniqueId);
        familyModel.setFamilyName(FamilyDTO.getFamilyName());
        return familyModel;
    }
}
