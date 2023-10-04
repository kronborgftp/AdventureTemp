package item;

public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String name, String description) {
        super(name, description, ItemType.WEAPON);
    }

    @Override
    public void use() {
        System.out.println("You attacked with " + getName() + ".");
    }
}
