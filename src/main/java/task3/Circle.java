package task3;

import java.util.Random;

public class Circle extends Figure{
    private Double radius;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle(Double radius) {
        this.name = "Круг";
        this.radius = radius;
    }

    public Circle(Double radius, Color color, Double lineThickness) {
        this(radius);
        this.fillColor = color;
        this.lineThickness = lineThickness;
    }

    @Override
    public Double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double getArea() {
        return Math.PI * radius * radius;
    }

    public static Circle getRandomInstance() {
        Random r = new Random();
        return new Circle(r.nextDouble() * 10 + 1,
                Color.getRandomColor(), r.nextDouble() * 5 + 1);
    }
}
