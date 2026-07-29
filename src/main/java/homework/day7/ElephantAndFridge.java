package homework.day7;

public class ElephantAndFridge {

    public static void main(String[] args) {

        // 1. 创建大象对象
        Elephant elephant = new Elephant("北鼻", "1000KG");

        // 2. 创建冰箱对象
        Fridge fridge = new Fridge("海尔冰箱");

        // 3. 打开冰箱门
        fridge.openDoor();

        // 4. 把大象放进冰箱
        fridge.putElephant(elephant);

        // 5. 关闭冰箱门
        fridge.closeDoor();

    }

}

class Fridge{

    String brand; // 品牌

    // 大象
    Elephant elephant;

    // 冰箱的状态
    boolean open = false;

    public Fridge(String brand) {
        this.brand = brand;
    }

    // 方法 打开冰箱门
    public void openDoor(){
        this.open = true;
        System.out.println("打开冰箱门...");
    }

    // 方法 把大象装进冰箱
    public void putElephant(Elephant elephant){
        if (this.open) {
            this.elephant = elephant;
            System.out.println("把大象装进冰箱");
        }else {
            System.out.println("冰箱门是关着的，无法放入大象");
        }
    }

    // 方法 关闭冰箱门
    public void closeDoor(){
        this.open = false;
        System.out.println("关闭冰箱门");
    }


}

class Elephant{

    String name;
    String weight;


    public Elephant(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }
}