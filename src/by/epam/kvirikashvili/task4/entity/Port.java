package by.epam.kvirikashvili.task4.entity;

import by.epam.kvirikashvili.task4.thread.ShipThread;
import by.epam.kvirikashvili.task4.warehouse.PortWarehouse;
import by.epam.kvirikashvili.task4.warehouse.Warehouse;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

public enum Port {
    INSTANCE;

    private Warehouse portWarehouse = PortWarehouse.INSTANCE;
    private Semaphore semaphore = new Semaphore(3, true);

    public Warehouse getPortWarehouse() {
        return portWarehouse;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void emulateWork(List<Ship> ships) {
        ExecutorService executorService = Executors.newFixedThreadPool(ships.size());
        for (Ship ship : ships) {
            ShipThread shipThread = new ShipThread();
            shipThread.setShip(ship);
            FutureTask futureTask = new FutureTask(shipThread);
            executorService.submit(futureTask);
        }
        executorService.shutdown();
    }

}
