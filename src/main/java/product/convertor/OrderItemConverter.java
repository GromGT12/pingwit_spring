package product.convertor;

import org.springframework.stereotype.Component;
import product.controller.productDTO.OrderItemDto;
import product.repository.model.Order;
import product.repository.model.OrderItem;


import java.util.List;

@Component
public class OrderItemConverter {
    private final ProductConverter productConverter;

    public OrderItemConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public List<OrderItemDto> convertToDto(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::convertToDto)
                .toList();
    }

    private OrderItemDto convertToDto(OrderItem orderItem) {
        OrderItemDto result = new OrderItemDto();
        result.setId(orderItem.getId());
        result.setOrderId(orderItem.getOrder().getId());
        result.setProduct(productConverter.convertProductToDto(orderItem.getProduct()));
        result.setQuantity(orderItem.getQuantity());
        return result;
    }

    public List<OrderItem> convertToEntity(List<OrderItemDto> orderItems, Order order) {
        return orderItems.stream()
                .map(item -> convertToEntity(item, order))
                .toList();
    }

    private OrderItem convertToEntity(OrderItemDto source, Order order) {
        OrderItem result = new OrderItem();
        result.setOrder(order);
        result.setProduct(productConverter.convertToEntity(source.getProduct()));
        result.setQuantity(source.getQuantity());
        return result;
    }
}