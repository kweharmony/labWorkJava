import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price is $19.99";

        try {
            if (text == null || text.isEmpty()) {
                System.err.println("Текст не может быть пустым.");
                return;
        }

            String regex = "[-+]?\\d+(?:[.,]\\d+)?";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            System.out.println("Найденные числа:");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка синтаксиса регулярного выражения: " + e.getDescription());
        } catch (NullPointerException e) {
            System.err.println("Текст не может быть пустым: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
        }
    }
}