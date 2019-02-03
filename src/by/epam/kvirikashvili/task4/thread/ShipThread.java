package by.epam.kvirikashvili.task4.thread;

import by.epam.kvirikashvili.task4.entity.Ship;

import java.util.concurrent.Callable;

public class ShipThread implements Callable {
    private Ship ship;

    @Override
    public Object call() {
        ship.work();
        return null;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
