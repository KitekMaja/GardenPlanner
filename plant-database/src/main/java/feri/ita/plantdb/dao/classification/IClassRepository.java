package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.model.classification.ClassModel;

import java.util.List;

public interface IClassRepository {
    ClassModel getClassByName(String name);
    ClassModel addClass(ClassModel classModel);
    List<ClassModel> getClasses();
    ClassModel updateClass(Long id, ClassModel classModel);
    void deleteClass(String name);
}