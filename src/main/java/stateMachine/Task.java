package stateMachine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import stateMachine.model.attribute.Attribute;
import stateMachine.model.states.Draft;
import stateMachine.model.states.State;
import stateMachine.service.logger.IdGenerator;

@Data
@AllArgsConstructor
@Builder
public class Task implements TaskInterface{
    private State state;
    private Integer id;
    private Integer developerId;
    private Integer testerId;
    private String text;
    private String error;

    public Task(Integer developerId, Integer testerId, String text, String error) {
        this.id = IdGenerator.getId();
        this.developerId = developerId;
        this.testerId = testerId;
        this.text = text;
        this.error = error;
        this.state = new Draft(this);
    }

    private Task(Task task) {
        this.state = task.state.copy(this);
        this.id = task.id;
        this.developerId = task.developerId;
        this.testerId = task.testerId;
        this.text = task.text;
        this.error = task.error;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void down(Attribute attribute){
        state.down(attribute);
    }
    public void up(Attribute attribute){
        state.up(attribute);
    }

    public Task copy(){
        return new Task(this);
    }
}
