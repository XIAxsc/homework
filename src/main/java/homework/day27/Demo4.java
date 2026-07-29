package homework.day27;

public class Demo4 {
    public static void main(String[] args) {
        Triple<Integer, String, Double> triple = new Triple<>();
        triple.setData1(114514);
        triple.setData2("坤坤");
        triple.setData3(4396D);

        System.out.println("triple = " + triple);
    }
}

class Triple<A, B, C> {
    A data1;
    B data2;
    C data3;

    public void setData1(A data1) {
        this.data1 = data1;
    }

    public void setData2(B data2) {
        this.data2 = data2;
    }

    public void setData3(C data3) {
        this.data3 = data3;
    }

    public A getData1() {
        return data1;
    }

    public B getData2() {
        return data2;
    }

    public C getData3() {
        return data3;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "data1=" + data1 +
                ", data2=" + data2 +
                ", data3=" + data3 +
                '}';
    }
}
