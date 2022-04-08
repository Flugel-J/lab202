package J1.S.H202_;

import java.util.*;


public class ReverseCharater {  
    public static String PrintReverseChar(String input){
        String reverse = "";
        for (int i =input.length()-1; i>=0; i--){
            reverse += input.charAt(i);
        }       
     
    return reverse;
    }
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        System.out.println("Enter String: ");
        String input = r.nextLine();
        if(!input.isEmpty()) {
            System.out.println(PrintReverseChar(input));
        }
    }
}

