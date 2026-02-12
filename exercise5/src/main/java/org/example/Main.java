package org.example;
import java.util.Scanner;

// Задание 5. Поиск чисел, у которых совпадает первая и последняя цифра

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = readInt(scanner);

        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            int[] values = new int[n];
            int[] result = new int[n];
            int i = 0;
            int cnt = 0;
            while (i < n) {
                values[i] = readInt(scanner);
                if (sameFirstEndDigit(values[i])) {
                    result[cnt] = values[i];
                    cnt++;
                }
                i++;
            }

            if (cnt > 0) {
                for (int j = 0; j < cnt; j++) {
                    System.out.printf("%d ", result[j]);
                }
            } else {
                System.out.println("There are no such elements");
            }

        }
        scanner.close();
    }

    public static boolean sameFirstEndDigit(int number) {
        number = Math.abs(number);
        int lastDigit = number % 10;
        int firstDigit = number;
        while (firstDigit >= 10) {
            firstDigit = firstDigit / 10;
        }
        return firstDigit == lastDigit;
    }

    public static int readInt(Scanner scanner) {
        int res = 0;
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                res = scanner.nextInt();
                validInput = true;
            } else { // Некорректный ввод
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return res;
    }
}