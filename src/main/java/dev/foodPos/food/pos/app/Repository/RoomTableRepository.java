package dev.foodPos.food.pos.app.Repository;

import dev.foodPos.food.pos.app.Models.RoomTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTableRepository extends MongoRepository<RoomTable, String> {

}
