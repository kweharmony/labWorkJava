import java.io.*;

public class CopyFile2 {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";
        
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            System.out.println("Файл успешно скопирован!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден!");
            System.out.println("Проверьте путь: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла!");
            System.out.println("Детали: " + e.getMessage());
        }
    }
}