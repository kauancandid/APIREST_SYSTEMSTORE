package dto.adress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {

    @NotBlank(message = "O campo CEP não pode ser vazio!")
    private String cep;

    @NotBlank(message = "O campo País não pode ser vazio!")
    private String country;

    @NotBlank(message = "O campo Estado não pode ser vazio!")
    private String state;

    @NotBlank(message = "O campo cidade não pode ser vazio!")
    private String city;

    @NotBlank(message = "O campo bairro não pode ser vazio!")
    private String district;

    @NotBlank(message = "O campo rua não pode ser vazio!")
    private String street;

    @NotBlank(message = "O campo número não pode ser vazio!")
    private String number;

    @NotBlank(message = "O campo complemento não pode estar vazio!")
    private String complement;

    @NotBlank(message = "O campo de ponto de referencia não pode estar vazio!")
    private String referencePoint;

}