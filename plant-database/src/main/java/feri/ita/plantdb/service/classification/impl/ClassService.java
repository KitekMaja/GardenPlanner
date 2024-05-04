package feri.ita.plantdb.service.classification.impl;

import feri.ita.plantdb.dao.classification.IClassRepository;
import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.logs.impl.LoggingInfo;
import feri.ita.plantdb.model.classification.ClassModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {
    /**
     * Exception messages
     */
    private static final String CLASS_NOT_FOUND = "Class with name [%s] not found.";
    private static final String CLASS_ALREADY_EXISTS = "Class with name [%s] already exists.";
    private final LoggingInfo logger = new LoggingInfo(ClassDTO.class);
    private final IClassRepository classRepository;

    public ClassService(IClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    /**
     * Retrieves a list of all ClassDTO objects from the database.
     *
     * @return a list of all ClassDTO objects
     */
    public List<ClassDTO> getAllClassDTOs() {
        logger.logInfoRetrieveAll();
        List<ClassModel> classes = classRepository.getClasses();
        return classes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * Retrieves a ClassDTO object from the database by its name.
     *
     * @param className the name of the ClassDTO object to retrieve
     * @return the ClassDTO object if found, or null if not found
     * @throws ClassificationException if the ClassDTO object with the given name is not found
     */
    public ClassDTO getClassDTOByName(String className) {
        logger.logInfoRetrieveSpecific(className);
        ClassModel classByName = classRepository.getClassByName(className);
        if (classByName == null) {
            logger.errorEntityNotFound(className);
            throw new ClassificationException(CLASS_NOT_FOUND, className);
        }
        return convertToDTO(classByName);
    }

    /**
     * Adds a new ClassDTO object to the database.
     *
     * @param classDTO the ClassDTO object to add
     * @return the added ClassDTO object
     * @throws ClassificationException if a ClassDTO object with the same name already exists
     */
    public ClassDTO addClass(ClassDTO classDTO) {
        ClassModel classModel = convertDTOToModel(classDTO);
        ClassModel existing = classRepository.getClassByName(classModel.getClassName());
        if (existing != null) {
            logger.errorEntityAlreadyExists(existing.getClassName());
            throw new ClassificationException(CLASS_ALREADY_EXISTS, existing.getClassName());
        }
        ClassModel savedClass = classRepository.addClass(classModel);
        return convertToDTO(savedClass);
    }

    /**
     * Updates an existing ClassDTO object in the database.
     *
     * @param className the name of the ClassDTO object to update
     * @param classDTO  the updated ClassDTO object
     * @return the updated ClassDTO object
     * @throws ClassificationException if the ClassDTO object with the given name is not found
     */
    public ClassDTO updateClass(String className, ClassDTO classDTO) {
        ClassModel classByName = classRepository.getClassByName(className);
        if (classByName == null) {
            logger.errorEntityNotFound(className);
            throw new ClassificationException(CLASS_NOT_FOUND, className);
        }
        classByName.setClassName(classDTO.getClassName());
        ClassModel updated = classRepository.updateClass(classByName.getClassId(), classByName);
        return convertToDTO(updated);
    }

    /**
     * Deletes a ClassDTO object from the database by its name.
     *
     * @param className the name of the ClassDTO object to delete
     * @throws ClassificationException if the ClassDTO object with the given name is not found
     */
    public void deleteClass(String className) {
        ClassModel classByName = classRepository.getClassByName(className);
        if (classByName == null) {
            logger.errorEntityNotFound(className);
            throw new ClassificationException(CLASS_NOT_FOUND, className);
        }
        classRepository.deleteClass(classByName);
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
