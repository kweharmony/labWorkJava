public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 0;
        
        try {
            if (arr.length == 0) {
                throw new IllegalArgumentException("Массив не может быть пустым!");
            }
            
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            
            double average = (double) sum / arr.length;
            System.out.println("Массив: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println("\nСреднее арифметическое: " + average);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Выход за границы массива!");
            System.out.println("Детали: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }
}