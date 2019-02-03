package by.epam.kvirikashvili.task4.state;

public enum StateFactory {
    INSTANCE;

    private final IState goToPortState = GoToPortState.INSTANCE;
    private final IState workInPortState = WorkInPortState.INSTANCE;
    private final IState goFromPortState = GoFromPortState.INSTANCE;

    public IState getState(String state) {
        switch (state) {
            case "goToPort":
                return goToPortState;
            case "workInPort":
                return workInPortState;
            case "goFromPort":
            default:
                return goFromPortState;
        }
    }
}
