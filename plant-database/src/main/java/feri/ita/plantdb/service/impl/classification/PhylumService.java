package feri.ita.plantdb.service.impl.classification;

import feri.ita.plantdb.dao.impl.classification.PhylumRepository;
import feri.ita.plantdb.dto.classification.PhylumDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.model.classification.PhylumModel;
import feri.ita.plantdb.service.IEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhylumService implements IEntityService<PhylumDTO> {
    /**
     * Exception messages
     */
    private static final String PHYLUM_NOT_FOUND = "Phylum with name [%s] not found.";
    private static final String PHYLUM_ALREADY_EXISTS = "Phylum with name [%s] already exists.";
    private final PhylumRepository phylumRepository;

    public PhylumService(PhylumRepository phylumRepository) {
        this.phylumRepository = phylumRepository;
    }

    /**
     * Retrieves a list of all PhylumDTO objects from the database.
     *
     * @return a list of all PhylumDTO objects
     */
    @Override
    public List<PhylumDTO> getAll() {
        List<PhylumModel> phylums = phylumRepository.retrieveAllFromDatabase();
        return phylums.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * Adds a new PhylumDTO object to the database.
     *
     * @param entity the PhylumDTO object to add
     * @return the added PhylumDTO object
     * @throws ClassificationException if a PhylumDTO object with the same name already exists
     */
    @Override
    public PhylumDTO add(PhylumDTO entity) {
        PhylumModel phylumModel = convertDTOToModel(entity);
        PhylumModel existing = phylumRepository.getPhylumByName(phylumModel.getPhylumName());
        if (existing != null) {
            throw new ClassificationException(PHYLUM_ALREADY_EXISTS, existing.getPhylumName());
        }
        PhylumModel added = phylumRepository.addEntityToDatabase(phylumModel);
        return convertToDTO(added);
    }

    /**
     * Deletes a PhylumDTO object from the database by its name.
     *
     * @param name the name of the PhylumDTO object to delete
     * @throws ClassificationException if the PhylumDTO object with the given name is not found
     */
    @Override
    public void deleteByName(String name) {
        PhylumModel phylumByName = phylumRepository.getPhylumByName(name);
        if (phylumByName == null) {
            throw new ClassificationException(PHYLUM_NOT_FOUND, name);
        }
        phylumRepository.removeEntityFromDatabase(phylumByName);
    }

    /**
     * Converts a PhylumModel object to a PhylumDTO object.
     *
     * @param phylumModel the PhylumModel object to convert
     * @return the corresponding PhylumDTO object
     */
    private PhylumDTO convertToDTO(PhylumModel phylumModel) {
        PhylumDTO phylumDTO = new PhylumDTO();
        phylumDTO.setPhylumName(phylumModel.getPhylumName());
        return phylumDTO;
    }

    /**
     * Converts a PhylumDTO object to a PhylumModel object.
     *
     * @param phylumDTO the PhylumDTO object to convert
     * @return the corresponding PhylumModel object
     */
    private PhylumModel convertDTOToModel(PhylumDTO phylumDTO) {
        PhylumModel phylumModel = new PhylumModel();
        phylumModel.setPhylumName(phylumDTO.getPhylumName());
        return phylumModel;
    }
}
