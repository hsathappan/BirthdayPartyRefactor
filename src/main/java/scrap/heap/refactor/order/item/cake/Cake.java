package scrap.heap.refactor.order.item.cake;

import scrap.heap.refactor.exception.OrderAppException;
import scrap.heap.refactor.order.OrderItem;

public class Cake
        implements OrderItem {

    private final CakeColor cakeColor;
    private final Flavor flavor;
    private final FrostingFlavor frostingFlavor;
    private final Size size;
    private final Shape shape;

    private Cake(Flavor flavor, FrostingFlavor frostingFlavor, Shape shape, Size size, CakeColor cakeColor) {
        this.flavor = flavor;
        this.frostingFlavor = frostingFlavor;
        this.shape = shape;
        this.size = size;
        this.cakeColor = cakeColor;
    }

    public CakeColor getCakeColor() {
        return cakeColor;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public FrostingFlavor getFrostingFlavor() {
        return frostingFlavor;
    }

    public Size getSize() {
        return size;
    }

    public Shape getShape() {
        return shape;
    }

    @Override
    public String itemDetails() {
        StringBuilder cakeDetails = new StringBuilder("Cake:");
        cakeDetails.append("\n\tFlavor: " + getFlavor());
        cakeDetails.append("\n\tFrosting Flavor: " + getFrostingFlavor());
        cakeDetails.append("\n\tShape: " + getShape());
        cakeDetails.append("\n\tSize: " + getSize());
        cakeDetails.append("\n\tColor: " + getCakeColor());
        cakeDetails.append("\n");
        return cakeDetails.toString();
    }

    public static class Builder {

        private CakeColor cakeColor;
        private Flavor flavor;
        private FrostingFlavor frostingFlavor;
        private Size size;
        private Shape shape;

        public Builder setCakeColor(CakeColor cakeColor) {
            this.cakeColor = cakeColor;
            return this;
        }

        public Builder setFlavor(Flavor flavor) {
            this.flavor = flavor;
            return this;
        }

        public Builder setFrostingFlavor(FrostingFlavor frostingFlavor) {
            this.frostingFlavor = frostingFlavor;
            return this;
        }

        public Builder setSize(Size size) {
            this.size = size;
            return this;
        }

        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        public Cake build() {
            if (flavor == null || frostingFlavor == null || shape == null || size == null || cakeColor == null) {
                throw new OrderAppException("Cake order requires flavor, frostingFlavor, shape, size and cakeColor");
            }
            return new Cake(flavor, frostingFlavor, shape, size, cakeColor);
        }
    }
}
