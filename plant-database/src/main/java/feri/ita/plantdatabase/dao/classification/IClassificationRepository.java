package feri.ita.plantdatabase.dao.classification;

import feri.ita.plantdatabase.dto.classification.ClassificationDTO;

import java.util.List;

public interface IClassificationRepository {
    List<ClassificationDTO> getClassifications();

    ClassificationDTO getClassificationById(Long id);

    ClassificationDTO getClassificationByName(String name);

    void addClassification(ClassificationDTO classificationDTO);

    ClassificationDTO updateClassification(Long id);

    void deleteClassification(Long id);
}