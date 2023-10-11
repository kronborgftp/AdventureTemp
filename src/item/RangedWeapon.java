package item;


public class RangedWeapon extends Weapon {
    private int minDamage;
    private int maxDamage;
    private int ammunition;

    public RangedWeapon(String name, String description, int minDamage, int maxDamage, int ammunition) {
        super(name, description, ItemType.WEAPON);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.ammunition = ammunition;
    }


    public void decreaseAmmunition() {
        ammunition--;
    }

    @Override
    public void use() {
        if (ammunition > 0) {
            System.out.println("You used a shot from " + getName() + ". Ammunition left: " + ammunition);
            decreaseAmmunition();
        } else {
            System.out.println("Out of ammunition for " + getName() + ".");
        }
    }

    @Override
    public int calculateDamage() {
        if (ammunition > 0) {
            // Reduce ammunition and calculate damage within the specified range
            ammunition--;
            return minDamage + (int) (Math.random() * ((maxDamage - minDamage) + 1));
        } else {
            System.out.println("Out of ammunition!");
            return 0;
        }
    }
}
