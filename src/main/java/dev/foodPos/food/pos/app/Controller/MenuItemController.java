package dev.foodPos.food.pos.app.Controller;

import dev.foodPos.food.pos.app.Models.MenuItem;
import dev.foodPos.food.pos.app.Services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menuItems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        if (menuItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(menuItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMenuItemById(@PathVariable String id) {
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        if (menuItem == null) {
            return ResponseEntity.status(404).body("No data found for the provided ID.");
        }
        return ResponseEntity.ok(menuItem);
    }

    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem createdMenuItem = menuItemService.createMenuItem(menuItem);
        return ResponseEntity.status(201).body(createdMenuItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMenuItem(@PathVariable String id, @RequestBody MenuItem menuItemDetails) {
        MenuItem updatedMenuItem = menuItemService.updateMenuItem(id, menuItemDetails);
        if (updatedMenuItem == null) {
            return ResponseEntity.status(404).body("No data found for the provided ID.");
        }
        return ResponseEntity.ok(updatedMenuItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable String id) {
        boolean deleted = menuItemService.deleteMenuItem(id);
        if (deleted) {
            return ResponseEntity.ok("Data has been deleted successfully.");
        }
        return ResponseEntity.status(404).body("No data found for the provided ID.");
    }
}
