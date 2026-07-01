package month1.day14;

public class Demo2 {
    public static void main(String[] args) {
        Animals animal1 = new Animals(10, "小黑", 10000);
        Animals animal2 = new Animals(11, "小白", 9999);
        Animals animal3 = new Animals(10, "小黑", 10000);

        System.out.println(animal1.equals(animal2));
        System.out.println(animal2.equals(animal3));
        System.out.println(animal1.equals(animal3));

        System.out.println();

        Dog dog = new Dog(11, "小白", 9999);
        System.out.println(dog.equals(animal2));
        System.out.println(animal2.equals(dog));
    }
}

class Animals {
    int age;
    String name;
    double price;

    public Animals(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if(this == o){
    //         return true;
    //     }
    //     if(this.getClass() != o.getClass()){
    //         return false;
    //     }
    //     Animals animal = (Animals) o;
    //     return this.age == animal.age && this.name.equals(animal.name) && this.price == animal.price;
    // }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Animals animal) {
            return this.age == animal.age && this.name.equals(animal.name) && this.price == animal.price;
        }
        return false;

    }
}
class Dog extends Animals{

    public Dog(int age, String name, double price) {
        super(age, name, price);
    }
}
