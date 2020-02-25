package stateMachine.model.states;

import stateMachine.Task;
import stateMachine.model.attribute.Attribute;

public class Testing extends State {

    public Testing(Task task) {
        super(task);
    }

    @Override
    public void up(Attribute attribute) {
        task.setDeveloperId(0);
        task.setTesterId(0);
        task.changeState(new Closed(task));
    }

    @Override
    public void down(Attribute attribute) {
//        task.setError(attribute.getErrorText());
        task.changeState(new Assigned(task));
    }

    @Override
    public State copy(Task task) {
        return new Testing(task);
    }
}
