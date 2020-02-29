package scrap.heap.refactor.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scrap.heap.refactor.exception.OrderAppException;

/**
 * The order class is used for holding the details of an order
 * and is also used as a controller for processing the order like for submit and cancel.
 * We can break out the controller into a separate class if we have a db and need to persist the order
 * and if the operations involved get to be more complicated.
 * Order Items are immutable. Once an order is created the items in the order cannot be modified.
 */
public class Order {

    public enum Status {COMPLETED, CANCELLED}

    ;

    private final List<OrderItem> orderItems;
    private Status status;

    private Order(List<OrderItem> orderItems) {
        this.orderItems = new ArrayList<>(orderItems);
        submit();
    }

    /**
     * This method can be enhanced to print a receipt with order id and price.
     */
    private void submit() {
        status = Status.COMPLETED;
        System.out.println("NEW ORDER DETAILS");
        for (OrderItem item : orderItems) {
            System.out.println(item.itemDetails());
        }
        System.out.println("END ORDER");
    }

    /**
     * Cancel the order
     */
    public void cancel() {
        status = Status.CANCELLED;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Making order items immutable
     * @return orderItems
     */
    public List<OrderItem> getOrderItems() {
        return new ArrayList<>(orderItems);
    }

    /**
     * Builder class for Order
     */
    public static class Builder {
        private List<OrderItem> orderItems;

        public Builder() {
            orderItems = new ArrayList<>();
        }

        public Builder addItems(OrderItem... items) {
            orderItems.addAll(Arrays.asList(items));
            return this;
        }

        public Order placeOrder() {
            if (orderItems.size() == 0) {
                throw new OrderAppException("At least one item needs to be added to order before submitting.");
            }
            Order order = new Order(orderItems);
            return order;
        }

    }
}
