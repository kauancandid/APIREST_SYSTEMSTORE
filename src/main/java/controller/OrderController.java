package controller;

import dto.client.ClientResponseDTO;
import dto.order.OrderRequestDTO;
import dto.order.OrderResponseDTO;
import io.swagger.annotations.ApiOperation;
import model.ClientModel;
import model.OrderModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.ClientRepository;
import service.client.ClientServiceImpl;
import service.order.OrderServiceImpl;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/order")
public class OrderController {

    private final OrderServiceImpl orderService;

    private final ClientRepository clientRepository;

    public OrderController(OrderServiceImpl orderService, ClientRepository clientRepository) {
        this.orderService = orderService;
        this.clientRepository = clientRepository;
    }

    @ApiOperation("This method is used to save a order.")
    @PostMapping("/save/{clientId}")
    public ResponseEntity<OrderResponseDTO> saveOrder(@RequestBody @Valid OrderRequestDTO orderRequestDTO, @PathVariable String clientId) {
        OrderModel orderModel = this.orderService.saveOrder(clientId, orderRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(OrderResponseDTO.convertToDto(orderModel));
    }

    @ApiOperation("This method is used to delete a client.")
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<OrderResponseDTO> deleteOrder(@PathVariable String orderId) {
        OrderModel order = this.orderService.deleteOrder(orderId);
        if(order == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(OrderResponseDTO.convertToDto(new OrderModel()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(OrderResponseDTO.convertToDto(order));
    }
}
