package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.dto.classification.PhylumDTO;
import feri.ita.plantdb.model.classification.PhylumModel;

import java.util.List;

public interface IPhylumRepository {
    List<PhylumDTO> getPhylums();

    PhylumDTO getPhylumById(Long id);

    PhylumModel getPhylumByName(String name);

    void addPhylum(PhylumDTO phylum);

    PhylumDTO updatePhylum(Long id);

    void deletePhylum(Long id);
}