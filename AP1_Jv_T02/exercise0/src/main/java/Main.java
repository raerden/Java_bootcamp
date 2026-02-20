import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// Задание 1. Список питомцев

abstract class Animal {
    private String name;
    private int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String toString();
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Dog name = " + super.getName() + ", age = " + super.getAge();
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Cat name = " + super.getName() + ", age = " + super.getAge();
    }
}




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

        return switch (petType) {
            case "dog" -> new Dog(name, age);
            case "cat" -> new Cat(name, age);
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