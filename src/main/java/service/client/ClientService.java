package service.client;

import dto.adress.AddressRequestDTO;
import dto.client.ClientRequestDTO;
import model.ClientModel;

import java.util.List;

public interface ClientService {

    ClientModel saveClient(ClientRequestDTO clientRequestDTO, AddressRequestDTO addressRequestDTO);
    ClientModel updateClient(String clientId, ClientRequestDTO clientRequestDTO, AddressRequestDTO addressRequestDTO);
    ClientModel deleteClient(String clientId);
    List<ClientModel> listClientByUserId();

}
