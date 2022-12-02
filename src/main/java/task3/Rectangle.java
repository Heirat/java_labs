package task3;

import java.util.Random;

public class Rectangle extends Figure {
    private Double side1;
    private Double side2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSide1() {
        return side1;
    }

    public void setSide1(Double side1) {
        this.side1 = side1;
    }

    public Double getSide2() {
        return side2;
    }

    public void setSide2(Double side2) {
        this.side2 = side2;
    }

    public Rectangle(Double side1, Double side2) {
        this.name = "Прямоугольник";
        this.side1 = side1;
        this.side2 = side2;
    }

    public Rectangle(Double side1, Double side2, Color color, Double lineThickness) {
        this(side1, side2);
        this.fillColor = color;
        this.lineThickness = lineThickness;
    }

    @Override
    public Double getPerimeter() {
        return (side1 + side2) * 2;
    }

    @Override
    public Double getArea() {
        return side1 * side2;
    }

    public static Rectangle getRandomInstance() {
        Random r = new Random();
        return new Rectangle(r.nextDouble() * 10 + 1, r.nextDouble() * 10 + 1,
                Color.getRandomColor(), r.nextDouble() * 5 + 1);
    }
}
