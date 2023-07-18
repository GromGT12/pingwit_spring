package product.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import product.controller.productDTO.OrderDto;
import product.convertor.OrderConverter;
import product.exсeption.PingwitNotFoundExсeption;
import product.repository.OrderRepository;
import product.repository.model.Order;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public OrderServiceImpl(OrderRepository orderRepository, OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
    }


    @Override
    public List<OrderDto> getAll() {
        List<Order> all = orderRepository.findAll();
        return orderConverter.convertToDto(all);
    }

    @Override
    public Integer createOrder(OrderDto orderDto) {
        Order order = orderConverter.convertToEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getId();
    }

    @Override
    public void deleteOrder(Integer orderId) {

    }

    @Override
    public OrderDto getById(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new PingwitNotFoundExсeption("Order not found: " + orderId));
        return orderConverter.convertToDto(order);
    }
}
