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

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void attack(Player player) {
        int damage = equippedWeapon.calculateDamage(); // Implement this method in Weapon class
        player.takeDamage(damage);
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


