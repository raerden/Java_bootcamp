package org.example;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

// Задание 7. Поиск максимального и минимального значений

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String fileName = readString();
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/" + fileName);

        try (Scanner scanner = new Scanner(file)) {
            //Читаем длину массива из файла
            int arrLength = readInt(scanner);

            if (arrLength > 0) {
                double[] arr = new double[arrLength];
                int readElements = readScannerArray(scanner, arr);

                if (readElements < arrLength) {
                    System.out.println("Input error. Insufficient number of elements");
                } else {// в считанном массиве достаточно элементов
                    //Печать элементов массива
                    printArr(arr);

                    //Поиск мин/макс
                    String strMinMax = arrayFindMinMax(arr);

                    //Запись в файл
                    saveStringToFile(strMinMax);
                }

            } else {
                System.out.println("Input error. Size <= 0");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input error. File doesn't exist");
            //e.printStackTrace();
        }

    }

    public static String readString() {
        try (Scanner consoleScanner = new Scanner(System.in)) {
            return consoleScanner.nextLine().trim();
        }
    }

    public static void saveStringToFile(String str) {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/result.txt");
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
            out.print(str);
            System.out.println("Saving min and max values in file");
        } catch (IOException e) {
            System.out.println("Unable to write file: result.txt");
            // e.printStackTrace();
        }
    }

    public static void printArr(double[] arr) {
        //Печать размера массива и значения его элементов
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(i == 0 ? "%.1f" : " %.1f", arr[i]);
        }
        System.out.println();
    }

    public static int readInt(Scanner scanner) {
        int arrLength = -1; // предполагаю ошибку "Input error. Size <= 0"
        //считать размер массива чисел
        if (scanner.hasNextInt()) {
            arrLength = scanner.nextInt();
        }
        return arrLength;
    }

    public static int readScannerArray(Scanner scanner, double[] arr) {
        int index = 0;
        while (index < arr.length && scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                arr[index] = scanner.nextDouble();
                index++;
            } else {
                scanner.next();
            }
        }
        return index; // Фактическое количество считанных вещественных чисел
    }

    public static String arrayFindMinMax(double[] arr) {
        int indexMin = 0;
        int indexMax = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[indexMin])
                indexMin = i + 1;
            if (arr[i + 1] > arr[indexMax])
                indexMax = i + 1;
        }
        return arr[indexMin] + " " + arr[indexMax];
    }
}