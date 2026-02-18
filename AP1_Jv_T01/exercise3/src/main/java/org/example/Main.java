package org.example;
import java.util.Scanner;

// Задание 3. Поиск числа Фибоначчи

public class Main {
    public static void main(String[] args) {
        int n = readInt();
        long fib = calcFibonacci(n);
        printFibonacci(fib);
    }

    public static void printFibonacci(long fib) {
        if (fib >= 0) {
            System.out.println(fib);
        } else if (fib == -1) {
            System.out.println("Negative n is not allowed");
        } else if (fib == -2) {
            System.out.println("Too large n");
        } else if (fib == -3) {
            System.out.println("Too large n (stack overflow)");
        }
    }

    public static long calcFibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        // Защита от долгих вычислений.
        // На моем компьютере для 50ти считает 35 секунд.
        if (n > 50) {
            return -2;
        }

        if (n <= 1) {
            return n;
        }

        try {
            return fibonacci(n);
        } catch (StackOverflowError e) {
            return -3;
        }
    }

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int readInt() {
        int res = 0;
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
        return res;
    }
}