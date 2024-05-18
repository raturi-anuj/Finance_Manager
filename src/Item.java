public class Item {
    private String id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    public Item(String id, String name, String descripton, int quantity, double price) {
        this.id =id;
        this.name = name;
        this.description = description;
        this.quantity=quantity;
        this.price=price;
    }

    public String getId(){ return id; }
    public String getName(){ return name; }
    public String getDescription(){ return description; }
    public int getQuantity(){ return quantity; }
    public double getPrice(){ return price; }

    public void setQuantity(int quantity){ this.quantity = quantity;}

    @Override
    public String toString(){
        return "Item{" + 
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
            '}';
    }
}