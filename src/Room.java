
import item.Food;
import item.Item;
import item.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private List<Item> items;
    private List<Enemy> enemies;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    //getter for items in the room
    public Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // item.Item not found in this room
    }

    public Food getFoodByName(String foodName) {
        for (Item item : items) {

            //checks if the current item is an instance of the food class. Ensures that we are looking for food
            if (item instanceof Food && item.getName().equalsIgnoreCase(foodName)) {
                return (Food) item;
            }
        }

        return null;
    }

    //may be used later
    public Weapon getWeaponByName(String weaponName) {
        for (Item item : items) {
            if (item instanceof Weapon && item.getName().equalsIgnoreCase(weaponName)) {
                return (Weapon) item;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public boolean containsItem(Item item) {
        return items.contains(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }


}