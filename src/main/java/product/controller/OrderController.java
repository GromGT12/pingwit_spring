package product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import product.controller.productDTO.OrderDto;
import product.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController{

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping
    public Integer createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Integer id) {
        LOGGER.trace(String.format("requested order# %s", id));
        return orderService.getById(id);
    }
}

