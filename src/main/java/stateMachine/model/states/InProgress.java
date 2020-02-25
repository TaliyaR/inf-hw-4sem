package stateMachine.model.states;

import stateMachine.Task;
import stateMachine.model.attribute.Attribute;

public class InProgress extends State {

    public InProgress(Task task) {
        super(task);
    }

    @Override
    public void up(Attribute attribute) {
        task.changeState(new Resolved(task));
    }

    @Override
    public void down(Attribute attribute) {
        task.changeState(new Assigned(task));
    }

    @Override
    public State copy(Task task) {
        return new InProgress(task);
    }
}
