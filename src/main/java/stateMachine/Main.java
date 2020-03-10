package stateMachine;

import stateMachine.model.attribute.Attribute;
import stateMachine.model.states.InProgress;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager stateMachine = new TaskManager();
        stateMachine.addTask(new ProxyTask(new Attribute()));
        stateMachine.addTask(new ProxyTask(new Attribute()));
        stateMachine.addTask(new ProxyTask(new Attribute()));
        ProxyTask taskProxy = new ProxyTask(new Attribute());
        stateMachine.addTask(taskProxy.copy());
        stateMachine.addTask(taskProxy.copy());
        ProxyTask taskProxy1 = (ProxyTask) stateMachine.getTaskById(1).copy();
        System.out.println(taskProxy1.getId());
        Interpreter interpreter = new InterpreterImpl(stateMachine);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine();
            interpreter.handle(string);
        }
    }
}
