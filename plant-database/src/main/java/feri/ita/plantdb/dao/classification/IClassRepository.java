package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.model.classification.ClassModel;

import java.util.List;

public interface IClassRepository {
    /**
     * Retrieves a ClassModel entity from the database by its name.
     *
     * @param name the name of the ClassModel entity to retrieve
     * @return the ClassModel entity if found, or null if not found
     */
    ClassModel getClassByName(String name);

    /**
     * Adds a new ClassModel entity to the database.
     *
     * @param classModel the ClassModel entity to add
     * @return the added ClassModel entity
     */
    ClassModel addClass(ClassModel classModel);

    /**
     * Retrieves a list of all ClassModel entities from the database.
     *
     * @return a list of all ClassModel entities
     */
    List<ClassModel> getClasses();

    /**
     * Updates a ClassModel entity in the database based on the given ID.
     *
     * @param id         the ID of the ClassModel entity to update
     * @param classModel the updated ClassModel entity
     * @return the updated ClassModel entity
     */
    ClassModel updateClass(Long id, ClassModel classModel);

    /**
     * Deletes a ClassModel entity from the database.
     *
     * @param classModel the ClassModel entity to delete
     */
    void deleteClass(ClassModel classModel);
}