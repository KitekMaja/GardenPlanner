package feri.ita.plantdatabase.dao.classification.impl;

import feri.ita.plantdatabase.dao.classification.IClassRepository;
import feri.ita.plantdatabase.dto.classification.ClassDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClassRepository implements IClassRepository {
    /**
     * @param id
     * @return
     */
    @Override
    public ClassDTO getClassById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public ClassDTO getClassByName(String name) {
        return null;
    }

    /**
     * @param classDTO
     */
    @Override
    public void addClass(ClassDTO classDTO) {

    }

    /**
     * @return
     */
    @Override
    public List<ClassDTO> getClasses() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ClassDTO updateClass(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteClass(Long id) {

    }
}
