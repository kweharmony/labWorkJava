class Chair extends Furniture {
    
    private boolean hasBackrest;
    private double seatHeight;

    public Chair() {
        super();
        this.hasBackrest = true;
        this.seatHeight = 0.45;
    }

    public Chair(String material, double price, String color, boolean hasBackrest, double seatHeight) {
        super(material, price, color);
        this.hasBackrest = hasBackrest;
        this.seatHeight = seatHeight;
    }

    public boolean isHasBackrest() {
        return hasBackrest;
    }

    public double getSeatHeight() {
        return seatHeight;
    }

    public void setHasBackrest(boolean hasBackrest) {
        this.hasBackrest = hasBackrest;
    }

    public void setSeatHeight(double seatHeight) {
        if (seatHeight > 0) {
            this.seatHeight = seatHeight;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Стул");
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price);
        System.out.println("Цвет: " + color);
        System.out.println("Есть спинка: " + (hasBackrest ? "Да" : "Нет"));
        System.out.println("Высота сиденья: " + seatHeight + " м");
    }

    public void sit() {
        System.out.println("Можно сесть на стул.");
    }
}
