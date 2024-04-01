package feri.ita.plantdatabase.dao.part_color.impl;

import feri.ita.plantdatabase.dao.part_color.IPartRepository;
import feri.ita.plantdatabase.dto.part_color.PartDTO;

import java.util.List;

public class PartRepository implements IPartRepository {

    /**
     * @param id
     * @return
     */
    @Override
    public PartDTO getPartById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public PartDTO getPartByName(String name) {
        return null;
    }

    /**
     * @param partDTO
     */
    @Override
    public void addPlantPart(PartDTO partDTO) {

    }

    /**
     * @return
     */
    @Override
    public List<PartDTO> getParts() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PartDTO updatePart(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deletePart(Long id) {

    }
}
