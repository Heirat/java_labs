package task3;

import java.util.Random;

public class Trapezoid extends Figure {
    private Double side1;
    private Double side2;
    private Double side3;
    private Double side4;
    // Высота, проведенная к стороне 1
    private Double height;

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

    public Double getSide3() {
        return side3;
    }

    public void setSide3(Double side3) {
        this.side3 = side3;
    }

    public Double getSide4() {
        return side4;
    }

    public void setSide4(Double side4) {
        this.side4 = side4;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Trapezoid(Double side1, Double side2, Double side3, Double side4, Double height) {
        this.name = "Трапеция";
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        this.height = height;
    }

    public Trapezoid(Double side1, Double side2, Double side3, Double side4, Double height, Color color, Double lineThickness) {
        this(side1, side2, side3, side4, height);
        this.fillColor = color;
        this.lineThickness = lineThickness;
    }

    @Override
    public Double getPerimeter() {
        return side1 + side2 + side3 + side4;
    }

    @Override
    public Double getArea() {
        return height * (side1 + side2) / 2;
    }

    public static Trapezoid getRandomInstance() {
        Random r = new Random();
        return new Trapezoid(r.nextDouble() * 10 + 1, r.nextDouble() * 10 + 1,
                r.nextDouble() * 10 + 1, r.nextDouble() * 10 + 1, r.nextDouble() * 10 + 1,
                Color.getRandomColor(), r.nextDouble() * 5 + 1);
    }
}
