package feri.ita.plantdb.service.classification.impl;

import feri.ita.plantdb.dto.classification.OrderDTO;
import feri.ita.plantdb.model.classification.OrderModel;

import java.util.UUID;

public class OrderService {
    private OrderDTO convertToDTO(OrderModel orderModel) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderName(orderModel.getOrderName());
        return orderDTO;
    }

    private OrderModel convertDTOToModel(OrderDTO orderDTO) {
        OrderModel orderModel = new OrderModel();
        Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        orderModel.setOrderId(uniqueId);
        orderModel.setOrderName(orderDTO.getOrderName());
        return orderModel;
    }
}
