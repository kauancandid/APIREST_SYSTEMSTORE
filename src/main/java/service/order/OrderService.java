package service.order;

import dto.order.OrderRequestDTO;
import model.OrderModel;

public interface OrderService {

    OrderModel saveOrder(String clientId, OrderRequestDTO orderRequestDTO);
    OrderModel deleteOrder(String orderId);
}
