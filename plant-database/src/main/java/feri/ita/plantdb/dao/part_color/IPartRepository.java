package feri.ita.plantdb.dao.part_color;

import feri.ita.plantdb.dto.part_color.PartDTO;

import java.util.List;

public interface IPartRepository {
    PartDTO getPartById(Long id);
    PartDTO getPartByName(String name);
    void addPlantPart(PartDTO partDTO);
    List<PartDTO> getParts();
    PartDTO updatePart(Long id);
    void deletePart(Long id);
}
