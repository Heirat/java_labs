package task5.exceptions;

public class RAMException extends MemoryException{

    public RAMException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Исключение в работе ОЗУ: " + getMessage();
    }
}
