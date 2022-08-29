package dto.client;

import dto.adress.AddressResponseDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import model.AddressModel;
import model.ClientModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Data
public class ClientResponseDTO {

    private String fullName;
    private String email;
    private String phone;
    private Calendar birthday;
    private AddressResponseDTO addressList;

    public static ClientResponseDTO convertToDto(ClientModel clientModel){

        var clientResponse = new ClientResponseDTO();
        clientResponse.setBirthday(clientModel.getBirthday());
        clientResponse.setEmail(clientModel.getEmail());
        clientResponse.setPhone(clientModel.getPhone());
        clientResponse.setFullName(clientModel.getFullName());
        clientResponse.setAddressList(AddressResponseDTO.convertToDto(clientModel.getAddresses()));

        return  clientResponse;
    }
}
