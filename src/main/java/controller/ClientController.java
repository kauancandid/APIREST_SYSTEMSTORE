package controller;

import dto.adress.AddressRequestDTO;
import dto.client.ClientRequestDTO;
import dto.client.ClientResponseDTO;
import io.swagger.annotations.ApiOperation;
import model.ClientModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.client.ClientServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/client")
public class ClientController {

    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @ApiOperation("This method is used to save a client.")
    @PostMapping("/save")
    public ResponseEntity<ClientResponseDTO> saveClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO, @Valid AddressRequestDTO addressRequestDTO) {
        ClientModel clientModel = this.clientService.saveClient(clientRequestDTO, addressRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClientResponseDTO.convertToDto(clientModel));
    }

    @ApiOperation("This method is used to delete a client.")
    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<ClientResponseDTO> deleteClient(@PathVariable String clientId) {
        ClientModel client = this.clientService.deleteClient(clientId);
        if(client == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ClientResponseDTO.convertToDto(new ClientModel()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(ClientResponseDTO.convertToDto(client));
    }

    @ApiOperation("This method is used to list all a clients.")
    @GetMapping("/get-all")
    public ResponseEntity<List<ClientResponseDTO>> listAllClient() {
        var clientList = this.clientService.listClientByUserId();
        List<ClientResponseDTO> responseList = new ArrayList<>();
        for (ClientModel clientModel : clientList) {
            responseList.add(ClientResponseDTO.convertToDto(clientModel));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

}
