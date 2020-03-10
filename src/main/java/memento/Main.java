package memento;

import memento.interpreter.Interpreter;
import memento.interpreter.InterpreterImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Browser browser = new Browser();

        Interpreter interpreter = new InterpreterImpl(browser);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            interpreter.handle(line);
        }
    }
}
