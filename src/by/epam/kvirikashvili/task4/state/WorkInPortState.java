package by.epam.kvirikashvili.task4.state;

import by.epam.kvirikashvili.task4.entity.Port;
import by.epam.kvirikashvili.task4.entity.Ship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum WorkInPortState implements IState {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(Ship.class);
    private final Port port = Port.INSTANCE;

    @Override
    public boolean doAction(Ship ship) {
        try {
            if (ship.getShipQuantity() > 0) {
                unloadShip(ship);
            } else {
                loadShip(ship);
            }
        } finally {
            port.getSemaphore().release();
        }
        StateFactory stateFactory = StateFactory.INSTANCE;
        ship.setCurrentState(stateFactory.getState("goFromPort"));
        return true;
    }

    public void unloadShip(Ship ship) {
        while (ship.getShipQuantity() > 0) {
            if (port.getPortWarehouse().addContainer()) {
                LOGGER.info("  + " + ship.getName() + " unloaded container.");
                ship.removeContainer();
            } else {
                LOGGER.info("  Don't have enough free space for " + ship.getName()
                        + ". Need free space for " + ship.getShipQuantity() + " containers");
                break;
            }

        }
    }

    public void loadShip(Ship ship) {
        while (ship.getShipQuantity() < ship.getMaxShipQuantity()) {
            if (port.getPortWarehouse().removeContainer()) {
                LOGGER.info("  - " + ship.getName() + " loaded container.");
                ship.addContainer();
            } else {
                LOGGER.info("  Don't have enough containers for " + ship.getName()
                        + ". Need " + (ship.getMaxShipQuantity() - ship.getShipQuantity()) + " containers");
                break;
            }
        }
    }
}
