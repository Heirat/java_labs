package task3;

import java.util.Random;

public class Parallelogram extends Figure{
    private Double side1;
    private Double side2;
    // Высота, проведенная к стороне 1
    private Double height;

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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Parallelogram(Double side1, Double side2, Double height) {
        this.name = "Параллелограмм";
        this.side1 = side1;
        this.side2 = side2;
        this.height = height;
    }

    public Parallelogram(Double side1, Double side2, Double height, Color color, Double lineThickness) {
        this(side1, side2, height);
        this.fillColor = color;
        this.lineThickness = lineThickness;
    }

    @Override
    public Double getPerimeter() {
        return (side1 + side2) * 2;
    }

    @Override
    public Double getArea() {
        return side1 * height;
    }

    public static Parallelogram getRandomInstance() {
        Random r = new Random();
        return new Parallelogram(r.nextDouble() * 10 + 1, r.nextDouble() * 10 + 1, r.nextDouble() * 10 + 1,
                Color.getRandomColor(), r.nextDouble() * 5 + 1);
    }
}
