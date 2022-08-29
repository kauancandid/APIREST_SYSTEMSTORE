package repository;

import model.OrderItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemsRepository extends JpaRepository<OrderItemsModel, UUID> {
}
