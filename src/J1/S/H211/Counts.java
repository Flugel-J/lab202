/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H211;
import java.util.Scanner;
/**
 *
 * @author dell
 */
public class Counts {
    public static Scanner sc = new Scanner(System.in);

   
  
public static void main(String[] args) {
            System.out.println("Enter Size:");
            int size =sc.nextInt();
            System.out.println("Enter element data:");
            int[] elementData = new int[size];
            for(int i=0; i<size; i++){
                elementData[i]= sc.nextInt();
            }
            ArrayIntList list = new ArrayIntList(size,elementData);
            ArrayIntList list2 = list.fromCounts();
            System.out.println(list);
            System.out.println(list2);
        }
}
