import java.util.List;

public class Bag {
    private int size;
    List<String> items;
    Npc npcB;

    public Bag(int i, Npc npc) {
        size = i;
        items = new java.util.ArrayList<>();
        npcB = npc;
    }

    public Bag() {
    }

    public void addItemBag(String item) {
        if (items.size() >= size) {
            System.out.println("Bag is full");
            return;
        }
        items.add(item);
        System.out.println("Add item " + item + " to " + npcB.name + "'s bag");
    }

    public void removeItemBag(String item) {
        if (!items.contains(item)) {
            System.out.println("Item not found");
            return;
        }
        items.remove(item);
        System.out.println("Remove item " + item + " from " + npcB.name + "'s bag");
    }

    public void printBag() {
        System.out.println("Bag items: " + items);
    }
}
