
package J1.L.P0023;


public class Main {
    public static void main(String[] args) {
      
        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View list of Order");
            System.out.println("3. Update fruit");
            System.out.println("4. Shopping(for buyer)");
            System.out.println("5. Exit");
            
            int choice = Input.inputInt("Enter choice:", 1, 5, "Pls enter approriate choice!");
            switch (choice) {
                case 1:
                    FruitList.createFruit("");
                    break;
                case 2:
                   FruitList.viewOrder();
                    break;
                case 3:
                    FruitList.updateFruit();
                    break;
                case 4:
                    FruitList.shopping();
                    break;
                case 5:
                    return;
            }
          }
          
          
        
    }
}    
