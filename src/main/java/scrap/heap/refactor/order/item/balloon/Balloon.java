package scrap.heap.refactor.order.item.balloon;

import scrap.heap.refactor.exception.OrderAppException;
import scrap.heap.refactor.order.OrderItem;

public class Balloon
        implements OrderItem {

    private final BalloonColor balloonColor;
    private final Material material;
    private final int quantity;

    private Balloon(BalloonColor balloonColor, Material material, int quantity) {
        this.balloonColor = balloonColor;
        this.material = material;
        this.quantity = quantity;
    }

    public BalloonColor getBalloonColor() {
        return balloonColor;
    }

    public Material getMaterial() {
        return material;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String itemDetails() {
        StringBuilder balloonDetails = new StringBuilder("Balloon:");
        balloonDetails.append("\n\tColor: " + getBalloonColor());
        balloonDetails.append("\n\tMaterial: " + getMaterial());
        balloonDetails.append("\n\tQuantity: " + getQuantity());
        balloonDetails.append("\n");
        return balloonDetails.toString();
    }

    public static class Builder {
        private BalloonColor balloonColor;
        private Material material;
        private int quantity;

        public Builder setBalloonColor(BalloonColor balloonColor) {
            this.balloonColor = balloonColor;
            return this;
        }

        public Builder setMaterial(Material material) {
            this.material = material;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Balloon build() {
            if (balloonColor == null || material == null || quantity <= 0) {
                throw new OrderAppException("Balloon order requires color, material and valid quantity");
            }
            return new Balloon(balloonColor, material, quantity);
        }
    }
}
