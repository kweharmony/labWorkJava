import java.util.Scanner;

public class Days {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int in = scanner.nextInt();
        String out = daysToWeeks(in);
        
        System.out.println(out);
        scanner.close();
    }

    public static String daysToWeeks(int days) {
        int weeks = days / 7;
        int otherDays = days % 7;

        String weekWord;
        if (weeks == 1) {
            weekWord = "неделя";
        } else {
            weekWord = "недель";
        }

        String dayWord;
        if (otherDays == 1) {
            dayWord = "день";
        } else if (otherDays >= 2 && otherDays <= 4) {
            dayWord = "дня";
        } else {
            dayWord = "дней";
        }

        return weeks + " " + weekWord + " и " + otherDays + " " + dayWord;
    }
}
