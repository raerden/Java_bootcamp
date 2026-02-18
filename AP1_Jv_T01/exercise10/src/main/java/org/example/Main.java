package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

//Задание 10. Поиск имен совершеннолетних пользователей

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int countUsers = readInt(scanner);

        List<User> users = new ArrayList<>(countUsers);

        for (int i = 0; i < countUsers; i++) {
            User user = readUser(scanner);
            users.add(user);
        }
        scanner.close();

        String adults = filterAdultUsers(users);

        System.out.println(adults);
    }

    private static String filterAdultUsers(List<User> users) {
        return users.stream()
                .filter(User::isAdult)
                .map(User::getName)
                .collect(Collectors.joining(", "));
    }

    private static User readUser(Scanner scanner) {
        while(true) {
            String name = readString(scanner);
            int age = readInt(scanner);
            if (age > 0) {
                return new User(name, age);
            } else {
                System.out.println("Incorrect input. Age <= 0");
            }
        }
    }

    private static int readInt(Scanner scanner) {
        int res = 0;
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                res = scanner.nextInt();
                validInput = true;
                scanner.nextLine();
            } else { // Некорректный ввод
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
        return res;
    }

    private static String readString(Scanner scanner) {
        //здесь можно проверить чтобы не ввели пустое имя
        //но по заданию этого не требуется
        return scanner.nextLine();
    }

}