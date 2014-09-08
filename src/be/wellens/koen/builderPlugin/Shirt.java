package be.wellens.koen.builderPlugin;

public class Shirt {

    private String brand, size, color;

    private Shirt() {
    }

    public static Builder newShirt() {
        return new Builder();
    }

    public static class Builder {

        private Shirt shirt = new Shirt();

        public Shirt build() {
            return this.shirt;
        }

        public Builder withBrand(String brand) {
            shirt.brand = brand;
            return this;
        }

        public Builder withSize(String size) {
            shirt.size = size;
            return this;
        }

        public Builder withColor(String color) {
            shirt.color = color;
            return this;
        }
    }

    public static void main(String[] args) {
        Shirt shirt = newShirt()
                        .withSize("L")
                        .withColor("blue")
                        .build();
    }
}
