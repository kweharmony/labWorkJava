import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Warehouse warehouse = new Warehouse();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.submit(new LoaderRealization(warehouse));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.println("\n=== ВСЕ ТОВАРЫ ОТПРАВЛЕНЫ ===");
    }
}