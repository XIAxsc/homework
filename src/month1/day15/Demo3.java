package month1.day15;

public class Demo3 {
    public static void main(String[] args) {

        Season season1 = Season.Spring;
        Season season2 = Season.Summer;
        Season season3 = Season.Autumn;
        Season season4 = Season.Winter;
        switch (season3){
            case Spring:
                System.out.println("春天到了，到了动物繁殖的季节");
                break;
            case Autumn:
                System.out.println("夏天到了，到了植物繁殖的季节");
                break;
            case Summer:
                System.out.println("秋天到了，到了果物繁殖的季节");
                break;
            case Winter:
                System.out.println("冬天到了，到了死物繁殖的季节");
                break;
        }
    }
}
enum Season{

    Spring("春天"),
    Summer("夏天"),
    Autumn("秋天"),
    Winter("冬天"),

    ;
    String name;

    Season(String name) {
        this.name = name;
    }
}