package stateMachine.model.states;

import stateMachine.Task;
import stateMachine.model.attribute.Attribute;

public class Resolved extends State {

    public Resolved(Task task) {
        super(task);
    }

    @Override
    public void up(Attribute attribute) {
        task.setTesterId(attribute.getTesterId());
        task.changeState(new Testing(task));
    }

    @Override
    public void down(Attribute attribute) {
        task.changeState(new InProgress(task));
    }

    @Override
    public State copy(Task task) {
        return new Resolved(task);
    }
}
