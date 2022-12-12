package task9;

import java.io.PrintStream;
import java.lang.reflect.*;

public class ReflectionInfo<T> {
    private T instance;
    private Class<T> tClass;

    public ReflectionInfo(T instance) {
        this.instance = instance;
        tClass = (Class<T>) instance.getClass();
    }

    public T getInstance() {
        return instance;
    }

    public void setInstance(T instance) {
        this.instance = instance;
        this.tClass = (Class<T>) instance.getClass();
    }

    public void printInfo(PrintStream out) {
        printConstructors(out);
        printFields(out);
        printMethods(out);
    }

    private void printConstructors(PrintStream out) {
        out.println("Constructors:");
        for (Constructor<?> constructor : tClass.getConstructors()) {
            out.print(constructor.getDeclaringClass().getSimpleName() + " (");
            Parameter[] params = constructor.getParameters();
            if (params.length > 0) {
                for (int i = 0; i < params.length - 1; i++) {
                    out.print(params[i].getType().getSimpleName() + " " + params[i].getName() + ", ");
                }
                out.print(params[params.length-1].getType().getSimpleName() + " " + params[params.length-1].getName());
            }
            out.println(")");
        }
    }

    private void printFields(PrintStream out) {
        out.println("\nFields: ");
        for (Field field : tClass.getDeclaredFields()) {
            out.println(field.getType().getSimpleName() + " " + field.getName());
        }
    }

    private void printMethods(PrintStream out) {
        out.println("\nMethods:");
        for (Method method : tClass.getDeclaredMethods()) {
            out.print(method.getName() + "( ");

            Parameter[] params = method.getParameters();
            if (params.length > 0) {
                for (int i = 0; i < params.length - 1; i++) {
                    out.print(params[i].getType().getSimpleName() + " " + params[i].getName() + ", ");
                }
                out.print(params[params.length-1].getType().getSimpleName() + " " + params[params.length-1].getName());
            }

            out.print(")");

            Class<?>[] exceptions= method.getExceptionTypes();
            if (exceptions.length > 0) {
                out.print(" throws ");
                for (int i = 0; i < exceptions.length - 1; i++) {
                    out.print(exceptions[i].getSimpleName() + ", ");
                }
                out.print(exceptions[exceptions.length-1].getSimpleName());
            }
            out.println();
        }
    }

    public Object invokeMethod(String methodName, Object... args){
        try {
            Class<?>[] argsClasses = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                argsClasses[i] = args[i].getClass();
            }
            Method method = tClass.getMethod(methodName, argsClasses);
            method.setAccessible(true);
            // Если метод возвращает не generic, то приводим к этому типу. Иначе Object.
            return (method.getReturnType()).cast(method.invoke(instance, args));
        }
        catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object invokeMethod(String methodName){
        try {
            Method method = tClass.getDeclaredMethod(methodName);
            method.setAccessible(true);
            // Если метод возвращает не generic, то приводим к этому типу. Иначе Object.
            return (method.getReturnType()).cast(method.invoke(instance));
        }
        catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
