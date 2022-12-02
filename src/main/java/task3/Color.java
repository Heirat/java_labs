package task3;

import java.util.Random;

public enum Color {
    RED("Красный"),
    GREEN("Зеленый"),
    BLUE("Синий"),
    YELLOW("Желтый"),
    BLACK("Черный"),
    WHITE("Белый"),
    PINK("Розовый"),
    LIME("Лаймовый");

    private final String name;
    private static final Random RANDOM = new Random();
    Color(String name) {
        this.name = name;
    }

    public static Color getRandomColor() {
        Color[] colors = values();
        return colors[RANDOM.nextInt(colors.length)];
    }
}
