package service.order;

import dto.order.OrderItemsRequestDTO;
import model.OrderItemsModel;

public interface OrderItemsService {

    OrderItemsModel saveItem(OrderItemsRequestDTO itemsRequestDTO);
    void deleteItem(String itemId);
}
