package dto.client;

import dto.adress.AddressRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {

    @NotBlank(message = "campo nome inteiro não pode ser vazio")
    private String fullName;

    @NotBlank(message = "campo email não pode ser vazio")
    private String email;

    @NotBlank(message = "campo do telefone não pode ser vazio")
    private String phone;

    @NotNull(message = "campo mês de aniversário não pode ser vazio")
    private Calendar birthday;

    @NotNull(message = "Endereço não pode ser vazio")
    private AddressRequestDTO addressList;

}