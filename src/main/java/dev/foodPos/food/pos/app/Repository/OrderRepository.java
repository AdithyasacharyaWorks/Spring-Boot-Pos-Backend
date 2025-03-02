package dev.foodPos.food.pos.app.Repository;

import dev.foodPos.food.pos.app.Models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // Custom query methods can be defined here if needed
}
