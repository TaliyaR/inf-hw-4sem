package stateMachine.model.states;

import stateMachine.Task;
import stateMachine.model.attribute.Attribute;

public class Assigned extends State {

    public Assigned(Task task) {
        super(task);
    }

    @Override
    public void up(Attribute attribute) {
        task.changeState(new InProgress(task));
    }

    @Override
    public void down(Attribute attribute) {
        task.setDeveloperId(0);
        task.changeState(new Open(task));
    }

    @Override
    public State copy(Task task) {
        return new Assigned(task);
    }

}