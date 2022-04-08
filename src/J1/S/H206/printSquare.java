/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H206;
import java.util.Scanner;
import java.util.LinkedList;
/**
 *
 * @author dell
 */
public class printSquare {
    static Scanner sc = new Scanner(System.in);
     public static int Input(String msg, int min, int max){
       int data=min-1;
        do{
            try{
            System.out.println(msg);
            data = Integer.parseInt(sc.nextLine().trim());
            }
            catch(Exception e){
                System.out.println("Please enter integer value!");
            }
        } while(data<min || data>max);
        
        return data;
    }
    
    public static void printSquare(int min, int max){
            LinkedList list= new LinkedList<>();
            
            for (int i = min; i <= max; i++) {
               list.add(i);
            }
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(0));
                for(int j = 1; j<list.size(); j++){
                    System.out.print(Math.abs(list.get(j).hashCode()));
                }
                System.out.println();
                list.addLast(list.getFirst());
                list.removeFirst();
            }    
    }
    public static void main(String[] args){
            int min=Input("Enter min value:", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int max=Input("Enter max value(max>min):", min,Integer.MAX_VALUE );
        
        
        printSquare(min, max);
    }
}    

   
