package feri.ita.plantdb.service.classification.impl;

import feri.ita.plantdb.dto.classification.PhylumDTO;
import feri.ita.plantdb.model.classification.PhylumModel;

import java.util.UUID;

public class PhylumService {
    private PhylumDTO convertToDTO(PhylumModel phylumModel) {
        PhylumDTO phylumDTO = new PhylumDTO();
        phylumDTO.setPhylumName(phylumModel.getPhylumName());
        return phylumDTO;
    }

    private PhylumModel convertDTOToModel(PhylumDTO phylumDTO) {
        PhylumModel phylumModel = new PhylumModel();
        Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        phylumModel.setPhylumId(uniqueId);
        phylumModel.setPhylumName(phylumDTO.getPhylumName());
        return phylumModel;
    }
}
