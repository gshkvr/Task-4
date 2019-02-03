package by.epam.kvirikashvili.task4.state;

import by.epam.kvirikashvili.task4.entity.Port;
import by.epam.kvirikashvili.task4.entity.Ship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum GoToPortState implements IState {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(Ship.class);
    private final Port port = Port.INSTANCE;

    @Override
    public boolean doAction(Ship ship) {
        try {
            port.getSemaphore().acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("    >> " + ship.getName() + " came to pierce");
        StateFactory stateFactory = StateFactory.INSTANCE;
        ship.setCurrentState(stateFactory.getState("workInPort"));
        return true;
    }
}