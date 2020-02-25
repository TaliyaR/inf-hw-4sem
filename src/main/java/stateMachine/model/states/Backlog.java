package stateMachine.model.states;

import stateMachine.Task;
import stateMachine.model.attribute.Attribute;

public class Backlog extends State {

    public Backlog(Task task) {
        super(task);
    }

    @Override
    public void up(Attribute attribute) {
        task.changeState(new Open(task));
    }

    @Override
    public void down(Attribute attribute) {
    }

    @Override
    public State copy(Task task) {
        return new Backlog(task);
    }
}
