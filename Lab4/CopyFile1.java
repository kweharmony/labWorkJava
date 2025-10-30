import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile1 {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";
        
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            System.out.println("Файл успешно скопирован!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден!");
            System.out.println("Проверьте путь: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
                System.out.println("Файлы закрыты.");
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файлов: " + e.getMessage());
            }
        }
    }
}

