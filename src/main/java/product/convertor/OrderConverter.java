package product.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import product.controller.productDTO.OrderDto;
import product.repository.model.Order;

import java.util.List;

@Component
public class OrderConverter {

    private static final Logger logger = LoggerFactory.getLogger(OrderConverter.class);

    private final ProductConverter productConverter;
    private final OrderItemConverter orderItemConverter;

    public OrderConverter(ProductConverter productConverter, OrderItemConverter orderItemConverter) {
        this.productConverter = productConverter;
        this.orderItemConverter = orderItemConverter;
    }


    public OrderDto convertToDto(Order order) {
        return convert(order);
    }

    public List<OrderDto> convertToDto(List<Order> all) {
        return all.stream()
                .map(this::convert)
                .toList();
    }

    public Order convertToEntity(OrderDto source) {
        Order result = new Order();
        result.setProduct(productConverter.convertToEntity(source.getProduct()));
        result.setOrderItemDTOList(orderItemConverter.convertToEntity(source.getOrderItemDTOList(), result));
        result.setCreatedAt(source.getCreatedAt());
        result.setComment(source.getComment());
        return result;
    }

    private OrderDto convert(Order source) {
        OrderDto target = new OrderDto();
        target.setId(source.getId());
        target.setCreatedAt(source.getCreatedAt());
        target.setProduct(productConverter.convertToDto(source.getProduct()));
        logger.debug("сейчас будем качать строчки заказа!------------------");
        target.setOrderItemDTOList(orderItemConverter.convertToDto(source.getOrderItemList()));
        target.setComment(source.getComment());
        return target;
    }
}