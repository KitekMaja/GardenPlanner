package feri.ita.plantdatabase.dao.propagation.impl;

import feri.ita.plantdatabase.dao.propagation.IPropagationTechniqueRepository;
import feri.ita.plantdatabase.dto.propagation.PropagationTechniqueDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PropagationTechniqueRepository implements IPropagationTechniqueRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public PropagationTechniqueDTO getPropagationTechniqueById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public PropagationTechniqueDTO getPropagationTechniqueByName(String name) {
        return null;
    }

    /**
     * @param propagationTechniqueDTO
     */
    @Override
    public void addPropagationTechnique(PropagationTechniqueDTO propagationTechniqueDTO) {

    }

    /**
     * @return
     */
    @Override
    public List<PropagationTechniqueDTO> getAllPropagationTechniques() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PropagationTechniqueDTO updatePropagationTechnique(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deletePropagationTechniqueById(Long id) {

    }
}
