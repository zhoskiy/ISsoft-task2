package domain;

import domain.data.PersonalData;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private final String  id;
    private final String userName;
    private OrderStatus status;
    private PersonalData personalData;
    private ArrayList<OrderItem> orderItems;
    private Date orderDate;

    public Order(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Order(String id, String userName, PersonalData personalData, ArrayList<OrderItem> orderItems, Date orderDate) {
        this.id = id;
        this.userName = userName;
        this.personalData = personalData;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
