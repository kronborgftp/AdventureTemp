import item.*;


public class Map {
    private Room startingRoom;

    public Map() {
        Room room1 = new Room(" ", "You are standing in a cave, you hear the water silently dripping from above. \n" +
                "You can see a dim light to one side of you, and hear water running in a distance. Which way would you like to go?");
        Item food1Room1 = new Food("apple", "extremely delicious", 20, ItemType.FOOD);
        room1.addItem(food1Room1);
        Weapon goblinWeapon = new MeleeWeapon("Sword", "small and pointy", 5, 15);
        Enemy enemy1 = new Enemy("Goblin", "Ugly", 30, goblinWeapon);
        room1.addEnemy(enemy1);

        Room room2 = new Room(" ", "You can see the remains of a fire and the embers glowing in the dark.\n" +
                " You discover footsteps going further in to the cave. Which way would you like to explore?");
        Item meleeWeapon = new MeleeWeapon("Sword", "A sharp sword", 5, 50);
        room2.addItem(meleeWeapon);
        Weapon skeletonWeapon = new MeleeWeapon("Bones", "Pointy bones", 8, 15);
        Enemy enemy2 = new Enemy("Skeleton", "Scary", 40, skeletonWeapon);
        room2.addEnemy(enemy2);

        Room room3 = new Room(" ", "You stop and see that you are standing on edge of a cliff, \n " +
                "and you need to cross a wooden bridge to get over to the other side. Would you like to go across or in another direction?");
        Item food2Room3 = new Food("Mushroom", "funky looking", -40, ItemType.FOOD);
        room3.addItem(food2Room3);

        Room room4 = new Room(" ", "You have followed the sound of water, and now you are standing on a riverbank.\n" +
                "You see a small boat floating around. The boat seems rather broken, would you like to try to get to the other side or explore another direction?");
        Item item2Room4 = new Item("paddle", "an old rotten paddle.", ItemType.TOOL);
        room4.addItem(item2Room4);
        Item food3Room4 = new Food("seaweed", "tasty.. not", 1, ItemType.FOOD);
        room4.addItem(food3Room4);

        Room room5 = new Room(" ", "You have entered a great cave with a big lake covered in shimmering light.\n " +
                "Three stones leads the way to the center of the lake, where you see a big chest with a big rusty lock on it. \n" +
                "Which way would like to go?");
        Item food4Room5 = new Food("bær", "Blå glimtende ", -80, ItemType.FOOD);
        room5.addItem(food4Room5);

        Room room6 = new Room(" ", "You are now going down a small path, there is suspeciously quit. The darkness is overwhelming you can't see\n" +
                " see anything, and you feel your way through the darkness. You suddenly feel a wooden box, and it seems like the path splits up in serveal directions\n" +
                "which way would you to go?");
        Item item3Room6 = new Item("Key", "A rusty old key.", ItemType.TOOL);
        room6.addItem(item3Room6);

        Room room7 = new Room(" ", "You are now standing on the riverbank. Suddenly you notice a silent sound of drums. \n" +
                "The sound of the drums get louder and louder. You can't quite hear where the sound is comming from. Nearby in the river something is floating around. \n" +
                "Which way would you like to go?");
        Item rangedWeapon = new RangedWeapon("Bow", "A powerful bow", 10, 30, 10);
        room1.addItem(rangedWeapon);

        //DET STORE FARLIGE RUM!! :O :O :O :O
        Room room8 = new Room(" ", "You feel a sudden heat, and starts to sweat. You look down and see lava floating \n" +
                "around you, dangerously close. There are stones floating around like an iced sea. Where would you like to go?");
        Item food5Room8 = new Food("Ice cream", "cold and refreshing", 20, ItemType.FOOD);
        room8.addItem(food5Room8);
        Weapon bossWeapon = new MeleeWeapon("Fire breath", "Enormous flames", 1, 100);
        Enemy enemyBoss = new Enemy("Bowser", "From mario", 1000, bossWeapon);
        room8.addEnemy(enemyBoss);

        Room room9 = new Room(" ", "You are now deep into the cave, you have to climb up a steep hill to go west. \n " +
                "Can you take the climp, or go in another direction?");
        Item item5Room9 = new Item("Boots", "boots with an exceptional grip", ItemType.TOOL);
        room9.addItem(item5Room9);


        startingRoom = room1;

        room1.setEast(room2);
        room1.setSouth(room4);

        //room2
        room2.setWest(room1);
        room2.setEast(room3);

        //room3
        room3.setSouth(room6);
        room3.setWest(room2);

        //room6
        room6.setNorth(room3);
        room6.setSouth(room9);

        //room9
        room9.setWest(room8);
        room9.setNorth(room6);

        //room8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        //room7
        room7.setEast(room8);
        room7.setNorth(room4);

        //room4
        room4.setSouth(room7);
        room4.setNorth(room1);

    }

    //Getter for startingroom
    public Room getStartingRoom() {
        return startingRoom;
    }

}
