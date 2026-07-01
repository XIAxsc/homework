package month1.day6;

public class SaleItems {
    public static void main(String[] args) {
        Item phone = new Item();
        Item fridge = new Item();
        Item shampoo = new Item();

        phone.name = "Samsung Galaxy S21";
        phone.type = "手机类";
        phone.price = 8000;
        fridge.name = "海尔冰箱";
        fridge.type = "家具类";
        fridge.price = 3000;
        shampoo.name = "海飞丝洗发水";
        shampoo.type = "日用品类";
        shampoo.price = 30;

        int money = phone.sale(10000);
        int money2 = phone.sale(1000);
        int money3 = fridge.sale(20000);
        int money4 = fridge.sale(2000);
        int money5 = shampoo.sale(200);
        int money6 = shampoo.sale(20);


    }
}
class Item{
    String name;
    int price;
    String type;

    public int sale(int money){
        if(money >= price){
            System.out.println(name + "物品被卖出");
            return money - price;
        }
        System.out.println("金钱不足购买失败");
        return -1;
    }
}
