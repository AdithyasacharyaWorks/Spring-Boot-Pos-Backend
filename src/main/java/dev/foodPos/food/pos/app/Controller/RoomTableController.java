package dev.foodPos.food.pos.app.Controller;

import dev.foodPos.food.pos.app.Models.RoomTable;
import dev.foodPos.food.pos.app.Services.RoomTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/room-tables")
public class RoomTableController {

    @Autowired
    private RoomTableService roomTableService;

    @GetMapping
    public ResponseEntity<Object> getAllRoomTables() {
        List<RoomTable> roomTables = roomTableService.getAllRoomTables();
        if (roomTables.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No data available for Room Tables");
        }
        return ResponseEntity.ok(roomTables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoomTableById(@PathVariable String id) {
        Optional<RoomTable> roomTable = roomTableService.getRoomTableById(id);
        if (roomTable.isPresent()) {
            return ResponseEntity.ok(roomTable.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room Table with ID " + id + " not found");
        }
    }

    @PostMapping
    public ResponseEntity<Object> createRoomTable(@RequestBody RoomTable roomTable) {
        if (roomTable == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid Room Table data provided");
        }

        RoomTable createdRoomTable = roomTableService.createRoomTable(roomTable);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoomTable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRoomTable(@PathVariable String id, @RequestBody RoomTable roomTable) {
        if (roomTable == null || !roomTableService.getRoomTableById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid Room Table data or Room Table with ID " + id + " does not exist");
        }

        RoomTable updatedRoomTable = roomTableService.updateRoomTable(id, roomTable);
        if (updatedRoomTable != null) {
            return ResponseEntity.ok(updatedRoomTable);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room Table with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoomTable(@PathVariable String id) {
        Optional<RoomTable> roomTable = roomTableService.getRoomTableById(id);
        if (roomTable.isPresent()) {
            roomTableService.deleteRoomTable(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Room Table with ID " + id + " successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room Table with ID " + id + " not found");
        }
    }
}
