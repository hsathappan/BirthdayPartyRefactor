package scrap.heap.refactor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import scrap.heap.refactor.exception.OrderAppException;
import scrap.heap.refactor.order.item.cake.Cake;
import scrap.heap.refactor.order.item.cake.CakeColor;
import scrap.heap.refactor.order.item.cake.Flavor;
import scrap.heap.refactor.order.item.cake.FrostingFlavor;
import scrap.heap.refactor.order.item.cake.Shape;
import scrap.heap.refactor.order.item.cake.Size;

public class CakeTest {

    @Test
    public void testSuccessfulCakeCreation() {
        Cake cake = new Cake.Builder().setFlavor(Flavor.CHOCOLATE).setFrostingFlavor(FrostingFlavor.CHOCOLATE)
                .setShape(Shape.CIRCLE).setSize(Size.LARGE).setCakeColor(CakeColor.BROWN).build();
        assertNotNull(cake);
        assertEquals(Flavor.CHOCOLATE, cake.getFlavor());
        assertEquals(FrostingFlavor.CHOCOLATE, cake.getFrostingFlavor());
        assertEquals(Shape.CIRCLE, cake.getShape());
        assertEquals(Size.LARGE, cake.getSize());
        assertEquals(CakeColor.BROWN, cake.getCakeColor());
    }

    @Test(expected = OrderAppException.class)
    public void testFailedCakeCreation() {
        Cake cake = new Cake.Builder().setFlavor(Flavor.CHOCOLATE).setFrostingFlavor(FrostingFlavor.CHOCOLATE).build();
    }

}
