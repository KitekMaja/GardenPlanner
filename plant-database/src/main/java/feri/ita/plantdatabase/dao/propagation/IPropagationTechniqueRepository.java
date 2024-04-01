package feri.ita.plantdatabase.dao.propagation;

import feri.ita.plantdatabase.dto.propagation.PropagationTechniqueDTO;

import java.util.List;

public interface IPropagationTechniqueRepository {
    PropagationTechniqueDTO getPropagationTechniqueById(Long id);

    PropagationTechniqueDTO getPropagationTechniqueByName(String name);

    void addPropagationTechnique(PropagationTechniqueDTO propagationTechniqueDTO);

    List<PropagationTechniqueDTO> getAllPropagationTechniques();

    PropagationTechniqueDTO updatePropagationTechnique(Long id);

    void deletePropagationTechniqueById(Long id);
}
