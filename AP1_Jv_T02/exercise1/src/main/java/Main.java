import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// Задание 2. Определение количества корма питомцу

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        int countPets = readInt(scanner);

        List<Animal> pets = new ArrayList<>(countPets);

        readAnimals(scanner, pets, countPets);

        printList(pets);
    }

    private static void printList(List<Animal> pets) {
        for(Animal pet : pets) {
            System.out.println(pet.toString());
        }
    }

    private static void readAnimals(Scanner scanner, List<Animal> pets, int countPets) {
        for (int i = 0; i < countPets; i++) {
            String petType = readString(scanner);
            Animal pet = createPet(scanner, petType);
            if (pet != null) {
                pets.add(pet);
            }
        }
    }

    private static Animal createPet(Scanner scanner, String petType) {
        if(!"dog".equals(petType) && !"cat".equals(petType)) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }

        String name = readString(scanner);
        int age = readInt(scanner);

        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            return null;
        }

        double weight = readDouble(scanner);

        if (weight <= 0) {
            System.out.println("Incorrect input. Mass <= 0");
            return null;
        }

        return switch (petType) {
            case "dog" -> new Dog(name, age, weight);
            case "cat" -> new Cat(name, age, weight);
            default -> null;
        };
    }


    private static String readString(Scanner scanner) {
        return scanner.nextLine();
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

}