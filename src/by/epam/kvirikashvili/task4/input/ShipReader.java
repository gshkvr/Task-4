package by.epam.kvirikashvili.task4.input;

import by.epam.kvirikashvili.task4.entity.Ship;
import by.epam.kvirikashvili.task4.exception.IncorrectInputFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShipReader {
    public List<Ship> readShips(String path) throws IncorrectInputFileException {
        Path filePath = Paths.get(path);
        List<Ship> ships = new ArrayList<>();
        try (Stream<String> shipsStream = Files.lines(filePath)) {
            shipsStream.forEach(shipStr -> {
                String[] shipParameters = shipStr.split(" ");
                ships.add(new Ship(shipParameters[0],
                        Integer.parseInt(shipParameters[1]),
                        Integer.parseInt(shipParameters[2])));
            });
        } catch (IOException e) {
            throw new IncorrectInputFileException("Incorrect reader file path", e);
        }
        return ships;
    }
}
