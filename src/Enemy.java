import item.Weapon;

public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon equippedWeapon;


    public Enemy(String name, String description, int health, Weapon equippedWeapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.equippedWeapon = equippedWeapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void attackPlayer(Player player) {
        int damageDealt = equippedWeapon.calculateDamage();
        System.out.println("The " + name + " attacked you and dealt " + damageDealt + " damage.");
        player.takeDamage(damageDealt);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("The " + name + " has been defeated!");
        }
    }
}


