package feri.ita.plantdb.dao.impl.classification;

import feri.ita.plantdb.dao.IEntityRepository;
import feri.ita.plantdb.model.classification.OrderModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderRepository implements IEntityRepository<OrderModel> {
    private final EntityManager entityManager;

    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /**
     * Retrieves a list of all OrderModel entities from the database.
     *
     * @return a list of all OrderModel entities
     */
    @Override
    public List<OrderModel> retrieveAllFromDatabase() {
        return entityManager.createQuery("SELECT o FROM OrderModel o", OrderModel.class).getResultList();
    }

    /**
     * Adds a new OrderModel entity to the database.
     *
     * @param entity the OrderModel entity to add
     * @return the added OrderModel entity
     */
    @Override
    public OrderModel addEntityToDatabase(OrderModel entity) {
        entityManager.persist(entity);
        return entityManager.find(OrderModel.class, entity.getOrderId());
    }

    /**
     * Deletes a OrderModel entity from the database.
     *
     * @param entity the OrderModel entity to delete
     */
    @Override
    public void removeEntityFromDatabase(OrderModel entity) {
        entityManager.remove(entity);
    }

    /**
     * Retrieves a OrderModel entity from the database by its name.
     *
     * @param name the name of the OrderModel entity to retrieve
     * @return the OrderModel entity if found, or null if not found
     */
    public OrderModel getOrderByName(String name) {
        try {
            return entityManager.createQuery("SELECT o FROM OrderModel o WHERE o.orderName = :name", OrderModel.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
