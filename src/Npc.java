public class Npc {
    String name;
    int age;
    String sex;
    double height;
    double weight;
    int strength;
    int Dexterity;
    int Constitution;
    int Intelligence;
    int Wisdom;
    int Charisma;
    Bag bagN;

    public Npc(String name, int age, String sex, double height, double weight, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Bag bagN) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        Dexterity = dexterity;
        Constitution = constitution;
        Intelligence = intelligence;
        Wisdom = wisdom;
        Charisma = charisma;
        this.bagN = bagN;
    }

    public Npc() {
    }



    private void printNpc() {
        System.out.println("Npc name: " + name);
        System.out.println("Npc age: " + age);
        System.out.println("Npc sex: " + sex);
        System.out.println("Npc height: " + height);
        System.out.println("Npc weight: " + weight);
        System.out.println("Npc strength: " + strength);
        System.out.println("Npc Dexterity: " + Dexterity);
        System.out.println("Npc Constitution: " + Constitution);
        System.out.println("Npc Intelligence: " + Intelligence);
        System.out.println("Npc Wisdom: " + Wisdom);
        System.out.println("Npc Charisma: " + Charisma);
    }

    public void attack(Npc target) {
        System.out.println(name + " attacks " + target.name);
    }

    public static void main(String[] args) {
        Npc npc1 = new Npc("Adventurer", 20, "Male", 1.8, 70, 10, 12, 14, 16, 18, 20, new Bag());
        npc1.bagN = new Bag(5,npc1);

        npc1.bagN.addItemBag("Sword");
        npc1.bagN.addItemBag("Shield");
        npc1.bagN.printBag();
        npc1.bagN.removeItemBag("Sword");
        npc1.bagN.printBag();
        npc1.bagN.addItemBag("Shield");
        npc1.bagN.printBag();
        npc1.printNpc();
    }
}