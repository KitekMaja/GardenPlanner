package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.dto.classification.ClassificationDTO;
import feri.ita.plantdb.model.classification.ClassificationModel;

import java.util.List;

public interface IClassificationRepository {
    List<ClassificationModel> getClassifications();

    ClassificationModel getClassificationByName(String name);

    void addClassification(ClassificationModel classificationModel);

    ClassificationModel updateClassification(Long id);

    void deleteClassification(Long id);
}