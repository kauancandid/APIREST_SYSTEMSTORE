package service.client;

import dto.adress.AddressRequestDTO;
import dto.client.ClientRequestDTO;
import model.AddressModel;
import model.ClientModel;
import org.springframework.stereotype.Service;
import repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientModel saveClient(ClientRequestDTO clientRequestDTO, AddressRequestDTO addressRequestDTO) {

        Optional<ClientModel> clientAlreadyExists = this.clientRepository.findByEmail(clientRequestDTO.getEmail());
        if (clientAlreadyExists.isPresent()) {
            throw new RuntimeException("Cliente já existe");
        }

        var clientModel = new ClientModel();
        var client = clientAlreadyExists.get();
        clientModel.setFullName(client.getFullName());
        clientModel.setBirthday(client.getBirthday());
        clientModel.setEmail(client.getEmail());
        clientModel.setPhone(client.getPhone());

        var address = new AddressModel();
        address.setCep(addressRequestDTO.getCep());
        address.setCountry(addressRequestDTO.getCountry());
        address.setCity(addressRequestDTO.getCity());
        address.setState(addressRequestDTO.getState());
        address.setStreet(addressRequestDTO.getStreet());
        address.setDistrict(addressRequestDTO.getDistrict());
        address.setNumber(addressRequestDTO.getNumber());
        address.setComplement(addressRequestDTO.getComplement());
        address.setReferencePoint(addressRequestDTO.getReferencePoint());
        address.setClient(client);

        clientModel.setAddresses(address);
        return clientRepository.save(clientModel);

    }

    @Override
    public ClientModel updateClient(String clientId, ClientRequestDTO clientRequestDTO, AddressRequestDTO addressRequestDTO) {

        Optional<ClientModel> clientAlreadyExists = this.clientRepository.findById(UUID.fromString(clientId));
        if (clientAlreadyExists.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        if (this.clientRepository.findByEmail(clientRequestDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email já existe");
        }

        var client = clientAlreadyExists.get();
        client.setFullName(client.getFullName());
        client.setBirthday(client.getBirthday());
        client.setEmail(client.getEmail());
        client.setPhone(client.getPhone());

        var address = new AddressModel();
        address.setCep(addressRequestDTO.getCep());
        address.setCountry(addressRequestDTO.getCountry());
        address.setCity(addressRequestDTO.getCity());
        address.setState(addressRequestDTO.getState());
        address.setStreet(addressRequestDTO.getStreet());
        address.setDistrict(addressRequestDTO.getDistrict());
        address.setNumber(addressRequestDTO.getNumber());
        address.setComplement(addressRequestDTO.getComplement());
        address.setReferencePoint(addressRequestDTO.getReferencePoint());

        client.setAddresses(address);

        return clientRepository.save(client);
    }

    @Override
    public ClientModel deleteClient(String clientId) {

        Optional<ClientModel> clientAlreadyExists = this.clientRepository.findById(UUID.fromString(clientId));
        if (clientAlreadyExists.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }else{
            clientRepository.delete(clientAlreadyExists.get());
            return clientAlreadyExists.get();

        }
    }

    @Override
    public List<ClientModel> listClientByUserId() {
        return clientRepository.findAll();
    }
}
