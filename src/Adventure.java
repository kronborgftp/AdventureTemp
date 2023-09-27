public class Adventure {
    private Player player;
    private Map map;

    public Adventure() {
        this.map = new Map();
        this.player = new Player(map.getStartingRoom());

        initializeGame();
    }

    public void initializeGame() {
        player.setCurrentRoom(map.getStartingRoom());
    }

    public void move(String direction){
        this.player.move(direction);
    }

    public Room getCurrentRoom() {
        if (player != null) {
            return player.getCurrentRoom();
        } else {
            System.out.println("Player is not properly initialized.");
            return null;
        }
    }
}
