package dev.foodPos.food.pos.app.Services;

import dev.foodPos.food.pos.app.Models.MenuItem;
import dev.foodPos.food.pos.app.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem getMenuItemById(String id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    public MenuItem createMenuItem(MenuItem menuItem) {
        menuItem.setCreatedAt(new Date());
        menuItem.setUpdatedAt(new Date());
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(String id, MenuItem menuItemDetails) {
        MenuItem menuItem = menuItemRepository.findById(id).orElse(null);
        if (menuItem != null) {
            menuItem.setMenuItemName(menuItemDetails.getMenuItemName());
            menuItem.setMenuDescription(menuItemDetails.getMenuDescription());
            menuItem.setImageUrl(menuItemDetails.getImageUrl());
            menuItem.setPrice(menuItemDetails.getPrice());
            menuItem.setTags(menuItemDetails.getTags());
            menuItem.setLabels(menuItemDetails.getLabels());
            menuItem.setCategory(menuItemDetails.getCategory());
            menuItem.setFeatured(menuItemDetails.isFeatured());
            menuItem.setAvailable(menuItemDetails.isAvailable());
            menuItem.setUpdatedAt(new Date());
            return menuItemRepository.save(menuItem);
        }
        return null;
    }

    public boolean deleteMenuItem(String id) {
        MenuItem menuItem = menuItemRepository.findById(id).orElse(null);
        if (menuItem != null) {
            menuItemRepository.delete(menuItem);
            return true;
        }
        return false;
    }
}
