package scrap.heap.refactor;

import java.util.ArrayList;
import java.util.List;

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

/**
 * With the refactored App, you can manage your orders better.
 * You can add multiple cakes and balloons to a single order or add only cakes or balloons.
 * In future you can add more party items to the order.
 * You cannot add items to a completed or cancelled order.
 * Now you also maintain your list of orders and you can use this data for analytics, accounting, refund, cancel etc.
 * You can also enhance this to provide REST APIs and be a party ordering service.
 */
public class App {

    private final List<Order> orderList;

    public App() {
        orderList = new ArrayList<>();
    }

    public Order placeOrder(OrderItem... items) {
        Order order = new Order.Builder().addItems(items).placeOrder();
        orderList.add(order);
        return order;
    }

    public List<Order> getOrderList() {
        return new ArrayList<>(orderList);
    }

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {

        //Place birthday party orders
        App orderManager = new App();

        OrderItem balloon1 = new Balloon.Builder().setBalloonColor(BalloonColor.RED).setMaterial(Material.MYLAR)
                .setQuantity(4).build();
        OrderItem cake1 = new Cake.Builder().setFlavor(Flavor.CHOCOLATE).setFrostingFlavor(FrostingFlavor.CHOCOLATE)
                .setShape(Shape.CIRCLE).setSize(Size.LARGE).setCakeColor(CakeColor.BROWN).build();
        Order order1 = orderManager.placeOrder(balloon1, cake1);

        OrderItem balloon2 = new Balloon.Builder().setBalloonColor(BalloonColor.BLUE).setMaterial(Material.LATEX)
                .setQuantity(7).build();
        OrderItem cake2 = new Cake.Builder().setFlavor(Flavor.VANILLA).setFrostingFlavor(FrostingFlavor.CHOCOLATE)
                .setShape(Shape.SQUARE).setSize(Size.MEDIUM).setCakeColor(CakeColor.BROWN).build();
        Order order2 = orderManager.placeOrder(balloon2, cake2);

        OrderItem balloon3 = new Balloon.Builder().setBalloonColor(BalloonColor.YELLOW).setMaterial(Material.MYLAR)
                .setQuantity(4).build();
        OrderItem cake3 = new Cake.Builder().setFlavor(Flavor.VANILLA).setFrostingFlavor(FrostingFlavor.VANILLA)
                .setShape(Shape.SQUARE).setSize(Size.SMALL).setCakeColor(CakeColor.YELLOW).build();
        Order order3 = orderManager.placeOrder(balloon3, cake3);
    }
}
