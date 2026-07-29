package main.java.day10;

public class Demo1 {
    public static void main(String[] args) {
        Square s1 = new Square();
        s1.setSide(4);
        System.out.println("s1周长 = " + s1.perimeter());
        System.out.println("s1面积 = " + s1.area());
        System.out.println("s1边长 = " + s1.getSide());

        Rectangle r1 = new Rectangle();
        r1.setLength(10);
        r1.setWeight(5);
        System.out.println("r1周长 = " + r1.perimeter());
        System.out.println("r1面积 = " + r1.area());
        System.out.println("r1长 = " + r1.getLength());
        System.out.println("r1宽 = " + r1.getWeight());
    }
}
class Square{
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public int area(){
        return side * side;
    }

    public int perimeter(){
        return 4 * side;
    }
}
class Rectangle{
    private int length;
    private int weight;

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }

    public int area(){
        return length * weight;
    }

    public int perimeter(){
        return (length + weight)*2;
    }
}
