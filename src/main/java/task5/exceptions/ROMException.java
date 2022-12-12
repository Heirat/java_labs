package task5.exceptions;

public class ROMException extends MemoryException{
    public ROMException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Исключение в работе ПЗУ: " + getMessage();
    }


}
