package task6;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            throw ExUtil.wrapToEx(new FileNotFoundException("Исключение: файл не найден!"));
        }
        catch (RuntimeException e) {
            System.out.println("Поймано Runtime исключение");
            ExUtil.printStackTrace(e);
            ExUtil.printStackTraceToFile(e, new PrintStream("err.txt"));
        }

        Exception e = ExUtil.wrapToExChain(new FileNotFoundException(), new ArrayIndexOutOfBoundsException(),
                new ArithmeticException(), new ArrayStoreException(), new IOException());
        e.printStackTrace();
    }
}
