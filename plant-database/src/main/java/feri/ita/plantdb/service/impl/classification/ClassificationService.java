package feri.ita.plantdb.service.impl.classification;

import feri.ita.plantdb.dao.impl.classification.*;
import feri.ita.plantdb.dto.classification.ClassificationDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.logs.impl.LoggingInfo;
import feri.ita.plantdb.model.classification.*;
import feri.ita.plantdb.service.IEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClassificationService implements IEntityService<ClassificationDTO> {
    /**
     * Exception messages
     */
    private static final String CLASSIFICATION_NOT_FOUND = "Classification with name [%s] not found.";
    private static final String CLASSIFICATION_ALREADY_EXISTS = "Classification with name [%s] already exists.";
    private static final String CLASS_NOT_FOUND = "Class with name [%s] not found.";
    private static final String FAMILY_NOT_FOUND = "Family with name [%s] not found.";
    private static final String GENUS_NOT_FOUND = "Genus with name [%s] not found.";
    private static final String ORDER_NOT_FOUND = "Order with name [%s] not found.";
    private static final String PHYLUM_NOT_FOUND = "Phylum with name [%s] not found.";

    private final ClassificationRepository classificationRepository;
    private final ClassRepository classRepository;
    private final FamilyRepository familyRepository;
    private final GenusRepository genusRepository;
    private final OrderRepository orderRepository;
    private final PhylumRepository phylumRepository;
    private final LoggingInfo logger = new LoggingInfo(ClassificationDTO.class);

    public ClassificationService(ClassificationRepository classificationRepository, ClassRepository classRepository, FamilyRepository familyRepository, GenusRepository genusRepository, OrderRepository orderRepository, PhylumRepository phylumRepository) {
        this.classificationRepository = classificationRepository;
        this.classRepository = classRepository;
        this.familyRepository = familyRepository;
        this.genusRepository = genusRepository;
        this.orderRepository = orderRepository;
        this.phylumRepository = phylumRepository;
    }

    /**
     * Retrieves a list of all ClassificationDTO objects from the database.
     *
     * @return a list of all ClassificationDTO objects
     */
    @Override
    public List<ClassificationDTO> getAll() {
        logger.logInfoRetrieveAll();
        List<ClassificationModel> classifications = classificationRepository.retrieveAllFromDatabase();
        return classifications.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * Adds a new ClassificationDTO object to the database.
     *
     * @param entity the ClassificationDTO object to add
     * @return the added ClassificationDTO object
     * @throws ClassificationException if a ClassificationDTO object with the same name already exists
     */
    @Override
    public ClassificationDTO add(ClassificationDTO entity) {
        return convertToDTO(classificationRepository.addEntityToDatabase(convertDTOToModel(entity)));
    }

    /**
     * Deletes a ClassificationDTO object from the database by its name.
     *
     * @param name the name of the entity to delete
     * @throws ClassificationException if the ClassificationDTO with the given name is not found in the database
     */
    @Override
    public void deleteByName(String name) {
        ClassificationModel model = classificationRepository.getClassificationByName(name);
        if (model == null) {
            logger.errorEntityNotFound(name);
            throw new ClassificationException(CLASSIFICATION_NOT_FOUND, name);
        }
        classificationRepository.removeEntityFromDatabase(model);
    }

    /**
     * Updates provided ClassificationDTO object.
     *
     * @param name   the name of the entity to update
     * @param entity including data for updates
     * @return the updated entity
     */
    public ClassificationDTO update(String name, ClassificationDTO entity) {
        ClassificationModel model = classificationRepository.getClassificationByName(name);
        if (model == null) {
            logger.errorEntityNotFound(name);
            throw new ClassificationException(CLASSIFICATION_NOT_FOUND, name);
        }
        ClassificationModel updatedModel = classificationRepository.updateClassification(convertDTOToModel(entity));
        return convertToDTO(updatedModel);
    }

    /**
     * Retrieves classifications based on specified types.
     *
     * @param genusName   The name of the genus to filter by. If empty, all genera are included.
     * @param className   The name of the class to filter by. If empty, all classes are included.
     * @param familyName  The name of the family to filter by. If empty, all families are included.
     * @param orderName   The name of the order to filter by. If empty, all orders are included.
     * @param phylumName  The name of the phylum to filter by. If empty, all phyla are included.
     * @return            A list of ClassificationDTO objects that match the specified criteria.
     * @throws ClassificationException If any of the specified types are not found in the corresponding repositories.
     */
    public List<ClassificationDTO> retrieveClassificationsByType(String genusName, String className, String familyName, String orderName, String phylumName)
    {
        if(!genusName.isEmpty() && genusRepository.getGenusByName(genusName) == null) {
            throw new ClassificationException(GENUS_NOT_FOUND, genusName);
        }
        if(!className.isEmpty() && classRepository.getClassByName(className) == null)
        {
            throw new ClassificationException(CLASS_NOT_FOUND, className);
        }
        if(!familyName.isEmpty() && familyRepository.getFamilyByName(familyName) == null)
        {
            throw new ClassificationException(FAMILY_NOT_FOUND, familyName);
        }
        if(!orderName.isEmpty() && orderRepository.getOrderByName(orderName) == null)
        {
            throw new ClassificationException(ORDER_NOT_FOUND, orderName);
        }
        if(!phylumName.isEmpty() && phylumRepository.getPhylumByName(phylumName) == null)
        {
            throw new ClassificationException(PHYLUM_NOT_FOUND, phylumName);
        }

        List<ClassificationModel> classifications = classificationRepository.retrieveClassificationByTypes(genusName, className, familyName, orderName, phylumName);
        return classifications.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    /**
     * Converts a ClassificationModel object to a ClassificationDTO object.
     *
     * @param classificationModel the ClassificationModel object to convert
     * @return the corresponding ClassificationDTO object
     */
    private ClassificationDTO convertToDTO(ClassificationModel classificationModel) {
        ClassificationDTO classificationDTO = new ClassificationDTO();
        classificationDTO.setClassName(classificationModel.getClazz().getClassName());
        classificationDTO.setFamilyName(classificationModel.getFamily().getFamilyName());
        classificationDTO.setGenusName(classificationModel.getGenus().getGenusName());
        classificationDTO.setOrderName(classificationModel.getOrder().getOrderName());
        classificationDTO.setPhylumName(classificationModel.getPhylum().getPhylumName());
        return classificationDTO;
    }

    /**
     * Converts a ClassificationDTO object to a ClassificationModel object.
     *
     * @param classificationDTO the ClassificationDTO object to convert
     * @return the corresponding ClassificationModel object
     */
    private ClassificationModel convertDTOToModel(ClassificationDTO classificationDTO) {
        ClassificationModel classificationModel = new ClassificationModel();
        Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        classificationModel.setClassificationId(uniqueId);
        classificationModel.setClazz(classRepository.getClassByName(classificationDTO.getClassName()));
        classificationModel.setFamily(familyRepository.getFamilyByName(classificationDTO.getFamilyName()));
        classificationModel.setGenus(genusRepository.getGenusByName(classificationDTO.getGenusName()));
        classificationModel.setOrder(orderRepository.getOrderByName(classificationDTO.getOrderName()));
        classificationModel.setPhylum(phylumRepository.getPhylumByName(classificationDTO.getPhylumName()));
        return classificationModel;
    }
}
