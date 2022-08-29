package service.order;

import dto.order.OrderItemsRequestDTO;
import dto.order.OrderRequestDTO;
import model.ClientModel;
import model.OrderItemsModel;
import model.OrderModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ClientRepository;
import repository.OrderItemsRepository;
import repository.OrderRepository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderItemsServiceImpl itemsService;

    private final OrderItemsRepository orderItemsRepository;
    private final ClientRepository clientRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemsServiceImpl itemsService, OrderItemsRepository orderItemsRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.itemsService = itemsService;
        this.orderItemsRepository = orderItemsRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    @Override
    public OrderModel saveOrder(String clientId, OrderRequestDTO orderRequestDTO) {

        List<OrderItemsRequestDTO> itemList = orderRequestDTO.getItemsList();

        Optional<ClientModel> clientAlreadyExists = this.clientRepository.findById(UUID.fromString(clientId));
        if (clientAlreadyExists.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado, possa ser que não tenha cadastro ainda...");
        }

        var order = new OrderModel();
        var client = clientAlreadyExists.get();
        order.setClientId(String.valueOf(client.getId()));
        order.setClientAdress(String.valueOf(client.getAddresses()));

        for (OrderItemsRequestDTO orderItemsRequestDTO : itemList){
            order.getItems().add(this.itemsService.saveItem(orderItemsRequestDTO));
        }

        if(orderRequestDTO.getTotal() == 0){
            new RuntimeException("Valor de um pedido não pode ser 0");

        }

        double valor = 0;
        for(OrderItemsModel itemsTotal : order.getItems()){
            valor = (itemsTotal.getTotal() + valor);
        }

        order.setTotal(valor);
        return orderRepository.save(order);


    }

    @Override
    public OrderModel deleteOrder(String orderId) {

        Optional<OrderModel> orderAlreadyExists = this.orderRepository.findById(UUID.fromString(orderId));
        if (orderAlreadyExists.isEmpty()) {
            throw new RuntimeException("Pedido não encontrado");
        }
        this.orderRepository.delete(orderAlreadyExists.get());
        return orderAlreadyExists.get();

    }
}
