import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class WordFinderUnicode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        
        System.out.print("Введите первую букву слова: ");
        String inputLetter = scanner.nextLine();
        scanner.close();

        if (inputLetter == null || inputLetter.length() != 1) {
            System.err.println("Ошибка: введите ровно одну букву.");
            return;
        }

        char letter = inputLetter.charAt(0);
        if (!Character.isLetter(letter)) {
            System.err.println("Ошибка: символ должен быть буквой (латинской, кириллической и т.д.).");
            return;
        }

        String regex = "\\b" + Pattern.quote(String.valueOf(letter)) + "\\w*";

        try {
            Pattern pattern = Pattern.compile(
                regex,
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS
            );
            Matcher matcher = pattern.matcher(text);

            System.out.println("\nНайденные слова:");
            boolean found = false;
            while (matcher.find()) {
                System.out.println("- " + matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("Нет слов, начинающихся с буквы '" + letter + "'.");
            }

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (NullPointerException e) {
            System.err.println("Ошибка: входные данные не должны быть пустыми.");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}