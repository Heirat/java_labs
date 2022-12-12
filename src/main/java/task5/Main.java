package task5;

import task5.exceptions.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            Random r = new Random();
            switch (r.nextInt(4)) {
                case(0):
                    throw new ROMException("Не найден накопитель");
                case(1):
                    throw new RAMException("Оперативная память переполнена");
                case(2):
                    throw new OverheatingCPUException(r.nextDouble() * 64 + 90);
                case(3):
                    throw new CPUException("Физическое повреждение одного из ядер");
            }
        }
        catch (ROMException e) {
            System.out.println("Обработка исключения в работе ПЗУ...");
            System.out.println("Исключение обработано");
        }
        catch (RAMException e) {
            System.out.println("Обработка исключения в работе ОЗУ...");
            System.out.println("Исключение обработано");
        }
        catch (HardwareException e) {
            e.printStackTraceInFile("log.txt");
            e.printStackTrace(System.err);
        }

        System.out.println("Конец работы программы");
    }
}
