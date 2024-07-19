package dev.foodPos.food.pos.app.Repository;

import dev.foodPos.food.pos.app.Models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
