package feri.ita.plantdb.controller.classification;

import feri.ita.plantdb.dto.classification.OrderDTO;
import feri.ita.plantdb.exception.ClassificationException;
import feri.ita.plantdb.service.impl.classification.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification/order")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Retrieves a list of all OrderDTO objects.
     *
     * @return a ResponseEntity containing a list of OrderDTO objects with HTTP status 200 OK
     * or an empty list if no order is found, or HTTP status 500 Internal Server Error if there is an unknown error during retrieval
     */
    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDTO>> getAllOrderDTOs() {
        try {
            List<OrderDTO> orderDTOS = orderService.getAll();
            return ResponseEntity.ok().body(orderDTOS);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Adds a new OrderDTO object.
     *
     * @param orderDTO the OrderDTO object to add
     * @return a ResponseEntity containing the added OrderDTO object with HTTP status 200 OK
     * or HTTP status 409 Conflict if a conflict occurs
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @PostMapping("/addOrder")
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDTO) {
        try {
            OrderDTO order = orderService.add(orderDTO);
            return ResponseEntity.ok().body(order);
        } catch (ClassificationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Deletes a OrderDTO object by its name.
     *
     * @param orderName the name of the OrderDTO object to delete
     * @return a ResponseEntity with HTTP status 200 OK if the deletion is successful
     * or HTTP status 404 Not Found if the order with the given name is not found
     * or HTTP status 500 Internal Server Error if an error occurs
     */
    @DeleteMapping("/deleteOrder")
    public ResponseEntity<Void> deleteOrder(@RequestParam String orderName) {
        try {
            orderService.deleteByName(orderName);
            return ResponseEntity.ok().build();
        } catch (ClassificationException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
