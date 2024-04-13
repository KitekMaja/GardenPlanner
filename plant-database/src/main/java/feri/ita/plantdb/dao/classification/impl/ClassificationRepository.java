package feri.ita.plantdb.dao.classification.impl;

import feri.ita.plantdb.dao.classification.IClassificationRepository;
import feri.ita.plantdb.dto.classification.ClassificationDTO;
import feri.ita.plantdb.model.classification.ClassificationModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClassificationRepository implements IClassificationRepository {

    /**
     * @return
     */
    @Override
    public List<ClassificationModel> getClassifications() {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public ClassificationModel getClassificationByName(String name) {
        return null;
    }

    /**
     * @param classificationModel
     */
    @Override
    public void addClassification(ClassificationModel classificationModel) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public ClassificationModel updateClassification(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteClassification(Long id) {

    }
}
