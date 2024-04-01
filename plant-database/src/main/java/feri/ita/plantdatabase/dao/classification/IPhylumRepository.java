package feri.ita.plantdatabase.dao.classification;

import feri.ita.plantdatabase.dto.classification.PhylumDTO;

import java.util.List;

public interface IPhylumRepository {
    List<PhylumDTO> getPhylums();

    PhylumDTO getPhylumById(Long id);

    PhylumDTO getPhylumByName(String name);

    void addPhylum(PhylumDTO phylum);

    PhylumDTO updatePhylum(Long id);

    void deletePhylum(Long id);
}