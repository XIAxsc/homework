package main.java.day10;

public class Demo4 {
    public static void main(String[] args) {
        Son s1 = new Son();
        Son s2 = new Son(1, 2, 3, 30);
        Son s3 = new Son(1, 10, 2, 20, 3, 30);
        System.out.println("s1.sA = " + s1.sA);
        System.out.println("s1.fA = " + s1.fA);
        System.out.println("s1.gA = " + s1.gA);
        System.out.println("s1.a = " + s1.a);
        s1.test();
        s1.testSon();
        s1.testFather();
        s1.testGrand();

        System.out.println("s2.sA = " + s2.sA);
        System.out.println("s2.fA = " + s2.fA);
        System.out.println("s2.gA = " + s2.gA);
        System.out.println("s2.a = " + s2.a);
        s2.test();
        s2.testSon();
        s2.testFather();
        s2.testGrand();

        System.out.println("s3.sA = " + s3.sA);
        System.out.println("s3.fA = " + s3.fA);
        System.out.println("s3.gA = " + s3.gA);
        System.out.println("s3.a = " + s3.a);
        s3.test();
        s3.testSon();
        s3.testFather();
        s3.testGrand();

    }
}

class Grandfather {
    int gA;
    int a;

    public Grandfather() {
    }

    public Grandfather(int gA) {
        this.gA = gA;
    }

    public Grandfather(int gA, int a) {
        this.gA = gA;
        this.a = a;
    }

    public void testGrand() {
        System.out.println("Grandfather：testGrand");
    }

    public void test() {
        System.out.println("Grandfather：test");
    }
}

class Father extends Grandfather {
    int fA;
    int a;

    public Father() {
    }

    public Father(int gA, int fA) {
        super(gA);
        this.fA = fA;
    }

    public Father(int gA, int a, int fA, int a1) {
        super(gA, a);
        this.fA = fA;
        this.a = a1;
    }

    public void testFather() {
        System.out.println("Person：testFather");
    }

    public void test() {
        System.out.println("Person：test");
    }
}

class Son extends Father {
    int sA;
    int a;

    public Son() {
    }

    public Son(int gA, int fA, int sA, int a) {
        super(gA, fA);
        this.sA = sA;
        this.a = a;
    }

    public Son(int gA, int a, int fA, int a1, int sA, int a2) {
        super(gA, a, fA, a1);
        this.sA = sA;
        this.a = a2;
    }

    public void testSon() {
        System.out.println("Son：testSon");
    }

    public void test() {
        System.out.println("Son：test");
    }
}