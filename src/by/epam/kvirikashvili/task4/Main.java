package by.epam.kvirikashvili.task4;

import by.epam.kvirikashvili.task4.entity.Port;
import by.epam.kvirikashvili.task4.entity.Ship;
import by.epam.kvirikashvili.task4.exception.IncorrectInputFileException;
import by.epam.kvirikashvili.task4.generator.RandomShipGenerator;
import by.epam.kvirikashvili.task4.input.ShipReader;

import java.util.List;

public class Main {
    private static final String FILE_PATH = "./files/port.txt";
    private final static Port port = Port.INSTANCE;

    public static void main(String[] args) {
        RandomShipGenerator randomShipGenerator = new RandomShipGenerator();
        ShipReader shipReader = new ShipReader();

        try {
            randomShipGenerator.generateFile(FILE_PATH, 10);
            List<Ship> ships = shipReader.readShips(FILE_PATH);
            port.emulateWork(ships);
        } catch (IncorrectInputFileException e) {
            e.printStackTrace();
        }
    }
}

