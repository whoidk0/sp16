import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Чтение файла
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Asus\\Downloads\\24_demo.txt"));

            int max = 1; // Максимальная длина последовательности
            int k = 1;   // Текущая длина последовательности

            // Читаем первый символ
            int firstChar = reader.read();
            if (firstChar == -1) {
                System.out.println(0); // Файл пустой
                return;
            }

            char c1 = (char) firstChar;
            char c2;

            // Обрабатываем остальные символы
            while ((firstChar = reader.read()) != -1) {
                c2 = (char) firstChar;

                if (c1 != c2) {
                    k++;
                    if (k > max) {
                        max = k;
                    }
                } else {
                    k = 1; // Сбрасываем счетчик, если символы одинаковые
                }

                c1 = c2; // Переходим к следующему символу
            }

            reader.close();
            System.out.println(max);

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}