package scrap.heap.refactor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import scrap.heap.refactor.exception.OrderAppException;
import scrap.heap.refactor.order.item.balloon.Balloon;
import scrap.heap.refactor.order.item.balloon.BalloonColor;
import scrap.heap.refactor.order.item.balloon.Material;

public class BalloonTest {

    @Test
    public void testSuccessfulBalloonCreation() {
        Balloon balloon = new Balloon.Builder().setQuantity(4).setMaterial(Material.MYLAR)
                .setBalloonColor(BalloonColor.RED)
                .build();
        assertNotNull(balloon);
        assertEquals(4, balloon.getQuantity());
        assertEquals(Material.MYLAR, balloon.getMaterial());
        assertEquals(BalloonColor.RED, balloon.getBalloonColor());
    }

    @Test(expected = OrderAppException.class)
    public void testBalloonWithNotAllAttributes() {
        Balloon failedBalloon = new Balloon.Builder().setBalloonColor(BalloonColor.RED).build();
    }

    @Test(expected = OrderAppException.class)
    public void testBalloonWithNegativeQuantity() {
        Balloon failedBalloon = new Balloon.Builder().setQuantity(-1).setMaterial(Material.MYLAR)
                .setBalloonColor(BalloonColor.RED)
                .build();
    }
}
