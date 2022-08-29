package dto.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import model.OrderItemsModel;

import java.util.UUID;

@Getter
@Setter
@Data
public class OrderItemsResponseDTO {

    private UUID id;
    private String sku;
    private String name;
    private double valueUni;
    private int quantity;
    private double total;

    public static OrderItemsResponseDTO convertToDto(OrderItemsModel orderItemsModel){

        var orderItems = new OrderItemsResponseDTO();
        orderItems.setId(orderItemsModel.getId());
        orderItems.setSku(orderItemsModel.getSku());
        orderItems.setName(orderItemsModel.getName());
        orderItems.setValueUni(orderItemsModel.getValueUni());
        orderItems.setQuantity(orderItemsModel.getQuantity());
        orderItems.setTotal(orderItemsModel.getTotal());

        return orderItems;
    }
}
