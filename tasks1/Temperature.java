import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println(toFahrenheit(number));

        scanner.close();
    }
    public static int toFahrenheit (int celsius) {
            return (int) (celsius * 9.0 / 5 + 32); 
    }
}