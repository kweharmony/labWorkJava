class Bed extends Furniture {
    
    private String size;
    private boolean hasStorage;


    public Bed() {
        super();
        this.size = "Односпальная";
        this.hasStorage = false;
    }

    public Bed(String material, double price, String color, String size, boolean hasStorage) {
        super(material, price, color);
        this.size = size;
        this.hasStorage = hasStorage;
    }

    public String getSize() {
        return size;
    }

    public boolean isHasStorage() {
        return hasStorage;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setHasStorage(boolean hasStorage) {
        this.hasStorage = hasStorage;
    }


    @Override
    public void displayInfo() {
        System.out.println("Кровать");
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price);
        System.out.println("Цвет: " + color);
        System.out.println("Размер: " + size);
        System.out.println("Есть место для хранения: " + (hasStorage ? "Да" : "Нет"));
    }

    public void sleep() {
        System.out.println("Можно спать на кровати.");
    }
}