
package J1.S.P0057;


import java.io.IOException;
 

public class Main {
    public static void main(String[] args) {
        try{
            Management list= new Management();
            String choice = "";
            list.readFromFile("user.dat");
            System.out.println("=======USER MANAGEMENT SYSTEM=======");
            System.out.println("1.Create a new account");
            System.out.println("2.Login System");
            System.out.println("3.Exit");
            while(!choice.equals("3")){
                choice= list.input("Enter choice:","^[1-3]{1}", "Error!");
                switch(choice){
                    case "1":
                        list.createAcc();
                       
                        break;
                    case "2":
                        list.login();
                        
                        break;
                    default:
                        break;
                }
            }
            list.addToFile("user.dat");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }
    }
}    

