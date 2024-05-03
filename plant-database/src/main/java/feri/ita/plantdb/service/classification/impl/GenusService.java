package feri.ita.plantdb.service.classification.impl;

import feri.ita.plantdb.dto.classification.GenusDTO;
import feri.ita.plantdb.model.classification.GenusModel;

import java.util.UUID;

public class GenusService {
    private GenusDTO convertToDTO(GenusModel genusModel) {
        GenusDTO genusDTO = new GenusDTO();
        genusDTO.setGenusName(genusModel.getGenusName());
        return genusDTO;
    }

    private GenusModel convertDTOToModel(GenusDTO genusDTO) {
        GenusModel genusModel = new GenusModel();
        Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        genusModel.setGenusId(uniqueId);
        genusModel.setGenusName(genusDTO.getGenusName());
        return genusModel;
    }
}
