import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int in = scanner.nextInt();
        int out = digitSum(in);
        
        System.out.println(out);
        scanner.close();
    }

    public static int digitSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}