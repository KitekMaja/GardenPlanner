package feri.ita.plantdb.service.impl.classification;

import feri.ita.plantdb.dao.impl.classification.OrderRepository;
import feri.ita.plantdb.dto.classification.OrderDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.model.classification.OrderModel;
import feri.ita.plantdb.service.IEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IEntityService<OrderDTO> {

    /**
     * Exception messages
     */
    private static final String ORDER_NOT_FOUND = "Order with name [%s] not found.";
    private static final String ORDER_ALREADY_EXISTS = "Order with name [%s] already exists.";
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Retrieves a list of all OrderDTO objects from the database.
     *
     * @return a list of all OrderDTO objects
     */
    @Override
    public List<OrderDTO> getAll() {
        List<OrderModel> orders = orderRepository.retrieveAllFromDatabase();
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * Adds a new OrderDTO object to the database.
     *
     * @param entity the OrderDTO object to add
     * @return the added OrderDTO object
     * @throws ClassificationException if a OrderDTO object with the same name already exists
     */
    @Override
    public OrderDTO add(OrderDTO entity) {
        OrderModel model = convertDTOToModel(entity);
        OrderModel existing = orderRepository.getOrderByName(model.getOrderName());
        if (existing != null) {
            throw new ClassificationException(ORDER_ALREADY_EXISTS, existing.getOrderName());
        }
        OrderModel savedOrder = orderRepository.addEntityToDatabase(model);
        return convertToDTO(savedOrder);
    }

    /**
     * Deletes a OrderDTO object from the database by its name.
     *
     * @param name the name of the OrderDTO object to delete
     * @throws ClassificationException if the OrderDTO object with the given name is not found
     */
    @Override
    public void deleteByName(String name) {
        OrderModel model = orderRepository.getOrderByName(name);
        if (model == null) {
            throw new ClassificationException(ORDER_NOT_FOUND, name);
        }
        orderRepository.removeEntityFromDatabase(model);
    }

    /**
     * Converts a OrderModel object to a OrderDTO object.
     *
     * @param orderModel the OrderModel object to convert
     * @return the corresponding OrderDTO object
     */
    private OrderDTO convertToDTO(OrderModel orderModel) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderName(orderModel.getOrderName());
        return orderDTO;
    }

    /**
     * Converts a OrderDTO object to a OrderModel object.
     *
     * @param orderDTO the OrderDTO object to convert
     * @return the corresponding OrderModel object
     */
    private OrderModel convertDTOToModel(OrderDTO orderDTO) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderName(orderDTO.getOrderName());
        return orderModel;
    }
}
