package feri.ita.plantdb.service.impl.classification;

import feri.ita.plantdb.dao.impl.classification.ClassRepository;
import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.logs.impl.LoggingInfo;
import feri.ita.plantdb.model.classification.ClassModel;
import feri.ita.plantdb.service.IEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService implements IEntityService<ClassDTO> {
    /**
     * Exception messages
     */
    private static final String CLASS_NOT_FOUND = "Class with name [%s] not found.";
    private static final String CLASS_ALREADY_EXISTS = "Class with name [%s] already exists.";
    private final LoggingInfo logger = new LoggingInfo(ClassDTO.class);
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    /**
     * Retrieves a list of all ClassDTO objects from the database.
     *
     * @return a list of all ClassDTO objects
     */
    @Override
    public List<ClassDTO> getAll() {
        logger.logInfoRetrieveAll();
        List<ClassModel> classes = classRepository.retrieveAllFromDatabase();
        return classes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * Adds a new ClassDTO object to the database.
     *
     * @param entity the ClassDTO object to add
     * @return the added ClassDTO object
     * @throws ClassificationException if a ClassDTO object with the same name already exists
     */
    @Override
    public ClassDTO add(ClassDTO entity) {
        ClassModel classModel = convertDTOToModel(entity);
        ClassModel existing = classRepository.getClassByName(classModel.getClassName());
        if (existing != null) {
            logger.errorEntityAlreadyExists(existing.getClassName());
            throw new ClassificationException(CLASS_ALREADY_EXISTS, existing.getClassName());
        }
        ClassModel savedClass = classRepository.addEntityToDatabase(classModel);
        return convertToDTO(savedClass);
    }

    /**
     * Deletes a ClassDTO object from the database by its name.
     *
     * @param name the name of the ClassDTO object to delete
     * @throws ClassificationException if the ClassDTO object with the given name is not found
     */
    @Override
    public void deleteByName(String name) {
        ClassModel classByName = classRepository.getClassByName(name);
        if (classByName == null) {
            logger.errorEntityNotFound(name);
            throw new ClassificationException(CLASS_NOT_FOUND, name);
        }
        classRepository.removeEntityFromDatabase(classByName);
    }

    /**
     * Converts a ClassModel object to a ClassDTO object.
     *
     * @param classModel the ClassModel object to convert
     * @return the corresponding ClassDTO object
     */
    private ClassDTO convertToDTO(ClassModel classModel) {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setClassName(classModel.getClassName());
        return classDTO;
    }

    /**
     * Converts a ClassDTO object to a ClassModel object.
     *
     * @param classDTO the ClassDTO object to convert
     * @return the corresponding ClassModel object
     */
    private ClassModel convertDTOToModel(ClassDTO classDTO) {
        ClassModel classModel = new ClassModel();
        classModel.setClassName(classDTO.getClassName());
        return classModel;
    }
}
