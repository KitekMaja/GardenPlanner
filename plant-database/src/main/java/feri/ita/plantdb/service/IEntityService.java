package feri.ita.plantdb.service;

import java.util.List;

public interface IEntityService<T> {

    /**
     * Retrieves a list of all entities.
     * @return a list of all entities
     */
    List<T> getAll();

    /**
     * Adds a new entity.
     * @param entity the entity to add
     * @return the added entity
     */
    T add(T entity);

    /**
     * Deletes an entity by name.
     * @param name the name of the entity to delete
     */
    void deleteByName(String name);

}
