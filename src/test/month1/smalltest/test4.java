package test.smalltest;

public class test4 {
    public static void main(String[] args) {
        Father cf = new Son();
        System.out.println(cf.age);
        cf.teach();
        // cf.playGame(); 不能打游戏，因为父类没这个成员
        Son c = (Son) cf;
        System.out.println(c.age);
        c.playGame();
    }
}

class Father {
    int age = 48;

    public void teach() {
        System.out.println("我要教Java");
    }
}

class Son extends Father {
    int age = 28;

    public void playGame() {
        System.out.println("孔子喜欢玩大乱斗！");
    }

    @Override
    public void teach() {
        System.out.println("我会教论语");
    }
}