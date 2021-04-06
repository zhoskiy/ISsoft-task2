package domain;

import domain.data.PersonalData;

import java.util.ArrayList;
import java.util.Date;

public class OrderTest {
    public static Order anyValidOrder() {
        return validOrder("id1");
    }

    public static Order validOrder(String id) {
        PersonalData data = new PersonalData(new Date(), "name1", "surname2", "address1");
        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("item1", (int) (Math.random() * 100), (int) (Math.random() * 100)));
        orderItems.add(new OrderItem("item2", (int) (Math.random() * 100), (int) (Math.random() * 100)));
        return new Order(id, "name1", data, orderItems, new Date());
    }

    public static Order anyOrder() {
        return anyValidOrder();
    }

}