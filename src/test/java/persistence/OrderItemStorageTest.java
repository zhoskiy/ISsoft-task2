package persistence;

import domain.OrderItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OrderItemStorageTest {

    @Test
    void findOrderItemByNameAndAddTest() {
        OrderItemStorage orderItemStorage = new OrderItemStorage();
        ArrayList<OrderItem> orderItems = getAnyOrderItems();

        final String name = orderItemStorage.add(orderItems);

        assertThat(name, is(not(null)));
        final ArrayList<OrderItem> findItems = orderItemStorage.findOrderItemByName(name);
        assertThat(findItems, is(equalTo(orderItems)));
    }

    private ArrayList<OrderItem> getAnyOrderItems(){
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("item1", (int) (Math.random() * 100), (int) (Math.random() * 100)));
        orderItems.add(new OrderItem("item2", (int) (Math.random() * 100), (int) (Math.random() * 100)));
        return orderItems;
    }
}