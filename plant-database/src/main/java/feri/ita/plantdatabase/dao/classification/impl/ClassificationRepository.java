package feri.ita.plantdatabase.dao.classification.impl;

import feri.ita.plantdatabase.dao.classification.IClassificationRepository;
import feri.ita.plantdatabase.dto.classification.ClassificationDTO;
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
    public List<ClassificationDTO> getClassifications() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ClassificationDTO getClassificationById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public ClassificationDTO getClassificationByName(String name) {
        return null;
    }

    /**
     * @param classificationDTO
     */
    @Override
    public void addClassification(ClassificationDTO classificationDTO) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public ClassificationDTO updateClassification(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteClassification(Long id) {

    }
}
