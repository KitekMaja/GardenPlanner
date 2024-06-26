package feri.ita.plantdb.service.impl.classification;

import feri.ita.plantdb.dao.impl.classification.FamilyRepository;
import feri.ita.plantdb.dto.classification.FamilyDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.model.classification.FamilyModel;
import feri.ita.plantdb.service.IEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyService implements IEntityService<FamilyDTO> {
    /**
     * Exception messages
     */
    private static final String FAMILY_NOT_FOUND = "Family with name [%s] not found.";
    private static final String FAMILY_ALREADY_EXISTS = "Family with name [%s] already exists.";

    private final Logger log = LoggerFactory.getLogger(FamilyService.class);
    private final FamilyRepository familyRepository;

    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    /**
     * Retrieves a list of all FamilyDTO objects from the database.
     *
     * @return a list of all FamilyDTO objects
     */
    @Override
    public List<FamilyDTO> getAll() {
        List<FamilyModel> families = familyRepository.retrieveAllFromDatabase();
        return families.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    /**
     * Adds a new FamilyDTO object to the database.
     *
     * @param familyDTO the FamilyDTO object to add
     * @return the added FamilyDTO object
     * @throws ClassificationException if a FamilyDTO object with the same name already exists
     */
    @Override
    public FamilyDTO add(FamilyDTO familyDTO) {
        FamilyModel familyModel = convertDTOToModel(familyDTO);
        FamilyModel exists = familyRepository.getFamilyByName(familyModel.getFamilyName());
        if (exists != null) {
            throw new ClassificationException(FAMILY_ALREADY_EXISTS, exists.getFamilyName());
        }
        log.info("Adding FamilyDTO");
        FamilyModel savedFamily = familyRepository.addEntityToDatabase(familyModel);
        log.info("Entity Added to database");
        return convertToDTO(savedFamily);
    }

    /**
     * Deletes a FamilyDTO object from the database by its name.
     *
     * @param familyName the name of the FamilyDTO object to delete
     * @throws ClassificationException if the FamilyDTO object with the given name is not found
     */
    @Override
    public void deleteByName(String familyName) {
        FamilyModel familyByName = familyRepository.getFamilyByName(familyName);
        if (familyByName == null) {
            throw new ClassificationException(FAMILY_NOT_FOUND, familyName);
        }
        familyRepository.removeEntityFromDatabase(familyByName);
    }

    /**
     * Converts a FamilyModel object to a FamilyDTO object.
     *
     * @param familyModel the FamilyModel object to convert
     * @return the corresponding FamilyDTO object
     */
    private FamilyDTO convertToDTO(FamilyModel familyModel) {
        FamilyDTO familyDTO = new FamilyDTO();
        familyDTO.setFamilyName(familyModel.getFamilyName());
        return familyDTO;
    }

    /**
     * Converts a FamilyDTO object to a FamilyModel object.
     *
     * @param familyDTO the FamilyDTO object to convert
     * @return the corresponding FamilyModel object
     */
    private FamilyModel convertDTOToModel(FamilyDTO familyDTO) {
        FamilyModel familyModel = new FamilyModel();
        familyModel.setFamilyName(familyDTO.getFamilyName());
        return familyModel;
    }
}
