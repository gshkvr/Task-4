package by.epam.kvirikashvili.task4.generator;

import by.epam.kvirikashvili.task4.exception.IncorrectInputFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class RandomShipGenerator {
    public void generateFile(String filePath, int shipsCount) throws IncorrectInputFileException {
        Path path = Paths.get(filePath);
        try {
            Files.newInputStream(path, StandardOpenOption.TRUNCATE_EXISTING);
            Random random = new Random();
            StringBuilder ships = new StringBuilder();
            String ship;
            for (int i = 0; i < shipsCount; i++) {
                String shipName = "Ship" + (i + 1);
                int shipCapacity = random.nextInt(99) + 1;
                int maxShipCapacity = random.nextInt(99) + 1;
                if (shipCapacity < maxShipCapacity) {
                    ship = shipName + " " + shipCapacity + " " + maxShipCapacity;
                } else {
                    ship = shipName + " " + "0 " + maxShipCapacity;
                }
                ships.append(ship);
                if (i < shipsCount - 1) {
                    ships.append("\n");
                }
            }
            Files.write(path, ships.toString().getBytes());
        } catch (IOException e) {
            throw new IncorrectInputFileException("Incorrect reader file path", e);
        }
    }
}
