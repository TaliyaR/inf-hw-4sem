package springIoC.services;

import springIoC.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class Commands implements Interpreter {
    Scanner scanner;

    @Autowired
    UserContainer userContainer;

    public Commands(Scanner scanner) {
        this.scanner = scanner;
    }

    public void handle() {
        String str = scanner.nextLine();
        if (str.startsWith("add")) {
            String[] command = str.split(" ");
            add(command[1]);
        } else if (str.startsWith("out")) {
            System.out.println(out());
        } else if (str.startsWith("stop")) {
            stop();
        }
    }

    private void add(String name) {
        userContainer.add(User.builder()
        .name(name)
        .build());
    }

    private List<User> out(){
        return userContainer.out();
    }

    private void stop(){
        System.exit(0);
    }
}
