package stateMachine;

import stateMachine.model.attribute.Attribute;
import stateMachine.model.states.State;

public interface TaskInterface {
    void changeState(State state);

    void up(Attribute attribute);

    void down(Attribute attribute);

    TaskInterface copy();

    Integer getId();
}
