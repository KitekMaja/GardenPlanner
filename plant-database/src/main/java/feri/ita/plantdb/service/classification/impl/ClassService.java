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

    public List<ClassDTO> getAllClassDTOs() {
        logger.logInfoRetrieveAll();
        List<ClassModel> classes = classRepository.getClasses();
        return classes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ClassDTO getClassDTOByName(String className) {
        logger.logInfoRetrieveSpecific(className);
        ClassModel classByName = classRepository.getClassByName(className);
        if (classByName == null) {
            logger.errorEntityNotFound(className);
            throw new ClassificationException(CLASS_NOT_FOUND, className);
        }
        return convertToDTO(classByName);
    }

    public ClassDTO addClass(ClassDTO classDTO) {
        ClassModel classModel = convertDTOToModel(classDTO);
        ClassModel existing = classRepository.getClassByName(classModel.getClassName());
        if (existing != null) {
            logger.errorEntityAlreadyExists(existing.getClassName());
            throw new ClassificationException(CLASS_ALREADY_EXISTS, classModel.getClassName());
        }
        ClassModel savedClass = classRepository.addClass(classModel);
        return convertToDTO(savedClass);
    }

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

    public void deleteClass(String className) {
        ClassModel classByName = classRepository.getClassByName(className);
        if (classByName == null) {
            logger.errorEntityNotFound(className);
            throw new ClassificationException(CLASS_NOT_FOUND, className);
        }
        classRepository.deleteClass(className);
    }

    private ClassDTO convertToDTO(ClassModel classModel) {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setClassName(classModel.getClassName());
        return classDTO;
    }

    private ClassModel convertDTOToModel(ClassDTO classDTO) {
        ClassModel classModel = new ClassModel();
        classModel.setClassName(classDTO.getClassName());
        return classModel;
    }
}
