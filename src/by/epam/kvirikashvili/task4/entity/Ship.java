package by.epam.kvirikashvili.task4.entity;

import by.epam.kvirikashvili.task4.state.IState;
import by.epam.kvirikashvili.task4.state.StateFactory;

public class Ship {
    private final int maxShipCapacity;
    private IState currentState;
    private String name;
    private int shipCapacity;

    public Ship(String name, int shipCapacity, int maxShipCapacity) {
        this.maxShipCapacity = maxShipCapacity;
        this.shipCapacity = shipCapacity;
        StateFactory stateFactory = StateFactory.INSTANCE;
        this.currentState = stateFactory.getState("goToPort");
        this.name = name;
    }

    public void work() {
        boolean continueFlag = true;
        while (continueFlag) {
            continueFlag = currentState.doAction(this);
        }
    }

    public void addContainer() {
        shipCapacity++;
    }

    public void removeContainer() {
        shipCapacity--;
    }

    public int getMaxShipQuantity() {
        return maxShipCapacity;
    }

    public int getShipQuantity() {
        return shipCapacity;
    }

    public String getName() {
        return name;
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }
}
