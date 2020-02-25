package stateMachine.model.states;

import stateMachine.Task;
import stateMachine.model.attribute.Attribute;

public class Closed extends State {

    public Closed(Task task) {
        super(task);
    }

    @Override
    public void up(Attribute attribute) {
    }

    @Override
    public void down(Attribute attribute) {
    }

    @Override
    public State copy(Task task) {
        return new Closed(task);
    }
}
