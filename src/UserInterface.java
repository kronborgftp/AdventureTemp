import item.Item;
import item.Weapon;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner keyboard = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();
    }

    public void startProgram() {
        adventure.initializeGame();

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("""
                ---------------------------------------|
                 - Type 'Help' to show instructions    |
                 - Type 'Start' to start the game      |
                 - Type 'Exit' to exit the game        |
                ---------------------------------------|
                """);

        String userSelection = keyboard.nextLine();

        switch (userSelection.toLowerCase()) {
            case "help":
                help();
                break;
            case "start":
                startGame();
                break;
            case "exit":
                System.out.println("Have a great day");
                System.exit(0);
                break;
            default:
                System.out.println("Choose an option from above");
                break;
        }
    }

    public void startGame() {
        boolean firstLook = true;

        while (true) {
            Room currentRoom = adventure.getCurrentRoom();

            System.out.println(currentRoom.getDescription());

            if (firstLook) {
                System.out.println("Search the room for items: type 'look'");
                firstLook = false;
            }

            System.out.println("Enter a command:");
            String userInput = keyboard.nextLine().toLowerCase();

            if (userInput.equals("look")) {
                userLook();
            } else if (userInput.startsWith("pick up ")) {
                playerPickUpItem(userInput);
            } else if (userInput.startsWith("drop ")) {
                playerDropItem(userInput);
            } else if (userInput.startsWith("eat ")) {
                playerEatFood(userInput);
            } else if (userInput.equals("help")) {
                help();
            } else if (userInput.startsWith("equip")) {
                equipWeapon(userInput);
            } else if (userInput.startsWith("unequip")) {
                unequipWeapon();
            }else if (userInput.equals("attack")) {
                attack();
            }else if (userInput.equals("show inventory")) {
                showInventory();
            } else if (userInput.equals("exit")) {
                System.out.println("Goodbye");
                System.exit(0);
            } else if (userInput.startsWith("go ")) {
                String direction = userInput.substring(3);
                adventure.move(direction);
            } else if (userInput.equals("n") || userInput.equals("w") || userInput.equals("e") || userInput.equals("s")) {
                String direction = userInput;
                adventure.move(direction);
            } else {
                System.out.println("Invalid command");
            }
        }
    }


    public void help() {
        System.out.println("== Help Menu ==");
        System.out.println("Basic Needs:");
        System.out.println("- Water: Stay hydrated during your adventure.");
        System.out.println("- Light: Illuminate dark areas.");
        System.out.println("- First Aid Kit: Use it to heal injuries.");
        System.out.println("- Snack: Restore your energy.");

        System.out.println("Tools and Weapons:");
        System.out.println("- Sword: Use for close combat.");
        System.out.println("- Bow and Arrow: Attack enemies from a distance.");
        System.out.println("- Shield: Provides defense against enemy attacks.");

        System.out.println("Navigation:");
        System.out.println("- N: Go North");
        System.out.println("- E: Go East");
        System.out.println("- S: Go South");
        System.out.println("- R: Go Right");

    }

    private void userLook() {
        Room currentRoom = adventure.getCurrentRoom();
        List<Item> itemsInRoom = currentRoom.getItems();

        if (!itemsInRoom.isEmpty()) {
            System.out.println("Items in this room:");
            for (Item item : itemsInRoom) {
                System.out.println(item.getName());
            }
        } else {
            System.out.println("There are no items in this room.");
        }
    }

    private void playerPickUpItem(String userInput) {
        String itemName = userInput.substring(8);
        Item itemToPickUp = adventure.getCurrentRoom().getItemByName(itemName);

        if (itemToPickUp != null) {
            adventure.getPlayer().pickUpItem(itemToPickUp);

            // Check if the picked up item is a weapon and equip it
            if (itemToPickUp instanceof Weapon) {
                System.out.println("You picked up " + itemName + " and added it to your inventory.");
            } else {
                System.out.println("You picked up " + itemName);
            }
        } else {
            System.out.println("Item not found in this room");
        }
    }


    private void playerDropItem(String userInput) {
        String itemName = userInput.substring(5);
        Player player = adventure.getPlayer();
        player.dropItem(itemName, adventure.getCurrentRoom());
    }

    private void showInventory() {
        System.out.println("Inventory:");
        for (Item item : adventure.showInventory()) {
            if (item != null) {
                System.out.println(item.getName());
            }
        }
    }

    private void playerEatFood(String userInput) {
        String foodName = userInput.substring(4);
        adventure.getPlayer().eat(foodName);
    }

    private void equipWeapon(String userInput) {
        String weaponName = userInput.substring(6).trim();
        Player player = adventure.getPlayer();
        player.equipWeapon(weaponName);

    }

    private void unequipWeapon() {
        Player player = adventure.getPlayer();
        player.unequipWeapon();
    }

    private void attack() {
        Weapon equippedWeapon = adventure.getPlayer().getEquippedWeapon();

        if (equippedWeapon != null) {
            equippedWeapon.use();
        } else {
            System.out.println("You don't have a weapon equipped.");
        }
    }

}
