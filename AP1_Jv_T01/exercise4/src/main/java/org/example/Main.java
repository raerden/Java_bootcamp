package org.example;
import java.util.Scanner;

// Задание 4. Поиск среднего арифметического отрицательных чисел

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = readInt(scanner);

        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = readInt(scanner);
            }

            int average = calcAverage(values);

            if (average < 0) {
                System.out.println(average);
            } else {
                System.out.println("There are no negative elements");
            }

        }
        scanner.close();
    }

    public static int calcAverage(int[] numbers) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                sum += numbers[i];
                cnt++;
            }
        }
        return sum < 0 ? sum / cnt : 0;
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