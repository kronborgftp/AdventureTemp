package item;

public abstract class Weapon extends Item {
    public Weapon(String name, String description, ItemType itemType) {
        super(name, description, itemType);
    }

    public void use() {
        System.out.println("You used the weapon: " + getName());
    }

    public abstract int calculateDamage();
}