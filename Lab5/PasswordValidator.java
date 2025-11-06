import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Matcher;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        scanner.close();

        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9]{8,16}$";

        try {
            if (password == null || password.isEmpty()) {
                System.err.println("Пароль не может быть пустым.");
                return;
        }
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль корректный!");
            } else {
                System.out.println("Пароль не соответствует требованиям. Условия:");
                System.out.println("- Длина: от 8 до 16 символов");
                System.out.println("- Только латинские буквы и цифры");
                System.out.println("- Минимум 1 заглавная буква");
                System.out.println("- Минимум 1 цифра");
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (NullPointerException e) {
            System.err.println("Пароль не может быть пустым");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}