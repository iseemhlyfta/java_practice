import java.util.*;

abstract class Shape implements Comparable<Shape> {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double area();

    public abstract double perimeter();

    public int compareTo(Shape other) {
        return Double.compare(area(), other.area());
    }

    public String toString() {
        return String.format("%s: площадь = %.2f, периметр = %.2f", name, area(), perimeter());
    }
}

class Circle extends Shape {
    private double r;

    public Circle(double r) {
        super("Круг");
        this.r = r;
    }

    public double area() {
        return Math.PI * r * r;
    }

    public double perimeter() {
        return 2 * Math.PI * r;
    }
}

class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        super("Прямоугольник");
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a * b;
    }

    public double perimeter() {
        return 2 * (a + b);
    }
}

class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        super("Треугольник");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double perimeter() {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(3, 5));
        shapes.add(new Triangle(3, 4, 5));
        shapes.add(new Circle(1));
        shapes.add(new Rectangle(2, 2));

        System.out.println("До сортировки:");
        for (Shape s : shapes) {
            System.out.println(s);
        }

        double sum = 0;
        for (Shape s : shapes) {
            sum += s.area();
        }
        System.out.printf("Общая площадь: %.2f%n", sum);

        Collections.sort(shapes);
        System.out.println();
        System.out.println("После сортировки по площади:");
        for (Shape s : shapes) {
            System.out.println(s);
        }
    }
}
