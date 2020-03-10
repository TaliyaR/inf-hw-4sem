package memento;

import java.util.Stack;

public class History {
    Stack<Browser.Memento> backStack;
    Stack<Browser.Memento> forwardStack;

    public History() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
    }

    public void push(Browser.Memento memento) {
        backStack.push(memento);
    }
    public void clearForwardStack(){
        forwardStack.clear();
    }

    public void back() {
        if (backStack.size() > 1) {
            forwardStack.push(backStack.pop());
            backStack.peek().restore();
        }
        else {
            System.out.println("Назад нельзя");
        }
    }

    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(forwardStack.pop());
        } else {
            System.out.println("Вперед нельзя");
        }
    }
}
