package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.dto.classification.GenusDTO;
import feri.ita.plantdb.model.classification.GenusModel;

import java.util.List;

public interface IGenusRepository {

    List<GenusDTO> getAllGenus();

    GenusDTO getGenusById(Long id);

    GenusModel getGenusByName(String name);

    void addGenus(GenusDTO genusDTO);

    GenusDTO updateGenus(Long id);

    void deleteGenus(Long id);
}