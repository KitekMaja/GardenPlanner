package feri.ita.plantdb.dao.propagation;

import feri.ita.plantdb.dto.propagation.PropagationTechniqueDTO;

import java.util.List;

public interface IPropagationTechniqueRepository {
    PropagationTechniqueDTO getPropagationTechniqueById(Long id);

    PropagationTechniqueDTO getPropagationTechniqueByName(String name);

    void addPropagationTechnique(PropagationTechniqueDTO propagationTechniqueDTO);

    List<PropagationTechniqueDTO> getAllPropagationTechniques();

    PropagationTechniqueDTO updatePropagationTechnique(Long id);

    void deletePropagationTechniqueById(Long id);
}
