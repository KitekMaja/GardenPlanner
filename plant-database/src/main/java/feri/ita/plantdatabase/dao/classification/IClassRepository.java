package feri.ita.plantdatabase.dao.classification;

import feri.ita.plantdatabase.dto.classification.ClassDTO;

import java.util.List;

public interface IClassRepository {
    ClassDTO getClassById(Long id);
    ClassDTO getClassByName(String name);
    void addClass(ClassDTO classDTO);
    List<ClassDTO> getClasses();
    ClassDTO updateClass(Long id);
    void deleteClass(Long id);
}