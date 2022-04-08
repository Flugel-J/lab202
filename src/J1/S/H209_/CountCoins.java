
package J1.S.H209_;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class CountCoins {
    static double total=0.0;
    public static void count(String s) throws NumberFormatException{
        String[] coins= s.split("\\s+");
        for(int i=1; i<coins.length;i++){
            
            switch(coins[i].toLowerCase()){
                case "pennies":
                    total+= Double.parseDouble(coins[i-1]);
                    break;
                case "nickels":
                    total+=Double.parseDouble(coins[i-1])*5;
                    break;
                case "dimes":
                    total+= Double.parseDouble(coins[i-1])*10;
                    break;
                case "quarters":
                    total+= Double.parseDouble(coins[i-1])*25;
                    break;
            }
            }
            
        }
    
    public static void main(String[] args) {
        String data="";
        try {
            File myFile = new File("CountCoins.txt");
            if(myFile.exists()){
                Scanner Coins = new Scanner(myFile);
                while (Coins.hasNextLine()) {
                    data += Coins.nextLine();
                }
                Coins.close();
                count(data);
                System.out.println("Total money: $"+total/100);
            }
        }    
        catch (FileNotFoundException e ) {
            System.out.println("Cant find file");
        }
        catch(NumberFormatException e){
            System.out.println("File cant read");
        }    
        
    
    }
}
