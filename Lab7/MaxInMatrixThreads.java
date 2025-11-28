public class MaxInMatrixThreads {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
            {1, 2, 3},
            {4, 9, 6},
            {7, 8, 5}
        };
        
        int rows = matrix.length;
        int[] rowMaxValues = new int[rows];
        Thread[] threads = new Thread[rows];
        
        for (int i = 0; i < rows; i++) {
            final int rowIndex = i;
            threads[i] = new Thread(() -> {
                int max = matrix[rowIndex][0];
                for (int num : matrix[rowIndex]) {
                    if (num > max) max = num;
                }
                rowMaxValues[rowIndex] = max;
            });
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        int globalMax = rowMaxValues[0];
        for (int value : rowMaxValues) {
            if (value > globalMax) globalMax = value;
        }
        
        System.out.println("Максимальный элемент в матрице: " + globalMax);
    }
}