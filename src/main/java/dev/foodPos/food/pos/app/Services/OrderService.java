package dev.foodPos.food.pos.app.Services;

import dev.foodPos.food.pos.app.Models.Order;
import dev.foodPos.food.pos.app.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        order.setOrderDate(new Date());
        order.setUpdatedAt(new Date());
        return orderRepository.save(order);
    }

    public Order updateOrder(String id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setCustomerId(orderDetails.getCustomerId());
            order.setCustomerName(orderDetails.getCustomerName());
            order.setCustomerPhone(orderDetails.getCustomerPhone());
            order.setItems(orderDetails.getItems());
            order.setTotalAmount(orderDetails.getTotalAmount());
            order.setPaymentMethod(orderDetails.getPaymentMethod());
            order.setPaid(orderDetails.isPaid());
            order.setOrderStatus(orderDetails.getOrderStatus());
            order.setUpdatedAt(new Date());
            order.setTableNumber(orderDetails.getTableNumber());
            order.setRoomNumber(orderDetails.getRoomNumber());
            order.setNotes(orderDetails.getNotes());
            return orderRepository.save(order);
        }
        return null;
    }

    public boolean deleteOrder(String id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
            return true;
        }
        return false;
    }
}
