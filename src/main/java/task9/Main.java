package task9;

public class Main {
    public static void main(String[] args) {
        ReflectionInfo<String> info = new ReflectionInfo<>("  first string with spaces    ");
        // Вывод информации о классе
        info.printInfo(System.out);
        // Вызов метода без параметров
        info.setInstance((String) info.invokeMethod("trim"));
        // Вызов метода с параметрами
        System.out.println(info.invokeMethod("concat", ". Another string without spaces."));

    }
}
