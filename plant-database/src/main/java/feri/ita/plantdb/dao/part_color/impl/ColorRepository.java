package feri.ita.plantdb.dao.part_color.impl;

import feri.ita.plantdb.dao.part_color.IColorRepository;
import feri.ita.plantdb.dto.part_color.ColorDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class ColorRepository implements IColorRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public ColorDTO getColorById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public ColorDTO getColorByName(String name) {
        return null;
    }

    /**
     * @param colorDTO
     */
    @Override
    public void addColor(ColorDTO colorDTO) {

    }

    /**
     * @return
     */
    @Override
    public List<ColorDTO> getColors() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ColorDTO updateColor(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteColor(Long id) {

    }
}
