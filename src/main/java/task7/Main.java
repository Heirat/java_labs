package task7;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>(4);

        System.out.println("Коробка пуста? " + box.isEmpty());
        box.put("Карандаш");
        box.put("Линейка");
        box.put("Портфель");
        System.out.println("Текущий размер: " + box.getSize());
        box.put("Пенал");
        System.out.println(box);
        System.out.println("Линейка была и удалена? " + box.remove("Линейка"));
        System.out.println("Бутерброд был и удален? " + box.remove("Бутерброд"));
        System.out.println("После удаления линейки: " + box);
        System.out.println("Случайный элемент: " + box.get());
    }
}
