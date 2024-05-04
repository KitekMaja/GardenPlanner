package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.model.classification.FamilyModel;

import java.util.List;

public interface IFamilyRepository {

    /**
     * Adds a new FamilyModel entity to the database.
     *
     * @param family the FamilyModel entity to add
     * @return the added FamilyModel entity
     */
    FamilyModel createFamily(FamilyModel family);

    /**
     * Updates a FamilyModel entity in the database based on the given ID.
     *
     * @param id     the ID of the FamilyModel entity to update
     * @param family the updated FamilyModel entity
     * @return the updated FamilyModel entity
     */
    FamilyModel updateFamily(Long id, FamilyModel family);

    /**
     * Retrieves a FamilyModel entity from the database by its name.
     *
     * @param name the name of the FamilyModel entity to retrieve
     * @return the FamilyModel entity if found, or null if not found
     */
    FamilyModel getFamilyByName(String name);

    /**
     * Deletes a FamilyModel entity from the database.
     *
     * @param family the FamilyModel entity to delete
     */
    void deleteFamily(FamilyModel family);

    /**
     * Retrieves a list of all FamilyModel entities from the database.
     *
     * @return a list of all FamilyModel entities
     */
    List<FamilyModel> getFamilies();
}
