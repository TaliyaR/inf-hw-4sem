package stateMachine;

import stateMachine.model.attribute.Attribute;
import stateMachine.model.states.State;
import stateMachine.service.logger.Logger;

import java.io.File;
import java.util.Date;

public class ProxyTask implements TaskInterface {

    private TaskInterface taskInterface;
    private Logger logger;

    private ProxyTask(ProxyTask proxyTask) {
        this.taskInterface = proxyTask.taskInterface.copy();
        this.logger = proxyTask.logger;
    }

    public ProxyTask(Attribute attribute) {
        this.taskInterface = new Task(attribute.getDeveloperId(), attribute.getTesterId(), attribute.getText(), attribute.getError());
        logger = new Logger(new File("log.txt"));
    }

    @Override
    public void up(Attribute attribute) {
        logger.log(this + " method: up " + new Date());
        taskInterface.up(attribute);

    }

    @Override
    public void down(Attribute attribute) {
        logger.log(this + " method: down " + new Date());
        taskInterface.down(attribute);
    }

    @Override
    public void changeState(State state) {
        logger.log(this + " method: change state " + new Date());
        taskInterface.changeState(state);
    }

    @Override
    public ProxyTask copy() {
        logger.log(this + " method: copy " + new Date());
        return new ProxyTask(this);
    }

    @Override
    public Integer getId() {
        return taskInterface.getId();
    }
}
