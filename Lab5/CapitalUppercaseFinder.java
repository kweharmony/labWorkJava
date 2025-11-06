import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class CapitalUppercaseFinder {
    public static void main(String[] args) {
        String text = "HelloWorld!";

        String regex = "[a-z][A-Z]";

        try {
            if (text == null || text.isEmpty()) {
                System.err.println("Текст не может быть пустым.");
                return;
        }
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            String result = matcher.replaceAll("!$0!");

            System.out.println("Исходный текст:");
            System.out.println(text);
            System.out.println("\nРезультат обработки:");
            System.out.println(result);

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (NullPointerException e) {
            System.err.println("Ошибка: текст не может быть пустым: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}