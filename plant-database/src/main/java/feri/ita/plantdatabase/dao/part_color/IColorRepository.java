package feri.ita.plantdatabase.dao.part_color;

import feri.ita.plantdatabase.dto.lifespan.LifespanDTO;
import feri.ita.plantdatabase.dto.part_color.ColorDTO;

import java.util.List;

public interface IColorRepository {
    ColorDTO getColorById(Long id);
    ColorDTO getColorByName(String name);
    void addColor(ColorDTO colorDTO);
    List<ColorDTO> getColors();
    ColorDTO updateColor(Long id);
    void deleteColor(Long id);
}
