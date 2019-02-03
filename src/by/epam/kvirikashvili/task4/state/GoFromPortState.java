package by.epam.kvirikashvili.task4.state;

import by.epam.kvirikashvili.task4.entity.Port;
import by.epam.kvirikashvili.task4.entity.Ship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum GoFromPortState implements IState {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(Ship.class);
    private final static Port port = Port.INSTANCE;

    @Override
    public boolean doAction(Ship ship) {
        LOGGER.info("  << " + ship.getName() + " leaved pierce with " + ship.getShipQuantity() + " containers"
                + "\n                                                  "
                + "Port capacity: " + port.getPortWarehouse().getQuantity());
        return false;
    }
}
