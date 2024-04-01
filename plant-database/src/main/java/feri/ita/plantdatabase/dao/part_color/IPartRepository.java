package feri.ita.plantdatabase.dao.part_color;

import feri.ita.plantdatabase.dto.lifespan.LifespanDTO;
import feri.ita.plantdatabase.dto.part_color.PartDTO;

import java.util.List;

public interface IPartRepository {
    PartDTO getPartById(Long id);
    PartDTO getPartByName(String name);
    void addPlantPart(PartDTO partDTO);
    List<PartDTO> getParts();
    PartDTO updatePart(Long id);
    void deletePart(Long id);
}
