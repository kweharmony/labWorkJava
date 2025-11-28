import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {
    private final Queue<Product> products = new LinkedList<>();
    private int currentWeight = 0;
    private static final int MAX_WEIGHT = 150;
    private boolean finalShipmentSent = false;

    public Warehouse() {
        addProduct(40);
        addProduct(50);
        addProduct(60);
        addProduct(30);
        addProduct(20);
        addProduct(70);
        addProduct(80);
        addProduct(10);
        addProduct(90);
    }

    private void addProduct(int weight) {
        products.add(new Product(weight));
    }

    public synchronized Product getNextProduct() {
        return products.poll();
    }

    public synchronized void addItem(Product item) throws InterruptedException {
        if (currentWeight + item.getWeight() > MAX_WEIGHT && currentWeight > 0) {
            sendShipment();
        }

        currentWeight += item.getWeight();
        System.out.printf("[%s] Добавлен %s. Текущий вес: %d/%d кг%n",
                Thread.currentThread().getName(), item, currentWeight, MAX_WEIGHT);

        if (currentWeight >= MAX_WEIGHT) {
            sendShipment();
        }
    }

    public synchronized void sendShipment() throws InterruptedException {
        if (currentWeight == 0) return;

        System.out.printf("\n=== [%s] ОТПРАВКА ПАРТИИ ===\n", Thread.currentThread().getName());
        System.out.printf("Общий вес партии: %d кг\n", currentWeight);
        System.out.println("Грузчики идут разгружать товары...");
        Thread.sleep(2000);

        currentWeight = 0;
        System.out.println("Партия разгружена. Начинаем новую партию.\n");
    }

    public synchronized void sendRemainingShipment() throws InterruptedException {
        if (currentWeight > 0 && !finalShipmentSent) {
            finalShipmentSent = true;
            sendShipment();
        }
    }
}