package dto.order;

import dto.adress.AddressResponseDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import model.AddressModel;
import model.OrderItemsModel;
import model.OrderModel;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class OrderResponseDTO {

    private String clientId;
    private String clientAdress;
    private double total;
    private List<OrderItemsResponseDTO> itemsList = new ArrayList<>();

    public static OrderResponseDTO convertToDto(OrderModel orderModel){

        var orderResponse = new OrderResponseDTO();
        orderResponse.setClientId(orderModel.getClientId());
        orderResponse.setClientAdress(orderModel.getClientAdress());
        orderResponse.setTotal(orderModel.getTotal());

        for (OrderItemsModel items : orderModel.getItems()){
            orderResponse.getItemsList().add(OrderItemsResponseDTO.convertToDto(items));
        }

        return orderResponse;

    }
}
