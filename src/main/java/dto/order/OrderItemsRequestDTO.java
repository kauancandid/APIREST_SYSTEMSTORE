package dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsRequestDTO {

    @NotBlank(message = "campo sku não pode ser vazio")
    private String sku;

    @NotBlank(message = "campo nome não pode ser vazio")
    private String name;

    @NotNull(message = "campo valor unitario não pode ser vazio")
    private double valueUni;

    @NotNull(message = "campo quantidade não pode ser vazio")
    private int quantity;

    @NotNull(message = "campo total não pode ser vazio")
    private double total;

}
