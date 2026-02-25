import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        int countPets = readInt(scanner);

        List<Animal> pets = Stream.generate(() -> readPets(scanner))
            .limit(countPets)
            .filter(Objects::nonNull)
            .toList();

        //Выпускаем зверушек на прогулки в асинхронных потоках
        CompletableFuture<Void> walksThreads = runAsyncWalks(pets, Instant.now());

        //Дожидаемся всех зверушек домой.
        walksThreads.join();
    }

    private static CompletableFuture<Void> runAsyncWalks(List<Animal> pets, Instant startTime) {
        List<CompletableFuture<Void>> petsWalks = new ArrayList<>();

        for (int i = 0; i < pets.size(); i++) {
            Animal pet = pets.get(i);
            final int walkDelay = i + 1;

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    //Пауза перед стартом прогулки
                    TimeUnit.MILLISECONDS.sleep(100L * walkDelay);

                    //Засечь время начала прогулки + время старта программы
                    Double timeFromStart = Duration.between(startTime, Instant.now()).toMillis() / 1000.0;

                    Double walkTime = pet.goToWalk();//Метод вернет длительность прогулки

                    System.out.printf("%s, start time = %.2f, end time = %.2f\n",
                            pet, timeFromStart, timeFromStart + walkTime);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            petsWalks.add(future);
        }

        return CompletableFuture.allOf(petsWalks.toArray(new CompletableFuture[0]));
    }

    private static Animal readPets(Scanner scanner) {
        petTypeEnum petType = getPetType(scanner);

        if (petType == null) {
            System.err.println("Incorrect input. Unsupported pet type");
            return null;
        }

        return createPet(scanner, petType);
    }

    private static Animal createPet(Scanner scanner, petTypeEnum petType) {
        String name = readString(scanner);
        int age = readInt(scanner);

        if (age <= 0) {
            System.err.println("Incorrect input. Age <= 0");
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
                System.err.println("Could not parse a number. Please, try again");
            }
        }
    }
}