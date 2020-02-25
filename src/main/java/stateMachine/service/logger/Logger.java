package stateMachine.service.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private FileWriter writer;

    public Logger(File file) {
        try {
            this.writer = new FileWriter(file, true);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void log(String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
