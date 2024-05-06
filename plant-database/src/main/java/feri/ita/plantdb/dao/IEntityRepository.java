package feri.ita.plantdb.dao;

import java.util.List;

public interface IEntityRepository<T> {

    /**
     * Retrieves a list of all entities from database.
     *
     * @return a list of all entities
     */
    List<T> retrieveAllFromDatabase();

    /**
     * Saves new entity to the database.
     *
     * @param entity the entity to add
     * @return the added entity
     */
    T addEntityToDatabase(T entity);

    /**
     * Removes entity from database.
     *
     * @param entity to delete
     */
    void removeEntityFromDatabase(T entity);
}
