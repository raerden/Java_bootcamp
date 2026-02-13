package org.example;
import java.util.Locale;
import java.util.Scanner;

// Задание 6. Сортировка массива выбором

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int n = readInt(scanner);

        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            double[] values = new double[n];
            for (int i = 0; i < n; i++) {
                values[i] = readDouble(scanner);
            }

            arraySortSelect(values);

            for (int i = 0; i < values.length; i++) {
                System.out.printf("%.1f ", values[i]);
            }
        }
        scanner.close();
    }

    public static void arraySortSelect(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin])
                    indexMin = j;
            }
            if (indexMin != i)
                arraySwapElem(arr, i, indexMin);
        }
    }
    public static void arraySwapElem(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

    public static double readDouble(Scanner scanner) {
        double res = 0;
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextDouble()) {
                res = scanner.nextDouble();
                validInput = true;
            } else { // Некорректный ввод
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return res;
    }
}