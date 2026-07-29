package homework.day11;

public class Demo1 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 20);
        Circle c = new Circle(3);
        System.out.println("长方形的周长： " + r.perimeter());
        System.out.println("长方形的面积： " + r.area());

        System.out.println("圆的周长： " + c.perimeter());
        System.out.println("圆的面积： " + c.area());
    }
}

abstract class Shape {
    abstract double perimeter();

    abstract double area();
}

class Rectangle extends Shape {
    double length;
    double weight;

    public Rectangle(double length, double weight) {
        this.length = length;
        this.weight = weight;
    }

    @Override
    public double area() {
        return length * weight;
    }

    @Override
    public double perimeter() {
        return (length + weight) * 2;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}