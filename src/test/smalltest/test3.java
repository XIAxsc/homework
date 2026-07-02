package test.smalltest;

// 父类手机
public class test3 {
    public static void main(String[] args) {
        // 多态场景：父类引用指向子类对象
        Phone phone1 = new Huawei();
        Phone phone2 = new XiaoMi();
        Phone phone3 = new Iphone();

        phone1.call();
        phone2.call();
        phone3.call();

        phone1.sendMessage();
        phone2.sendMessage();
        phone3.sendMessage();
    }
}

// 父类Phone
abstract class Phone {
    // 打电话方法
    public abstract void call();
    // 发信息方法
    public abstract void sendMessage();
}

// 华为子类
class Huawei extends Phone {
    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("华为手机发信息");
    }
}

// 小米子类
class XiaoMi extends Phone {
    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("小米手机发信息");
    }
}

// 苹果子类
class Iphone extends Phone {
    @Override
    public void call() {
        System.out.println("苹果手机打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("苹果手机发信息");
    }
}
