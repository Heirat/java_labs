package task5.exceptions;

public class CPUException extends HardwareException {
    public CPUException() {
    }

    public CPUException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Исключение в работе ЦП: " + getMessage();
    }
}
