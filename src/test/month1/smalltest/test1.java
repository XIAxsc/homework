package test.smalltest;

class car {
    String color = "黑色";
    double speed = 120.0;

    public void run() {
        System.out.println(color + "的车在高速上以" + speed + "公里每小时的速度行驶中。");
    }

    public void run(double speed) {
        System.out.println(color + "的车在高速上以" + speed + "公里每小时的速度行驶中。");
    }

    public void printThis() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "car{" +
                "color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }

    public car() {
    }

    public car(String color, double speed) {
        this.color = color;
        this.speed = speed;
    }
}


public class test1 {
    public static void main(String[] args) {
        car car = new car();
        car c1 = new car("yellow", 120);
        System.out.println("c1.toString() = " + c1);
        car.run();
        car.run(200);
        car.printThis();
        System.out.println(car);
        System.out.println(Thread.currentThread().getName());
    }
}
