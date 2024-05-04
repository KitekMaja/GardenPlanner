package feri.ita.plantdb.service.classification.impl;

import feri.ita.plantdb.dao.classification.IFamilyRepository;
import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.dto.classification.FamilyDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.logs.impl.LoggingInfo;
import feri.ita.plantdb.model.classification.FamilyModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FamilyService {
    /**
     * Exception messages
     */
    private static final String FAMILY_NOT_FOUND = "Family with name [%s] not found.";
    private static final String FAMILY_ALREADY_EXISTS = "Family with name [%s] already exists.";
    private final LoggingInfo logger = new LoggingInfo(ClassDTO.class);
    private final IFamilyRepository familyRepository;

    public FamilyService(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    /**
     * Retrieves a list of all FamilyDTO objects from the database.
     *
     * @return a list of all FamilyDTO objects
     */
    public List<FamilyDTO> getAllFamilyDTOs() {
        logger.logInfoRetrieveAll();
        List<FamilyModel> families = familyRepository.getFamilies();
        return families.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * Retrieves a FamilyDTO object from the database by its name.
     *
     * @param familyName the name of the FamilyDTO object to retrieve
     * @return the FamilyDTO object if found, or null if not found
     * @throws ClassificationException if the FamilyDTO object with the given name is not found
     */
    public FamilyDTO getFamilyDTOByName(String familyName) {
        logger.logInfoRetrieveSpecific(familyName);
        FamilyModel family = familyRepository.getFamilyByName(familyName);
        if (family == null) {
            logger.errorEntityNotFound(familyName);
            throw new ClassificationException(FAMILY_NOT_FOUND, familyName);
        }
        return convertToDTO(family);
    }

    /**
     * Adds a new FamilyDTO object to the database.
     *
     * @param familyDTO the FamilyDTO object to add
     * @return the added FamilyDTO object
     * @throws ClassificationException if a FamilyDTO object with the same name already exists
     */
    public FamilyDTO addFamily(FamilyDTO familyDTO) {
        FamilyModel familyModel = convertDTOToModel(familyDTO);
        FamilyModel exists = familyRepository.getFamilyByName(familyModel.getFamilyName());
        if (exists != null) {
            logger.errorEntityAlreadyExists(exists.getFamilyName());
            throw new ClassificationException(FAMILY_ALREADY_EXISTS, exists.getFamilyName());
        }
        FamilyModel savedFamily = familyRepository.createFamily(familyModel);
        return convertToDTO(savedFamily);
    }

    /**
     * Updates an existing FamilyDTO object in the database.
     *
     * @param familyName the name of the FamilyDTO object to update
     * @param familyDTO  the updated FamilyDTO object
     * @return the updated FamilyDTO object
     * @throws ClassificationException if the FamilyDTO object with the given name is not found
     */
    public FamilyDTO updateFamily(String familyName, FamilyDTO familyDTO) {
        FamilyModel familyByName = familyRepository.getFamilyByName(familyName);
        if (familyByName == null) {
            logger.errorEntityNotFound(familyName);
            throw new ClassificationException(FAMILY_NOT_FOUND, familyName);
        }
        familyByName.setFamilyName(familyDTO.getFamilyName());
        FamilyModel updated = familyRepository.updateFamily(familyByName.getFamilyId(), familyByName);
        return convertToDTO(updated);
    }

    /**
     * Deletes a FamilyDTO object from the database by its name.
     *
     * @param familyName the name of the FamilyDTO object to delete
     * @throws ClassificationException if the FamilyDTO object with the given name is not found
     */
    public void deleteFamily(String familyName) {
        FamilyModel familyByName = familyRepository.getFamilyByName(familyName);
        if (familyByName == null) {
            logger.errorEntityNotFound(familyName);
            throw new ClassificationException(FAMILY_NOT_FOUND, familyName);
        }
        familyRepository.deleteFamily(familyByName);
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
        Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        familyModel.setFamilyId(uniqueId);
        familyModel.setFamilyName(familyDTO.getFamilyName());
        return familyModel;
    }
}
