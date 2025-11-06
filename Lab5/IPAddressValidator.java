import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IPAddressValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите IP-адрес для проверки: ");
        String ip = scanner.nextLine();
        scanner.close();

        String regex = "^(" +
            "(25[0-5]|" +        
            "2[0-4][0-9]|" +     
            "1[0-9]{2}|" +       
            "[1-9][0-9]|" +      
            "[0-9])" +           
            "\\.){3}" +          
            "(25[0-5]|" +
            "2[0-4][0-9]|" +
            "1[0-9]{2}|" +
            "[1-9][0-9]|" +
            "[0-9])$";          

        try {
            if (ip == null) {
                throw new NullPointerException("IP-адрес не может быть null");
            }

            Pattern pattern = Pattern.compile(regex);
            if (pattern.matcher(ip).matches()) {
                System.out.println("IP-адрес корректный!");
            } else {
                System.out.println("IP-адрес НЕ корректный.");
                System.out.println("Требования:");
                System.out.println("- Формат: XXX.XXX.XXX.XXX");
                System.out.println("- Каждое число: от 0 до 255");
                System.out.println("- Нельзя начинать с нуля (кроме самого 0)");
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (NullPointerException e) {
            System.err.println("Ошибка: IP-адрес равен null");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}
