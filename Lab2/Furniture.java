abstract class Furniture {

    protected String material;
    protected double price;
    protected String color;

    public Furniture() {
        this.material = "не указано";
        this.price = 0.0;
        this.color = "не указано";
    }

    public Furniture(String material, double price, String color) {
        this.material = material;
        this.price = price;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }
    
    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void displayInfo();


    public void use() {
        System.out.println("Используется мебель.");
    }
}