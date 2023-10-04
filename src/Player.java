import item.Food;
import item.Item;
import item.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> inventory;
    private int maxInventorySize;
    private int health;
    private Weapon equippedWeapon;


    //added inventory to represent the player inventory size
    public Player(Room startingRoom, int maxInventorySize, int health) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
        this.maxInventorySize = maxInventorySize;
        this.health = health;
    }

    //Check the items in the currentRoom before adding them to the inventory
    public void pickUpItem(Item item) {
        if (currentRoom.containsItem(item)) {
            if (inventory.size() < maxInventorySize) {
                inventory.add(item);
                currentRoom.removeItem(item);
                System.out.println("You picked up " + item.getName() + ".");
            } else {
                System.out.println("Your inventory is full.");
            }
        } else {
            System.out.println("Item not found in this room.");
        }
    }



    //Allows the player to drop the item, and add the item to the current room.
    public void dropItem(String itemName, Room currentRoom) {
        Item itemToDrop = null;
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToDrop = item;
                break;
            }
        }

        if (itemToDrop != null) {
            inventory.remove(itemToDrop);
            currentRoom.addItem(itemToDrop);
            System.out.println("You dropped " + itemName + " in " + currentRoom.getName());
        } else {
            System.out.println("You don't have the item " + itemName + " in your inventory.");
        }
    }

    public void eat(String foodName) {
        //get food from the current room
        Food food = currentRoom.getFoodByName(foodName);

        if (food != null) {
            //get health-points from the food
            int healthChange = food.getHealthPoints();

            if(healthChange > 0) {
                System.out.println("You ate " + foodName + " And gained" + healthChange + " health points");
            } else if (healthChange < 0) {
                System.out.println("Oops! " + foodName + " was poisonous. You lost " + Math.abs(healthChange) + " health points.");
            }

            //changes health
            changeHealth(healthChange);
            //removes food from the room
            currentRoom.removeItem(food);
        } else {
            System.out.println("No such food in this room");
        }
    }

    private void changeHealth(int healthChange) {

        health += healthChange; // Update player's health based on healthChange

        // Ensure that health doesn't go below 0 or exceed 100
        health = Math.max(0, Math.min(100, health));

        System.out.println("Player's health: " + health); // Print player's updated health
    }

    //retrieves the currentroom of the player
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public Weapon getWeaponByName(String weaponName) {
        for (Item item : inventory) {
            if (item instanceof Weapon && item.getName().equalsIgnoreCase(weaponName)) {
                return (Weapon) item;
            }
        }
        return null;
    }

    //Use weapon

    public void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void move(String direction) {
        Room nextRoom = null;

        switch (direction) {
            case "north":
            case "n":
                nextRoom = currentRoom.getNorth();
                break;
            case "east":
            case "e":
                nextRoom = currentRoom.getEast();
                break;
            case "west":
            case "w":
                nextRoom = currentRoom.getWest();
                break;
            case "south":
            case "s":
                nextRoom = currentRoom.getSouth();
                break;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.println("You cannot go that way.");
        }
    }
    public List<Item> showInventory()
    {
        return inventory;
    }

    public List<Item> look () {
        return currentRoom.getItems();
    }


}




