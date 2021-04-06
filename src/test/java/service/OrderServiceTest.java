package service;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import persistence.OrderItemStorage;
import persistence.OrderStorage;

import java.util.Optional;
import java.util.UUID;

import static domain.OrderTest.anyOrder;
import static domain.OrderTest.validOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class OrderServiceTest {
    @Mock
    private OrderService orderService;

    @Mock
    private OrderStorage orderStorage;

    @Mock
    private OrderItemStorage orderItemStorage;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        when(orderStorage.add(any())).thenReturn(UUID.randomUUID().toString());
        orderService = new OrderService(orderStorage, orderItemStorage);
    }

    @Test
    void createOrderInvalid() {
        Order order = anyOrder();
        when(orderService.validateForCreation(order)).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> orderService.placeOrder(order));
        verify(orderStorage, never()).add(any());
    }

    @Test
    void createOrder_orderNameIsBusy() {
        String orderName = "busy_name";
        when(orderStorage.findOrderByUserID(orderName)).thenReturn(Optional.of(anyOrder()));

        Order order = validOrder(orderName);
        when(orderService.validateForCreation(order)).thenReturn(true);

        assertThrows(IllegalStateException.class, () -> orderService.placeOrder(order));
        verify(orderStorage, never()).add(any());
    }

    @Test
    void placeOrderTest() {
        final String userId = "Id";
        final String userName = "name";
        when(orderStorage.findOrderByUserID(userId)).thenReturn(Optional.empty());

        Order order = new Order(userId, userName);
        when(orderService.validateForCreation(order)).thenReturn(true);

        final String orderId = orderService.placeOrder(order);

        assertNotNull(orderId);
        verify(orderStorage).add(order);
        assertThat(order.getStatus(), is(OrderStatus.INITIAL));
    }

    @Test
    void loadAllByUserIdTest() {
        String userId = "userId";
        when(orderStorage.findOrderByUserID(userId)).thenReturn(Optional.empty());

        Order[] orders = orderService.loadAllByOrderId(userId);
        verify(orderStorage).load(userId);
    }

}