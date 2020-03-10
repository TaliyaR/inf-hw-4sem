package memento.interpreter;

import lombok.AllArgsConstructor;
import memento.Browser;

@AllArgsConstructor
public class InterpreterImpl implements Interpreter {

    private Browser browser;

    @Override
    public void handle(String str) {

        if (str.startsWith("goto")) {
            String[] command = str.split(" ");
            browser.goTo(command[1]);
        } else if (str.startsWith("link")) {
            String[] command = str.split(" ");
            browser.link(command[1]);
        } else if (str.startsWith("back")) {
            browser.back();
        } else if (str.startsWith("forward")) {
            browser.forward();
        } else if (str.startsWith("gotoposition")){

        }
    }
}
