package dto.adress;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import model.AddressModel;

import java.util.UUID;

@Getter
@Setter
@Data
public class AddressResponseDTO {

    private UUID id;
    private String cep;
    private String country;
    private String state;
    private String city;
    private String street;
    private String district;
    private String number;
    private String complement;
    private String referencePoint;

    public static AddressResponseDTO convertToDto(AddressModel address){
        var addressResponseDTO = new AddressResponseDTO();

        addressResponseDTO.setId(address.getId());
        addressResponseDTO.setCep(address.getCep());
        addressResponseDTO.setCountry(address.getCountry());
        addressResponseDTO.setState(address.getState());
        addressResponseDTO.setCity(address.getCity());
        addressResponseDTO.setStreet(address.getStreet());
        addressResponseDTO.setDistrict(address.getDistrict());
        addressResponseDTO.setNumber(address.getNumber());
        addressResponseDTO.setReferencePoint(address.getReferencePoint());
        addressResponseDTO.setComplement(address.getComplement());
        return addressResponseDTO;
    }
}
