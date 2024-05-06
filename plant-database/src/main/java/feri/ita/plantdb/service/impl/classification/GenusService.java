package feri.ita.plantdb.service.impl.classification;

import feri.ita.plantdb.dao.impl.classification.GenusRepository;
import feri.ita.plantdb.dto.classification.GenusDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.model.classification.GenusModel;
import feri.ita.plantdb.service.IEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenusService implements IEntityService<GenusDTO> {

    /**
     * Exception messages
     */
    private static final String GENUS_NOT_FOUND = "Genus with name [%s] not found.";
    private static final String GENUS_ALREADY_EXISTS = "Genus with name [%s] already exists.";
    private final GenusRepository genusRepository;

    public GenusService(GenusRepository genusRepository) {
        this.genusRepository = genusRepository;
    }

    /**
     * Retrieves a list of all GenusDTO objects from the database.
     *
     * @return a list of all GenusDTO objects
     */
    @Override
    public List<GenusDTO> getAll() {
        List<GenusModel> genuses = genusRepository.retrieveAllFromDatabase();
        return genuses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * Adds a new GenusDTO object to the database.
     *
     * @param entity the GenusDTO object to add
     * @return the added GenusDTO object
     * @throws ClassificationException if a GenusDTO object with the same name already exists
     */
    @Override
    public GenusDTO add(GenusDTO entity) {
        GenusModel model = convertDTOToModel(entity);
        GenusModel existing = genusRepository.getGenusByName(model.getGenusName());
        if (existing != null) {
            throw new ClassificationException(GENUS_ALREADY_EXISTS, existing.getGenusName());
        }
        GenusModel savedGenus = genusRepository.addEntityToDatabase(model);
        return convertToDTO(savedGenus);
    }

    /**
     * Deletes a ClassDTO object from the database by its name.
     *
     * @param name the name of the ClassDTO object to delete
     * @throws ClassificationException if the ClassDTO object with the given name is not found
     */
    @Override
    public void deleteByName(String name) {
        GenusModel model = genusRepository.getGenusByName(name);
        if (model == null) {
            throw new ClassificationException(GENUS_NOT_FOUND, name);
        }
        genusRepository.removeEntityFromDatabase(model);
    }

    /**
     * Converts a GenusModel object to a GenusDTO object.
     *
     * @param genusModel the GenusDTO object to convert
     * @return the corresponding GenusDTO object
     */
    private GenusDTO convertToDTO(GenusModel genusModel) {
        GenusDTO genusDTO = new GenusDTO();
        genusDTO.setGenusName(genusModel.getGenusName());
        return genusDTO;
    }

    /**
     * Converts a GenusDTO object to a ClassModel object.
     *
     * @param genusDTO the GenusDTO object to convert
     * @return the corresponding GenusModel object
     */
    private GenusModel convertDTOToModel(GenusDTO genusDTO) {
        GenusModel genusModel = new GenusModel();
        genusModel.setGenusName(genusDTO.getGenusName());
        return genusModel;
    }
}
