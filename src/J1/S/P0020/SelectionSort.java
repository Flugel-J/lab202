/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0020;
import java.util.Scanner;

public class SelectionSort {
    static Scanner sc = new Scanner(System.in);
    public static int inputInt(String msg, int min, int max){
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
    public static int[] createArray(int size){
        
        int[] a=new int[size];
        for(int i=0;i<size;i++){
            a[i]= inputInt("Enter element "+(i+1)+" of array: ",Integer.MIN_VALUE,Integer.MAX_VALUE) ;
        }
        return a;
    }
    public static void selectionSort(int[]a){
         int lowest, lowestIndex;
        for(int i = 0; i < a.length; i++) {
            lowestIndex = i;
            for(int j = i; j < a.length; j++) {
                if(a[j] < a[lowestIndex]) {
                    lowestIndex = j;
                }
            }

            if(i != lowestIndex) {
                int temp = a[i];
                a[i] = a[lowestIndex];
                a[lowestIndex] = temp;
            }
            
        }
    }
    
    public static void main(String[] args) {
        int size= inputInt("Enter size of array(>0):",1,Integer.MAX_VALUE);
        int[]a= createArray(size);
        
        System.out.print("Unsorted array: [");
        for(int i=0;i<size-1;i++)
            System.out.print(a[i]+", ");
        System.out.println(a[size-1]+"]"); 
        System.out.print("Sorted array: [");
        selectionSort(a);
        for(int i=0;i<size-1;i++)
            System.out.print(a[i]+", "); 
        System.out.println(a[size-1]+"]");
    }
}
