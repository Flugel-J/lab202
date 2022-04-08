
package J1.L.P0023;
import java.util.Scanner;
public class Input {
     public static Scanner sc = new Scanner(System.in);
    
    public static int inputInt(String msg, int min, int max, String err){
        int data = min-1;
        do{
            try{
                System.out.println(msg);
            
                data = Integer.parseInt(sc.nextLine().trim());
                if(data<min || data>max){
                    System.out.println(err);
                }
            }
            catch(Exception e){
                System.out.println(err);
            }
        } while(data<min || data>max);
        
        return data;
    }
    public static double inputDouble(String msg) {
       
        double data=-1;
        do{
            try{
                System.out.println(msg);
                data = Double.parseDouble(sc.nextLine().trim());
            }
            catch(Exception e){
                System.out.println("Error!");
            }
        } while(data<0);
        
        return data;
    }

    public static String inputstring(String msg, boolean blank){
        String data = "";
        if(blank){
            while(data.length()==0){
                System.out.println(msg);
                data = sc.nextLine().trim();
            }
        }
        else{
            System.out.println(msg);
            data = sc.nextLine().trim();    
        }
        return data;
    }
    public static boolean Continue(String msg){
        String a; boolean con;
        while(true){
            a= inputstring(msg, true);
            if(a.equalsIgnoreCase("Y")){
                con=true;
                break;
            }
            if(a.equalsIgnoreCase("N")){
                con=false;
                break;
            }    
            else{
                System.out.println("Error!");                      
            }
        }
    return con;    
    }
}    
