package task3;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int figuresCount;
        if (args.length > 0)
            figuresCount = Integer.parseInt(args[0]);
        else
            figuresCount = 5;

        ArrayList<Figure> figures = new ArrayList<>(figuresCount);

        for (int i = 0; i < figuresCount; i++) {
            Random r = new Random();
            switch (r.nextInt(5)) {
                case (0):
                    figures.add(Circle.getRandomInstance());
                    break;
                case (1):
                    figures.add(Triangle.getRandomInstance());
                    break;
                case(2):
                    figures.add(Rectangle.getRandomInstance());
                    break;
                case(3):
                    figures.add(Parallelogram.getRandomInstance());
                    break;
                case(4):
                    figures.add(Trapezoid.getRandomInstance());
                    break;
            }
        }

        for (Figure figure: figures) {
            System.out.println(figure.getName());
            System.out.println("\t Периметр: " + figure.getPerimeter());
            System.out.println("\t Площадь: " + figure.getArea());
            System.out.println("\t Цвет заливки: " + figure.getFillColor());
            System.out.println("\t Толщина линии: " + figure.getLineThickness());
        }
    }
}
