import java.util.*;
import java.util.stream.Stream;

// Задание 6. Итератор питомцев

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        int countPets = readInt(scanner);

        List<Animal> pets = Stream.generate(() -> readPets(scanner))
            .limit(countPets)
            .filter(Objects::nonNull)
            .toList();

        AnimalIterator iterator = new AnimalIterator(pets);

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }


    private static Animal readPets(Scanner scanner) {
        petTypeEnum petType = getPetType(scanner);

        if (petType == null) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }

        return createPet(scanner, petType);
    }

    private static Animal createPet(Scanner scanner, petTypeEnum petType) {
        String name = readString(scanner);
        int age = readInt(scanner);

        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            return null;
        }

        return switch (petType) {
            case dog -> new Dog(name, age);
            case cat -> new Cat(name, age);
            default -> null;
        };
    }

    private static enum petTypeEnum {
        dog, cat;

        public static boolean contains(String petType) {
            return Arrays.stream(values())
                  .anyMatch(pt -> pt.name().equals(petType));
        }
    }

    private static petTypeEnum getPetType(Scanner scanner) {
        String petType = readString(scanner).trim().toLowerCase();
        if (petTypeEnum.contains(petType))
            return petTypeEnum.valueOf(petType);
        return null;
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