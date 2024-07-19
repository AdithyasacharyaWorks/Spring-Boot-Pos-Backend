package dev.foodPos.food.pos.app.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String customerId; // Reference to the customer placing the order
    private String customerName;
    private String customerPhone;
    private List<OrderItem> items; // List of ordered items
    private double totalAmount; // Total order amount
    private String paymentMethod; // Payment method (e.g., credit card, cash)
    private boolean isPaid; // Payment status
    private String orderStatus; // Order status (e.g., pending, confirmed, served)
    private Date orderDate;
    private Date updatedAt;
    private String tableNumber; // Table number in a restaurant
    private String roomNumber; // Room number in a hotel
    private String notes; // Any additional notes for the order

    // Constructors
    public Order() {
    }

    public Order(String customerId, String customerName, String customerPhone, List<OrderItem> items, double totalAmount, String paymentMethod, boolean isPaid, String orderStatus, Date orderDate, String tableNumber, String roomNumber, String notes) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.items = items;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.isPaid = isPaid;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.updatedAt = new Date();
        this.tableNumber = tableNumber;
        this.roomNumber = roomNumber;
        this.notes = notes;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
