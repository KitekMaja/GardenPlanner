package feri.ita.plantdatabase.dao.classification.impl;

import feri.ita.plantdatabase.dao.classification.IOrderRepository;
import feri.ita.plantdatabase.dto.classification.OrderDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderRepository implements IOrderRepository {
    /**
     * @return
     */
    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public OrderDTO getOrderById(Long id) {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public OrderDTO getOrderByName(String name) {
        return null;
    }

    /**
     * @param orderDTO
     */
    @Override
    public void addOrder(OrderDTO orderDTO) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public OrderDTO updateOrder(Long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteOrder(Long id) {

    }
}
