package item;

public class Item {
    private String name;
    private String description;
    private ItemType itemType;


    public Item(String name, String description, ItemType itemType) {
        this.name = name;
        this.description = description;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public String toString() {
        return "item.item.Item" +
                " name '" + name + '\'' +
                ", description -'" + description +
                "item.item.Item Type: " + itemType;
    }
}
