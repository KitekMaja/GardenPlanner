package feri.ita.plantdb.service.propagation.impl;

import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.dto.propagation.PropagationTechniqueDTO;
import feri.ita.plantdb.service.IEntityService;

import java.util.List;

public class PropagationService implements IEntityService<PropagationTechniqueDTO> {
    /**
     * @return
     */
    @Override
    public List<PropagationTechniqueDTO> getAll() {
        return null;
    }

    /**
     * @param entity the entity to add
     * @return
     */
    @Override
    public PropagationTechniqueDTO add(PropagationTechniqueDTO entity) {
        return null;
    }

    /**
     * @param name the name of the entity to delete
     */
    @Override
    public void deleteByName(String name) {

    }
}
