package scrap.heap.refactor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import scrap.heap.refactor.exception.OrderAppException;
import scrap.heap.refactor.order.Order;
import scrap.heap.refactor.order.OrderItem;
import scrap.heap.refactor.order.item.balloon.Balloon;
import scrap.heap.refactor.order.item.balloon.BalloonColor;
import scrap.heap.refactor.order.item.balloon.Material;
import scrap.heap.refactor.order.item.cake.Cake;
import scrap.heap.refactor.order.item.cake.CakeColor;
import scrap.heap.refactor.order.item.cake.Flavor;
import scrap.heap.refactor.order.item.cake.FrostingFlavor;
import scrap.heap.refactor.order.item.cake.Shape;
import scrap.heap.refactor.order.item.cake.Size;

public class OrderTest {

    private Balloon balloon;
    private Cake cake;

    @Before
    public void before() {
        balloon = new Balloon.Builder().setBalloonColor(BalloonColor.RED).setMaterial(Material.MYLAR)
                .setQuantity(4).build();
        cake = new Cake.Builder().setFlavor(Flavor.CHOCOLATE).setFrostingFlavor(FrostingFlavor.CHOCOLATE)
                .setShape(Shape.CIRCLE).setSize(Size.LARGE).setCakeColor(CakeColor.BROWN).build();
    }

    @Test
    public void testOrderWithOneItem() {
        Order order = new Order.Builder().addItems(balloon).placeOrder();
        assertNotNull(order);
        assertEquals(Order.Status.COMPLETED, order.getStatus());
        assertEquals(1, order.getOrderItems().size());
    }

    @Test
    public void testOrderWithMultipleItems() {
        Order order = new Order.Builder().addItems(balloon, cake).placeOrder();
        assertNotNull(order);
        assertEquals(Order.Status.COMPLETED, order.getStatus());
        assertEquals(2, order.getOrderItems().size());
    }

    @Test(expected = OrderAppException.class)
    public void testOrderWithNoItems() {
        Order order = new Order.Builder().placeOrder();
    }

    @Test
    public void testCancelledOrder() {
        Order order = new Order.Builder().addItems(balloon).placeOrder();
        assertNotNull(order);
        order.cancel();
        assertEquals(Order.Status.CANCELLED, order.getStatus());
    }

    @Test
    public void testOrderItemsImmutable() {
        Order order = new Order.Builder().addItems(balloon).placeOrder();
        assertNotNull(order);
        assertEquals(Order.Status.COMPLETED, order.getStatus());
        List<OrderItem> orderItems = order.getOrderItems();
        assertEquals(1, order.getOrderItems().size());
        orderItems.add(cake);
        assertEquals(1, order.getOrderItems().size());
    }
}
