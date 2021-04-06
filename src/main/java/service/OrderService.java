package service;

import domain.Order;
import domain.OrderStatus;
import persistence.OrderItemStorage;
import persistence.OrderStorage;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkState;

public class OrderService {
    private final OrderStorage orderStorage;
    private final OrderItemStorage orderItemStorage;

    public OrderService(OrderStorage orderStorage, OrderItemStorage orderItemStorage) {
        this.orderStorage = orderStorage;
        this.orderItemStorage = orderItemStorage;
    }

    public String placeOrder(Order order) {
        if (!validateForCreation(order)) {
            throw new IllegalArgumentException("Order is not valid " + order);
        }

        Optional<Order> byUsername = orderStorage.findOrderByUserID(order.getUserName());
        checkState(byUsername.isEmpty(), "username is busy");

        order.setStatus(OrderStatus.INITIAL);

         return orderStorage.add(order);

    }

    public boolean validateForCreation(Order order) {
        if (order.getUserName() == null) {
            return false;
        }

        if (order.getPersonalData().getAddress() == null) {
            return false;
        }

        if (order.getPersonalData().getBirthday() == null) {
            return false;
        }

        if (order.getPersonalData().getName() == null) {
            return false;
        }

        if (order.getPersonalData().getSurname() == null) {
            return false;
        }

        return order.getId() != null;
    }

    public Order[] loadAllByOrderId(String userId) {
        Optional<Order> byUserId = orderStorage.findOrderByUserID(userId);
        checkState(byUserId.isEmpty(), "order not found");
        return orderStorage.load(userId);
    }
}
