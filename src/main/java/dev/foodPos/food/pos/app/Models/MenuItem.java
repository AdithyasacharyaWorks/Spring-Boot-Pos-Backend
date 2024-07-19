package dev.foodPos.food.pos.app.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "menu_items")
public class MenuItem {

    @Id
    private String id;
    private String menuItemName;
    private String menuDescription;
    private String imageUrl;
    private boolean isFeatured;
    private boolean isAvailable;
    private double price;
    private Date createdAt;
    private Date updatedAt;
    private String tags; // Changed from List<String> to String
    private String labels; // Changed from List<String> to String
    private String category; // Changed from Category to String

    // Constructors
    public MenuItem() {
    }

    public MenuItem(String menuItemName, String menuDescription, String imageUrl, boolean isFeatured, boolean isAvailable, double price, String tags, String labels, String category) {
        this.menuItemName = menuItemName;
        this.menuDescription = menuDescription;
        this.imageUrl = imageUrl;
        this.isFeatured = isFeatured;
        this.isAvailable = isAvailable;
        this.price = price;
        this.tags = tags;
        this.labels = labels;
        this.category = category;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
