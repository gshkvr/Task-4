package by.epam.kvirikashvili.task4.warehouse;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public enum PortWarehouse implements Warehouse {
    INSTANCE;

    private Lock lock = new ReentrantLock();
    private int portWarehouseQuantity;

    @Override
    public boolean addContainer() {
        lock.lock();
        try {
            int maxQuantity = 100;
            if (portWarehouseQuantity < maxQuantity) {
                portWarehouseQuantity++;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeContainer() {
        lock.lock();
        try {
            int minQuantity = 0;
            if (portWarehouseQuantity > minQuantity) {
                portWarehouseQuantity--;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getQuantity() {
        lock.lock();
        try {
            return portWarehouseQuantity;
        } finally {
            lock.unlock();
        }
    }
}
