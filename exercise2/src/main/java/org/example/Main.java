package org.example;
import java.util.Scanner;

// Задание 2. Нахождение часов, минут и секунд

public class Main {
    public static void main(String[] args) {
        int totalSeconds = readSeconds();
        if (totalSeconds >= 0) {
            int[] time = new int[3];
            //Возврат нескольких значений из метода через массив
            calculateTime(totalSeconds, time);
            int hours = time[0];
            int minutes = time[1];
            int seconds = time[2];
            printTime(hours, minutes, seconds);
        } else {
            System.out.println("Incorrect time");
        }
    }

    public static int readSeconds() {
        int seconds = 0;
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                seconds = scanner.nextInt();
                validInput = true;
            } else { // Некорректный ввод
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        scanner.close();
        return seconds;
    }

    public static void calculateTime(int totalSeconds, int[] result) {
        result[0] = totalSeconds / 3600;
        result[1] = (totalSeconds % 3600) / 60;
        result[2] = totalSeconds % 60;
    }

    public static void printTime(int hours, int minutes, int seconds) {
        System.out.printf("%02d:%02d:%02d%n", hours, minutes,seconds);
    }

}