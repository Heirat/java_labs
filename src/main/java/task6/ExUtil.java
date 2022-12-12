package task6;

import java.io.PrintStream;

public class ExUtil {

    public static RuntimeException wrapToEx(Exception mainException) {
        return new RuntimeException(mainException);
    }

    public static void printStackTrace(Exception e) {
        e.printStackTrace();
    }

    public static void printStackTraceToFile(Exception e, PrintStream s) {
        e.printStackTrace(s);
    }

    public static RuntimeException wrapToExChain(Exception mainException, Exception... causes) {
        for (int i = causes.length - 1; i > 0; i--) {
            causes[i-1].initCause(causes[i]);
        }
        mainException.initCause(causes[0]);

        return new RuntimeException(mainException);
    }
}
