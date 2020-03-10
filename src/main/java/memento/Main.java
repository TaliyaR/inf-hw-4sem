package memento;

import memento.interpreter.Interpreter;
import memento.interpreter.InterpreterImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println(browser.getCurrentPage());

//        browser.link("Site2");
//        browser.goTo("Site1");
//        browser.goTo("Site2");
//        browser.goTo("Site3");

//        Memento memento = browser.save();

//        browser.goTo("Site4");
//        browser.goTo("Site5");

//        System.out.println(browser.getCurrentPage());
//        memento.restore();

//        System.out.println(browser.getCurrentPage());

        Browser browser = new Browser();
//        browser.link("Site2");
//        browser.back();
//        System.out.println(browser.getCurrentPage());
//        browser.link("Site3");

        Interpreter interpreter = new InterpreterImpl(browser);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            interpreter.handle(line);
        }
    }
}
