package item;

public class Food extends Item {

    private int healthPoints;


    public Food(String name, String description, int healthPoints, ItemType itemType ) {
        //inherit from item class
        super(name, description, itemType);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
