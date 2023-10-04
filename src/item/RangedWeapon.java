package item;


public class RangedWeapon  extends Weapon {
    private int ammunition;

    public RangedWeapon(String name, String description, int ammunition) {
        super(name, description, ItemType.WEAPON);
        this.ammunition = ammunition;
    }

    public int getAmmunition() {
        return ammunition;
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
}
