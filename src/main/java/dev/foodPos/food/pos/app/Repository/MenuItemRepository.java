package dev.foodPos.food.pos.app.Repository;

import dev.foodPos.food.pos.app.Models.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
}
