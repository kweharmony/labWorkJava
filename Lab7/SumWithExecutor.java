import java.util.concurrent.*;

public class SumWithExecutor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 2;
        int chunkSize = array.length / numThreads;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? array.length : (start + chunkSize);

            completionService.submit(() -> {
                int localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += array[j];
                }
                return localSum;
            });
        }

        int total = 0;
        for (int i = 0; i < numThreads; i++) {
            total += completionService.take().get();
        }

        executor.shutdown();
        System.out.println("Сумма всего массива: " + total);
    }
}
