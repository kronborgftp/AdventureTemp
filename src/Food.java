public class Food extends Item{

    private int healthPoints;
    public Food(String name, String description, int healthPoints) {
        //inherit from item class
        super(name, description);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
