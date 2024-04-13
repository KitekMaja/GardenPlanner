package feri.ita.plantdb.service.classification.impl;

import feri.ita.plantdb.dao.classification.IClassRepository;
import feri.ita.plantdb.dto.classification.ClassDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.model.classification.ClassModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClassService{

    private static final Logger log = LoggerFactory.getLogger(ClassService.class);
    private final IClassRepository classRepository;

    public ClassService(IClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<ClassDTO> getAllClassDTOs()
    {
        log.info("Retrieving all classes");
        List<ClassModel> classes = classRepository.getClasses();
        return classes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ClassDTO getClassDTOByName(String className)
    {
        log.info("Retrieving class by name = {}", className);
        ClassModel classByName = classRepository.getClassByName(className);
        if(classByName == null)
        {
            log.error("Class with name [{}] not found!", className);
            throw new ClassificationException("Class with name [" + className + "] not found!");
        }
        return convertToDTO(classByName);
    }

    public ClassDTO addClass(ClassDTO classDTO)
    {
        ClassModel classModel = convertDTOToModel(classDTO);
        ClassModel existing = classRepository.getClassByName(classModel.getClassName());
        if(existing!=null)
        {
            log.error("Class with name [{}] already exists!", existing.getClassName());
            throw new ClassificationException("Class with name [" + classModel.getClassName() + "] already exists!");
        }
        classModel.setClassId(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
        ClassModel savedClass = classRepository.addClass(classModel);
        return convertToDTO(savedClass);
    }

    public ClassDTO updateClass(String className, ClassDTO classDTO)
    {
        ClassModel classByName = classRepository.getClassByName(className);
        if (classByName == null)
        {
            log.error("Class with name [{}] not found!", className);
            throw new ClassificationException("Class with name [" + className + "] not found!");
        }
        classByName.setClassName(classDTO.getClassName());
        ClassModel updated = classRepository.updateClass(classByName.getClassId(), classByName);
        return convertToDTO(updated);
    }

    public void deleteClass(String className)
    {
        ClassModel classByName = classRepository.getClassByName(className);
        if (classByName == null)
        {
            log.error("Class with name [{}] not found!", className);
            throw new ClassificationException("Class with name [" + className + "] not found!");
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
        Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        classModel.setClassId(uniqueId);
        classModel.setClassName(classDTO.getClassName());
        return classModel;
    }
}
