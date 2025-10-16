import java.util.Scanner;

public class Month {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int in = scanner.nextInt();
        String out = season(in);
        
        System.out.println(out);
        scanner.close();
    }

    public static String season(int month) {
        if (month == 12 || month <= 2) {
            return "зима";
        } if (month >= 3 & month <= 5) {
            return "весна";
        } if (month >= 6 & month <= 8) {
            return "лето";
        } else {
            return "осень";
        }
    }
}
