import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        int countPets = readInt(scanner);

        List<Animal> pets = new ArrayList<>(countPets);

        readAnimals(scanner, pets, countPets);

        printHerbivoreList(pets);
        printOmnivoreList(pets);
    }

    private static void printOmnivoreList(List<Animal> pets) {
        for (Animal pet : pets) {
            if (pet instanceof Omnivore) {
                System.out.println(pet.toString());
            }
        }
    }

    private static void printHerbivoreList(List<Animal> pets) {
        for (Animal pet : pets) {
            if (pet instanceof Herbivore) {
                System.out.println(pet.toString());
            }
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

    private enum petTypeEnum {
        dog, cat, hamster, guinea;

        public static boolean contains(String type) {
            for (petTypeEnum pt : values()) {
                if (pt.name().equals(type)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static Animal createPet(Scanner scanner, String petType) {
        if(!petTypeEnum.contains(petType)) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }

        String name = readString(scanner);
        int age = readInt(scanner);

        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            return null;
        }


        return switch (petType) {
            case "dog" -> new Dog(name, age);
            case "cat" -> new Cat(name, age);
            case "hamster" -> new Hamster(name, age);
            case "guinea" -> new GunieaPig(name, age);
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
}


