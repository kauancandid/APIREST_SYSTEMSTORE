package dto.order;

import dto.adress.AddressRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    @NotBlank(message = "O campo client não pode ser vazio!")
    private String clientId;

    @NotBlank(message = "O campo endereço não pode ser vazio!")
    private String clientAdress;

    @NotNull(message = "O campo total não pode ser vazio!")
    private double total;

    @NotNull(message = "items não pode ser vazio")
    private List<OrderItemsRequestDTO> itemsList;

}