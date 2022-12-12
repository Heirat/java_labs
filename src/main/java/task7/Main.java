package task7;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>(3);
        System.out.println("Коробка пуста? " + box.isEmpty());
        box.put("Карандаш");
        box.put("Линейка");
        System.out.println("Текущий размер: " + box.size());
        box.put("Пенал");
        System.out.println(box);
        box.remove("Линейка");
        System.out.println("После удаления линейки: " + box);
        System.out.println("Случайный элемент: " + box.get());
    }
}
