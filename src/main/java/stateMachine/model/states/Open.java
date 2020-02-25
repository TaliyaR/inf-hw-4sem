package stateMachine.model.states;

import stateMachine.Task;
import stateMachine.model.attribute.Attribute;

public class Open extends State {

    public Open(Task task) {
        super(task);
    }

    @Override
    public void up(Attribute attribute) {
        task.setDeveloperId(attribute.getDeveloperId());
        task.changeState(new Assigned(task));
    }

    @Override
    public void down(Attribute attribute) {
        task.changeState(new Backlog(task));
    }

    @Override
    public State copy(Task task) {
        return new Open(task);
    }
}
