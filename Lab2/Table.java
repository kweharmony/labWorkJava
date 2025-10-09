class Table extends Furniture {
    
    private int numberOfLegs;
    private double surfaceArea;

    private static int tableCount = 0;

    public Table() {
        super(); 
        this.numberOfLegs = 4;
        this.surfaceArea = 1.0;
        tableCount++; 
    }

    public Table(String material, double price, String color, int numberOfLegs, double surfaceArea) {
        super(material, price, color); 
        this.numberOfLegs = numberOfLegs;
        this.surfaceArea = surfaceArea;
        tableCount++; 
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public static int getTableCount() {
        return tableCount;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        if (numberOfLegs > 0) {
            this.numberOfLegs = numberOfLegs;
        }
    }

    public void setSurfaceArea(double surfaceArea) {
        if (surfaceArea > 0) {
            this.surfaceArea = surfaceArea;
        }
    }
    @Override
    public void displayInfo() {
        System.out.println("Стол");
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price);
        System.out.println("Цвет: " + color);
        System.out.println("Количество ножек: " + numberOfLegs);
        System.out.println("Площадь поверхности: " + surfaceArea + " м2");
    }

    public void placeItems() {
        System.out.println("На стол можно положить предметы.");
    }
}