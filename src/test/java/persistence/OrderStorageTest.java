package persistence;

import domain.Order;
import org.junit.jupiter.api.Test;

import static domain.OrderTest.anyValidOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OrderStorageTest {

    @Test
    void addAndLoadTest() {
        OrderStorage orderStorage = new OrderStorage();
        Order order = anyValidOrder();
        final String id = orderStorage.add(order);

        assertThat(id, is(not(null)));
        final Order[] loaded = orderStorage.load(id);
        assertThat(loaded, is(equalTo(order)));
    }

}