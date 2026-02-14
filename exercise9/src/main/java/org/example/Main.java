package org.example;
import java.util.*;

// Задание 9. Фильтрация строк

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scanner = new Scanner(System.in)) {
            List<String> inputList = readStrings(scanner);

            String substring = scanner.nextLine().trim();

            List<String> filteredList = filterStrings(inputList, substring);
            printResults(filteredList);
        }
    }

    public static void printResults(List<String> list) {
        if (!list.isEmpty()) {
            StringJoiner joiner = new StringJoiner(", ");
            for (String str : list) {
                joiner.add(str);
            }
            System.out.println(joiner.toString());
        }
    }

    public static List<String> readStrings(Scanner scanner) {
        //Проверка, что первое значение это целое число
        if (!scanner.hasNextInt()) {
            System.out.println("Input error");
            scanner.close();
            System.exit(1);
        }

        Integer count = scanner.nextInt();
        scanner.nextLine(); //Съесть перенос строки

        List<String> inputList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            inputList.add(scanner.nextLine().trim());
        }

        return inputList;
    }

    public static List<String> filterStrings(List<String> list, String substring) {
        List<String> result = new ArrayList<>();
        for(String str : list) {
            if (str.contains(substring)) {
                result.add(str);
            }
        }
        return result;
    }
}