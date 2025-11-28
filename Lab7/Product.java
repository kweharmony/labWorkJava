public class Product {
    private final int weight;

    public Product(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Товар(" + weight + "кг)";
    }
}