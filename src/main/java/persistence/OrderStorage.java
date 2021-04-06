package persistence;

import domain.Order;

import java.util.Optional;

public class OrderStorage {

    public Optional<Order> findOrderByUserID(String userId) {
        return Optional.empty();
    }

    public String add(Order order) {
        throw new UnsupportedOperationException("not implemented");
    }

    public Order[] load(String Id) {
        throw new UnsupportedOperationException("not implemented");
    }
}
