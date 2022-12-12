package task5.exceptions;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class HardwareException extends Exception{
    public HardwareException() {}
    public HardwareException(String message) {
        super(message);
    }

    public void printStackTraceInFile(String filepath) {
        try {
            File log = new File(filepath);
            log.createNewFile();
            this.printStackTrace(new PrintStream(log));
        }
        catch (IOException e) {
            System.out.println("Не удалось записать stack trace в файл.");
        }
    }
}
