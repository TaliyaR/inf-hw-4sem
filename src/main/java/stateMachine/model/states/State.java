package stateMachine.model.states;

import stateMachine.Task;
import stateMachine.model.attribute.Attribute;

public abstract class State {
    protected Task task;

    public State(Task task) {
        this.task = task;
    }

    public Task getContext() {
        return task;
    }

    public abstract void up(Attribute attribute);

    public abstract void down(Attribute attribute);

    public abstract State copy(Task task);

}
