package org.example;
import java.util.Locale;
import java.util.Scanner;

// Задание 1. Нахождение периметра треугольника
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        double[] coords = new double[6]; // x1, y1, x2, y2, x3, y3

        for (int i = 0; i < 6; i++) {
            boolean validInput = false;
            while (!validInput) {
                if (scanner.hasNextDouble()) {
                    coords[i] = scanner.nextDouble();
                    validInput = true;
                } else { // Некорректный ввод
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.next();
                }
            }
        }
        scanner.close();

        // Координаты в x,y
        double x1 = coords[0], y1 = coords[1];
        double x2 = coords[2], y2 = coords[3];
        double x3 = coords[4], y3 = coords[5];

        // длины стороны
        double sideA = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        double sideB = Math.sqrt((x3 - x2)*(x3 - x2) + (y3 - y2)*(y3 - y2));
        double sideC = Math.sqrt((x1 - x3)*(x1 - x3) + (y1 - y3)*(y1 - y3));

        // существует ли треугольник
        if (isValidTriangle(sideA, sideB, sideC)) {
            double perimeter = sideA + sideB + sideC;
            System.out.printf("Perimeter: %.3f%n", perimeter);
        } else {
            System.out.println("It's not a triangle");
        }

    }

    public static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 &&
                a + b > c && a + c > b && b + c > a;
    }

}