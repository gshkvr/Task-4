package by.epam.kvirikashvili.task4.state;

import by.epam.kvirikashvili.task4.entity.Ship;

public interface IState {
    boolean doAction(Ship ship);
}
