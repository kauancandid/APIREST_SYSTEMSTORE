package service.order;

import dto.order.OrderItemsRequestDTO;
import model.OrderItemsModel;
import org.springframework.stereotype.Service;
import repository.OrderItemsRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemsServiceImpl implements OrderItemsService{
    private final OrderItemsRepository orderItemsRepository;

    public OrderItemsServiceImpl(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    public OrderItemsModel saveItem(OrderItemsRequestDTO itemsRequestDTO) {

        var item = new OrderItemsModel();

        if(itemsRequestDTO.getValueUni() == 0){
            new RuntimeException("O valor unitário de um pedido não pode ser 0");
        }else{
            item.setValueUni(itemsRequestDTO.getValueUni());
        }

        item.setName(itemsRequestDTO.getName());
        item.setQuantity(itemsRequestDTO.getQuantity());
        item.setSku(itemsRequestDTO.getSku());
        item.setTotal(itemsRequestDTO.getQuantity() * itemsRequestDTO.getValueUni());
        return orderItemsRepository.save(item);
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<OrderItemsModel> itemAlreadyExists = this.orderItemsRepository.findById(UUID.fromString(itemId));
        if (itemAlreadyExists.isEmpty()) {
            throw new RuntimeException("Item não encontrado");
        }
        this.orderItemsRepository.delete(itemAlreadyExists.get());

    }
}
