package org.example;
import java.util.Locale;
import java.util.Scanner;

// Задание 8. Упорядоченная последовательность по возрастанию

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner consoleScanner = new Scanner(System.in);
        //Проверка, что первое значение это целое число
        if (!consoleScanner.hasNextInt()) {
            System.out.println("Input error");
            consoleScanner.close();
            return;
        }

        // считываем первое число
        int prev = consoleScanner.nextInt();
        int count = 0; //отсчет от 0 как в массиве
        boolean isOrdered = true; //Предполагаю сортировку
        int notOrderedIndex = -1;

        while (consoleScanner.hasNextInt()) {
            int current = consoleScanner.nextInt();
            count++;
            if (current <= prev) {
                isOrdered = false;
                notOrderedIndex = count;
                break;
            }
            prev = current;
        }

        consoleScanner.close();

        // Вывод результатов
        if (isOrdered) {
            System.out.println("The sequence is ordered in ascending order");
        } else {
            System.out.println("The sequence is not ordered from the ordinal number of the number " + notOrderedIndex);
        }
    }
}