package feri.ita.plantdb.dao.part_color;

import feri.ita.plantdb.dto.part_color.ColorDTO;

import java.util.List;

public interface IColorRepository {
    ColorDTO getColorById(Long id);
    ColorDTO getColorByName(String name);
    void addColor(ColorDTO colorDTO);
    List<ColorDTO> getColors();
    ColorDTO updateColor(Long id);
    void deleteColor(Long id);
}
