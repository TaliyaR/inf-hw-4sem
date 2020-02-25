package stateMachine.service.logger;

public class IdGenerator {
    private static Integer id = 0;

    public static Integer getId() {
        return id++;
    }
}
