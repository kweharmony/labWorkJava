import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int in = scanner.nextInt();
        String out = checkAge(in);
        
        System.out.println(out);
        scanner.close();
    }
    public static String checkAge(int age) {
        if (age >= 18) {
            return "совершеннолетний";
        } else {
            return "несовершеннолетний";
        }
    }
}
