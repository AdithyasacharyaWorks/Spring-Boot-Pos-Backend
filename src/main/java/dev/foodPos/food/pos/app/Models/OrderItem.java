package dev.foodPos.food.pos.app.Models;

public class OrderItem {
    private String menuItemId; // Reference to the menu item
    private String name; // Name of the menu item
    private int quantity; // Quantity ordered
    private double price; // Price per item
    private double total; // Total price for this item (price * quantity)

    // Constructors
    public OrderItem() {
    }

    public OrderItem(String menuItemId, String name, int quantity, double price) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = price * quantity;
    }

    // Getters and Setters
    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.total = this.price * quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.total = this.price * this.quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
