import java.util.*;

public class SalesTracker {
    private Map<String, Integer> salesMap;

    public SalesTracker() {
        salesMap = new HashMap<>();
    }

    public void addSale(String product, int quantity) {
        salesMap.put(product, salesMap.getOrDefault(product, 0) + quantity);
        System.out.printf("Добавлена продажа: %s (%d шт.)\n", product, quantity);
    }

    public void printSalesReport() {
        System.out.println("---------------------");
        if (salesMap.isEmpty()) {
            System.out.println("Нет данных о продажах");
            return;
        }
        
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            System.out.printf("%s (%d шт.)\n", entry.getKey(), entry.getValue());
        }
        System.out.println("---------------------");
    }

    public int getTotalSalesCount() {
        int total = 0;
        for (int count : salesMap.values()) {
            total += count;
        }
        return total;
    }

    public String getMostPopularProduct() {
        if (salesMap.isEmpty()) {
            return "Нет данных";
        }
        
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        
        tracker.addSale("Телефон", 3);
        tracker.addSale("Ноутбук", 2);
        tracker.addSale("Планшет", 5);
        tracker.addSale("Телефон", 2);
        tracker.addSale("Наушники", 7);
        
        tracker.printSalesReport();
        
        System.out.printf("Общее количество проданных товаров: %d\n", tracker.getTotalSalesCount());
        System.out.printf("Самый популярный товар: %s\n", tracker.getMostPopularProduct());
    }
}
