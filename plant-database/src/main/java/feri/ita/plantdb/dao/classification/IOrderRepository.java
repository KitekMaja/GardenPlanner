package feri.ita.plantdb.dao.classification;

import feri.ita.plantdb.dto.classification.OrderDTO;

import java.util.List;

public interface IOrderRepository {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Long id);

    OrderDTO getOrderByName(String name);

    void addOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(Long id);

    void deleteOrder(Long id);
}
