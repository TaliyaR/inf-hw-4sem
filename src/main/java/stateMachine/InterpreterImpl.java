package stateMachine;

import lombok.AllArgsConstructor;
import stateMachine.model.attribute.Attribute;

@AllArgsConstructor
public class InterpreterImpl implements Interpreter {

    private TaskManager taskManager;

    @Override
    public void handle(String str) {
        String[] command = str.split("-");
        switch (command[0]) {
            case "up":
                up(command);
                break;
            case "down":
                down(command);
                break;
            case "copy":
                System.out.println(copy(command[1]));
                break;
            case "new task":
                newTask(command);
                System.out.println(command[1]);
                break;
            default:
                System.out.println("No command");
                break;
        }
    }

    private Integer copy(String id) {
        TaskInterface taskInterface = taskManager.getTaskById(Integer.parseInt(id));
        if (taskInterface != null) {
            TaskInterface newTask = (TaskInterface) taskInterface.copy();
            taskManager.addTask(newTask);
            return newTask.getId();
        } else {
            return -1;
        }
    }

    private void up(String[] command) {
        Attribute attribute = new Attribute();
        for (int i = 2; i < command.length; i++) {
            String[] parameter = command[i].split("=");
            switch (parameter[0]) {
                case "developerId":
                    attribute.setDeveloperId(Integer.parseInt(parameter[1]));
                    break;
                case "testerId":
                    attribute.setTesterId(Integer.parseInt(parameter[1]));
                    break;
                case "error":
                    attribute.setError(parameter[1]);
                    break;
                case "text":
                    attribute.setText(parameter[1]);
                    break;
            }
        }
        TaskInterface taskInterface;
        if ((taskInterface = taskManager.getTaskById(Integer.parseInt(command[1]))) != null) {
            taskInterface.up(attribute);
        } else {
            System.out.println("No such task");
        }
    }

    private void down(String[] command) {
        Attribute attribute = new Attribute();
        for (int i = 2; i < command.length; i++) {
            String[] parameter = command[i].split("=");
            switch (parameter[0]) {
                case "developerId":
                    attribute.setDeveloperId(Integer.parseInt(parameter[1]));
                    break;
                case "testerId":
                    attribute.setTesterId(Integer.parseInt(parameter[1]));
                    break;
                case "error":
                    attribute.setError(parameter[1]);
                    break;
                case "text":
                    attribute.setText(parameter[1]);
                    break;
            }
        }
        taskManager.getTaskById(Integer.parseInt(command[1])).down(attribute);
    }

    private void newTask(String[] command) {
        Attribute argument = Attribute.builder().text(command[0]).build();
        taskManager.addTask(new ProxyTask(argument));
    }
}
