
package J1.L.P0023;

import java.util.ArrayList;
import java.util.Hashtable;
public class FruitList {
    public static ArrayList<Fruit>f = new ArrayList<>();
    public static Hashtable<String, ArrayList<Fruit>> table = new Hashtable<>();
    static int bill=0;
    public static int searchId(String id) {
        for (Fruit fruit : f) {
            if (id.equals(fruit.getId())) {
                return f.indexOf(fruit);
            }
        }
        return -1;
    }
    public static void createFruit(String newId){
        while(Input.Continue("Choose to create fruit. Do you want to continue?(Y/N)")){
            String newName, newOrigin;
            int newQuantity,i; double newPrice;
            if(newId==""){
                do{
                    newId= Input.inputstring("Enter ID:", true);
                    i=searchId(newId);
                    if(i!=-1){
                        System.out.println("ID is duplicate!");
                    }   
                }while(i!=-1);
            }
            //input
            newName = Input.inputstring("Enter fruit name:", true);
            newPrice = Input.inputDouble("Enter price:");
            newQuantity = Input.inputInt("Enter quantity:", 1, Integer.MAX_VALUE, "Quantity shouldnt be 0 or below!");
            newOrigin = Input.inputstring("Enter Origin:", false);
            f.add( new Fruit(newId, newName, newPrice, newQuantity, newOrigin));  
          }
      
    }
    
    public static int listFruit(){
        int count=0;
        System.out.printf("%15s%15s%15s%15s%15s\n", "No", "Fruit Name","Price", "Quantity", "Origin");
        for (Fruit fruit : f) {
            if (fruit.getQuantity() != 0) {
                count++;
                System.out.printf("%15s%15s%15.1f%15d%15s\n", count, fruit.getName(), fruit.getPrice(),fruit.getQuantity(), fruit.getOrigin());
            }
        }
        return count;
    }
    public static void updateFruit(){
        if(f.isEmpty()){
            System.out.println("List empty!"); 
        }
        else{ 
            do{
                Fruit update = null;
                String Id= Input.inputstring("Enter ID:", true);
                update = f.get(searchId(Id));
                if(update!=null){
                    System.out.println("ID: "+update.getId()+" Fruit Name: "+update.getName()+" Origin: "+update.getOrigin()+" Price: "+update.getPrice()+" Quantity: "+update.getQuantity());
                    update.setName(Input.inputstring("New name is?", true));
                    update.setOrigin(Input.inputstring("New origin is?", false));
                    update.setPrice(Input.inputDouble("New price is?"));
                    update.setQuantity(Input.inputInt("New quantity is?", 0, Integer.MAX_VALUE,"Quantity shouldnt be 0 or below!"));
                    break;
                }
                else{
                    System.out.println("ID not exist!");
                    createFruit(Id);
                }
            }while(Input.Continue("Do you want to continue update Fruit?(Y/N)"));
                
                }
    }    
    
    
    //*************************************************************************************************************************
    //user interface
   
    static void listOrder(ArrayList<Fruit> x) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit order : x) {
            System.out.printf("%15s%15d%15.1f%15.1f\n", order.getName(), order.getQuantity(), order.getPrice(), order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.printf("Total: %.1f",total);
    }
     static Fruit real(int input){
        int index = 0;
        for (Fruit fruit : f){
            if(fruit.getQuantity()!=0)
                index++;
            
            if(index==input)
                return fruit;
        }
        return null;
    }
    public static void shopping() {
        //check list empty
        
        //buy
        ArrayList<Fruit> s = new ArrayList<>();
        while (true){
            int No; int total=listFruit();
            if (total==0) {
                System.out.println("Dont have item.");
                return;
            }
            Fruit buy;
                No= Input.inputInt("Enter number you want to add to cart:", 1,total, "number not found");
                buy=real(No);
            int quantity = Input.inputInt("Enter quantity: ", 0, buy.getQuantity(), "Insufficent item!");
            buy.setQuantity(buy.getQuantity() - quantity);
            s.add(new Fruit(buy.getId(), buy.getName(),buy.getPrice(), quantity,  buy.getOrigin()));
            
            if (Input.Continue("Do you want to order now?")){
                break;
            }
        }
        listOrder(s);// overwrite order?
        bill++;
        String name = Input.inputstring("Enter name:", true)+"|"+Integer.toString(bill);
        table.put(name, s);
        System.out.println("Thank for your bussiness!");
    }
    static void viewOrder() {
        for (String name : table.keySet()) {
            String[] Name= name.split("|");
            
            System.out.println("Customer: " + Name[0]);
           
            listOrder(table.get(name));
        }
    }

}    
