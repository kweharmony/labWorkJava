import java.util.Scanner;

public class Even {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int in = scanner.nextInt();
        boolean out = isEven(in);
        
        System.out.println(out);
        scanner.close();
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}