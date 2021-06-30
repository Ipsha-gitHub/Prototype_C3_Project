import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        String openTime = openingTime.toString() , closeTime = closingTime.toString(), localTime = LocalTime.now().toString();
        String arrOpenTime[] = openTime.split(":"), arrCloseTime[] = closeTime.split(":"), arrLocalTime[] = localTime.split(":");
        String joinOpenTime = arrOpenTime[0] + arrOpenTime[1], joinCloseTime = arrCloseTime[0] + arrCloseTime[1], joinLocalTime = arrLocalTime[0] + arrLocalTime[1];
        int compareOpeningTime = Integer.parseInt(joinOpenTime) , compareClosingTime = Integer.parseInt(joinCloseTime);
        int compareLocaltime = Integer.parseInt(joinLocalTime);
        if(  compareLocaltime >= compareOpeningTime && compareLocaltime <= compareClosingTime){
            return true;
        }else{
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
