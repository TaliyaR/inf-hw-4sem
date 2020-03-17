package springIoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springIoC.config.AppConfiguration;
import springIoC.services.Commands;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Commands commands = (Commands) context.getBean("commands");
        while (true){
            commands.handle();
        }
    }
}
