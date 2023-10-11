package item;

public class MeleeWeapon extends Weapon {
    private int minDamage;
    private int maxDamage;

    public MeleeWeapon(String name, String description, int minDamage, int maxDamage) {
        super(name, description, ItemType.WEAPON);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public int calculateDamage() {
        // Calculate damage within the specified range
        return minDamage + (int) (Math.random() * ((maxDamage - minDamage) + 1));
    }

    @Override
    public void use() {
        System.out.println("You attacked with " + getName() + ".");
    }
}
