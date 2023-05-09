import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Задаём имя и путь к файлу
        String separator = File.separator;
        String fileName = "D:" + separator + "SomeFile" + separator + "Hello.txt";
        System.out.println(fileName);
        // Создаем LinkedHashMap для хранения символов и их количества
        Map<Character, Integer> charCount = new HashMap<>();

        try {
            // Создаем объект Scanner для чтения файла
            Scanner scanner = new Scanner(new File(fileName));

            // Читаем файл посимвольно
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                for (int i = 0; i <line.length(); i++) {
                    // Получаем символ из строки
                    char c = Character.toLowerCase(line.charAt(i));
                    // Увеличиваем счетчик символа в LinkedHashMap
                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                }
            }

            // Проходим циклом for-each по LinkedHashMap
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                System.out.print(key);
            }

            System.out.println("");

            // Сортируем LinkedHashMap по значениям в порядке убывания и выводим результат
            charCount.entrySet().stream()
                    .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEachOrdered(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        }
    }
}