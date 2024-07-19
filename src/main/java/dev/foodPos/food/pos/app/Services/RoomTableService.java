package dev.foodPos.food.pos.app.Services;

import dev.foodPos.food.pos.app.Models.RoomTable;
import dev.foodPos.food.pos.app.Repository.RoomTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTableService {

    @Autowired
    private RoomTableRepository roomTableRepository;

    public List<RoomTable> getAllRoomTables() {
        return roomTableRepository.findAll();
    }

    public Optional<RoomTable> getRoomTableById(String id) {
        return roomTableRepository.findById(id);
    }

    public RoomTable createRoomTable(RoomTable roomTable) {
        return roomTableRepository.save(roomTable);
    }

    public RoomTable updateRoomTable(String id, RoomTable roomTable) {
        if (roomTableRepository.existsById(id)) {
            roomTable.setId(id);
            return roomTableRepository.save(roomTable);
        }
        return null;
    }

    public void deleteRoomTable(String id) {
        roomTableRepository.deleteById(id);
    }
}
