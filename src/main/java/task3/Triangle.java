package task3;

import java.util.Random;

public class Triangle extends Figure{
    private Double side1;
    private Double side2;
    private Double side3;

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

    public Double getSide3() {
        return side3;
    }

    public void setSide3(Double side3) {
        this.side3 = side3;
    }

    public Triangle(Double side1, Double side2, Double side3, Color color, Double lineThickness) {
        this(side1, side2, side3);
        this.fillColor = color;
        this.lineThickness = lineThickness;
    }

    public Triangle(Double side1, Double side2, Double side3) {
        this.name = "Треугольник";
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public Double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public Double getArea() {
        Double p = getPerimeter();
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public static Triangle getRandomInstance() {
        Random r = new Random();
        return new Triangle(r.nextDouble() * 10 + 1, r.nextDouble() * 10 + 1, r.nextDouble() * 10 + 1,
                Color.getRandomColor(), r.nextDouble() * 5 + 1);
    }
}
