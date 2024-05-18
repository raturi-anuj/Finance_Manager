import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Item>inventory;

    public InventoryManager(){
        this.inventory=new ArrayList<>();
    }
    
    public void addItem(Item item){
        inventory.add(item);
    }

    public void updateItemQuantity(String id, int newQuantity){
        for(Item item : inventory){
            if(item.getId().equals(id)){
                item.setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void removeItem(String id){
        inventory.removeIf(item -> item.getId().equals(id));
    }

    public List<Item> getInventory(){
        return inventory;
    }

    public Item searchItem(String id){
        for(Item item : inventory){
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public String generateReport(){
        StringBuilder report = new StringBuilder();
        report.append("Inventory Report:\n");
        report.append("=================\n");
        for(Item item : inventory){
            report.append(item.toString()).append("\n");
        }
        return report.toString();
    }   
}
