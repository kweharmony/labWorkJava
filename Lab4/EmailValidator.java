import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class EmailFormatException extends Exception {
    public EmailFormatException(String message) {
        super(message);
    }
}

class ExceptionLogger {
    private static final String LOG_FILE = "exceptions.log";
    
    public static void logException(Exception e) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
            String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            ;
            pw.println("Время: " + timestamp);
            pw.println("Тип исключения: " + e.getClass().getName());
            pw.println("Сообщение: " + e.getMessage());
            pw.println();
            
            System.out.println("Исключение записано в файл " + LOG_FILE);
            
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в лог-файл: " + ex.getMessage());
        }
    }
}

public class EmailValidator {
    
    public static void validateEmail(String email) throws EmailFormatException {
        if (email == null || email.isEmpty()) {
            throw new EmailFormatException("Email не может быть пустым!");
        }
        
        if (!email.contains("@")) {
            throw new EmailFormatException("Email должен содержать символ @");
        }
        
        if (!email.contains(".")) {
            throw new EmailFormatException("Email должен содержать точку");
        }
        
        int atIndex = email.indexOf("@");
        int dotIndex = email.lastIndexOf(".");
        
        if (atIndex > dotIndex) {
            throw new EmailFormatException("Неверный формат: @ должна быть перед точкой");
        }
        
        if (atIndex == 0) {
            throw new EmailFormatException("Email не может начинаться с @");
        }
        
        if (dotIndex == email.length() - 1) {
            throw new EmailFormatException("Email не может заканчиваться точкой");
        }
        
        System.out.println("Email корректен: " + email);
    }
    
    public static void main(String[] args) {
        String[] emails = {
            "user@example.com",      
            "invalid.email",         
            "@example.com",          
            "user@domain",           
            "user.domain@",          
            ""                       
        };
            
        for (String email : emails) {
            try {
                System.out.println("Проверяем: " + (email.isEmpty() ? "[пустая строка]" : email));
                validateEmail(email);
            } catch (EmailFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
                ExceptionLogger.logException(e);
            }
            System.out.println();
        }
    }
}
